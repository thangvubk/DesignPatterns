package CLient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;

import CLient.ClientUIController.EVENT_CODE;
import MiddleLayer.CustomerBase.STATUS;
import MiddleLayer.ICustomer;


//top level controller
public class AddUIController extends ControllerBase {
	
	
	
	private ICustomer cust;
	MyActionListener listener;
	MyItemListener itemListener;
	public AddUIController(JFrame UI) {
		super(UI);
		listener = new MyActionListener();
		itemListener = new MyItemListener();
	}

	@Override
	public void execute() {
		((AddUI)UI).addBtAddListener(listener);
		((AddUI)UI).addCbCustTypeListener(itemListener);
	}

	private void setCustomer() {
		cust.setID(((AddUI)UI).gettID().getText());
		cust.setAddress(((AddUI)UI).gettAddress().getText());
		cust.setBillAmount(((AddUI)UI).gettBillAmt().getText());
		cust.setBillTime(((AddUI)UI).gettBillTime().getText());
		cust.setCustomerName(((AddUI)UI).gettCustName().getText());
		cust.setCustomerType(((AddUI)UI).getCbCustType().getSelectedItem().toString());
		cust.setPhoneNumber(((AddUI)UI).gettCustPhone().getText());
	}

	
	private class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ((AddUI)UI).getBtAdd()) {
				btAddAction();
			}
		}

		private void btAddAction() {
			
			try {
				cust = custFactory.createCustomer(((AddUI)UI).cbCustType.getSelectedItem().toString());
				setCustomer();
				cust.validate();
				// update cache
				custFactory.addCustomer(cust);
				// track change
				cust.setStatus(STATUS.NEW);
				custTran.addCust(cust);
				
				// update view
				returnValueToParent();
				
				//close view
				((AddUI)UI).dispose();
			} catch (Exception e) {
				((AddUI)UI).showMessage(e.getMessage() + "");
			}
		}
	}

	public void setUIVisible(boolean isVisible) {
		((AddUI)UI).setVisible(isVisible);
	}

	public class MyItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent item) {
			if (item.getSource() == ((EditorUI)UI).getCbCustType()) {
				cbCustTypeAction(item);
			}
		}

		private void cbCustTypeAction(ItemEvent item) {
			if (item.getStateChange() == ItemEvent.SELECTED) {
				cust = custFactory.createCustomer(item.getItem().toString());
			}
		}
	}

	
	@Override
	public void update(Object code, Object params) {
		if(code == EVENT_CODE.ADD_CONTROLLER){
			UI.setVisible(true);
		}
	}

	@Override
	public void returnValueToParent() {
		((ClientUIController)parentController).insertCustFromCacheToTable();
	}

}
