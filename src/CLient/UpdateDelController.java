package CLient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import CLient.ClientUIController.EVENT_CODE;
import MiddleLayer.CustomerBase.STATUS;
import MiddleLayer.ICustomer;

public class UpdateDelController extends ControllerBase {
	MyActionListener listener;
	ICustomer cust;

	public UpdateDelController(JFrame UI) {
		super(UI);
		listener = new MyActionListener();

	}

	@Override
	public void execute() {
		((UpdateDeleteUI) UI).addBtUpdateDelAction(listener);

	}

	private void portCustomerToUI() {
		((EditorUI) UI).gettID().setText(String.valueOf(cust.getID()));
		((EditorUI) UI).gettAddress().setText(cust.getAddress());
		((EditorUI) UI).gettBillAmt().setText(String.valueOf(cust.getBillAmount()));
		((EditorUI) UI).gettBillTime().setText(cust.getBillTime());
		((EditorUI) UI).gettCustName().setText(cust.getCustomerName());
		((EditorUI) UI).gettCustPhone().setText(cust.getPhoneNumber());
		JComboBox<String> comboBox = ((EditorUI) UI).getCbCustType();
		comboBox.getModel().setSelectedItem(cust.getCustomerType());
	}

	private void setCustomer() {
		cust.setID(((UpdateDeleteUI) UI).gettID().getText());
		cust.setAddress(((UpdateDeleteUI) UI).gettAddress().getText());
		cust.setBillAmount(((UpdateDeleteUI) UI).gettBillAmt().getText());
		cust.setBillTime(((UpdateDeleteUI) UI).gettBillTime().getText());
		cust.setCustomerName(((UpdateDeleteUI) UI).gettCustName().getText());
		cust.setCustomerType(((UpdateDeleteUI) UI).getCbCustType().getSelectedItem().toString());
		cust.setPhoneNumber(((UpdateDeleteUI) UI).gettCustPhone().getText());
	}

	private class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ((UpdateDeleteUI) UI).getBtDelete()) {
				btDeleteAction();
			} else if (e.getSource() == ((UpdateDeleteUI) UI).getBtUpdate()) {
				btUpdateAction();
			}

			// update parrent view
			returnValueToParent();
			((UpdateDeleteUI) UI).dispose();

		}

		private void btDeleteAction() {
			// delete in cache
			custFactory.deleteCutomer(cust);
			// track change
			cust.setStatus(STATUS.DELETED);
			custTran.addCust(cust);

		}

		private void btUpdateAction() {

			try {
				cust = custFactory.createCustomer(((UpdateDeleteUI) UI).getCbCustType().getSelectedItem().toString());
				setCustomer();
				cust.validate();
				// update in cache
				custFactory.updateCustomer(cust);
				// track change
				cust.setStatus(STATUS.CHANGED);
				custTran.addCust(cust);
			} catch (Exception e) {
				((EditorUI)UI).showMessage(e.getMessage());
			}

		}

	}

	@Override
	public void update(Object code, Object params) {
		if (code == EVENT_CODE.UPDATE_DEL_CONTROLLER) {
			UI.setVisible(true);
			cust = (ICustomer) params;
			portCustomerToUI();
		}
	}

	@Override
	public void returnValueToParent() {
		((ClientUIController) parentController).insertCustFromCacheToTable();
	}

}
