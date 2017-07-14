package CLient;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MiddleLayer.ICustomer;

public class ClientUIController extends ControllerBase {

	enum EVENT_CODE {
		ADD_CONTROLLER, UPDATE_DEL_CONTROLLER
	}

	MyActionListener actionListener;
	MyMouseClickListener mouseListener;

	public ClientUIController(JFrame UI) {
		super(UI);
		actionListener = new MyActionListener();
		mouseListener = new MyMouseClickListener();
		registestedController = new ArrayList<>();
	}

	@Override
	public void execute() {
		((ClientUI) UI).addBtListener(actionListener);
		((ClientUI) UI).addTbCustomerInfoListenr(mouseListener);
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			// GetAll button
			if (event.getSource() == ((ClientUI) UI).getBtGetAll()) {
				btGetAllAction();
			}
			// Add button
			else if (event.getSource() == ((ClientUI) UI).getBtAdd()) {
				btAddAction();
			}

			// Save button
			else if (event.getSource() == ((ClientUI) UI).getBtSave()) {
				btSaveAction();
			}

		}

		@SuppressWarnings("unchecked")
		private void btGetAllAction() {
			Iterator<ICustomer> custList;
			// check from cache first
			if (custFactory.getCustomers().hasNext()) {
				custList = custFactory.getCustomers();
			}
			// get from physical memory
			else {
				custList = (Iterator<ICustomer>) repo.get();
				// update cache
				while (custList.hasNext()) {
					ICustomer tempCust = custList.next();
					custFactory.addCustomer(tempCust);
				}
			}
			// insert from cache to table
			insertCustFromCacheToTable();
		}

		private void btAddAction() {
			publishToRegisteredController(EVENT_CODE.ADD_CONTROLLER, null);
		}

		private void btSaveAction() {
			custTran.commit();
			System.out.println("btSaveAction()");
		}

	}

	private void publishToRegisteredController(EVENT_CODE code, Object params) {
		for (IController controller : registestedController) {
			controller.update(code, params);
		}
	}

	private ICustomer readCustFromRow(int idx) {
		DefaultTableModel tableModel = ((ClientUI) UI).getTableModel();
		Object ID = tableModel.getValueAt(idx, tableModel.findColumn("ID"));
		Object customerType = tableModel.getValueAt(idx, tableModel.findColumn("CustomerType"));
		Object customerName = tableModel.getValueAt(idx, tableModel.findColumn("CustomerName"));
		Object phoneNumber = tableModel.getValueAt(idx, tableModel.findColumn("PhoneNumber"));
		Object billAmount = tableModel.getValueAt(idx, tableModel.findColumn("BillAmount"));
		Object billTime = tableModel.getValueAt(idx, tableModel.findColumn("BillTime"));
		Object address = tableModel.getValueAt(idx, tableModel.findColumn("Address"));
		ICustomer cust = custFactory.createCustomer(customerName != null ? customerType.toString() : "");
		cust.setID(ID != null ? ID.toString() : "");
		cust.setCustomerType(customerName != null ? customerType.toString() : "");
		cust.setCustomerName(customerName != null ? customerName.toString() : "");
		cust.setPhoneNumber(phoneNumber != null ? phoneNumber.toString() : "");
		cust.setBillAmount(billAmount != null ? billAmount.toString() : "");
		cust.setBillTime(billTime != null ? billTime.toString() : "");
		cust.setAddress(address != null ? address.toString() : "");
		return cust;

	}

	class MyMouseClickListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("clicked");
			if (e.getSource() == ((ClientUI) UI).getTbCustInfo()) {
				JTable table = (JTable) e.getSource();
				Point p = e.getPoint();
				int row = table.rowAtPoint(p);
				if ((row != -1)) {// && (e.getClickCount() == 2)) {
					// read customer info from table
					ICustomer cust = readCustFromRow(row);
					// publish to observers
					publishToRegisteredController(EVENT_CODE.UPDATE_DEL_CONTROLLER, cust);
				}
			}

		}
	}

	public void insertCustFromCacheToTable() {
		// clear table
		JTable table = ((ClientUI) UI).getTbCustInfo();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
		// insert to table
		Iterator<ICustomer> custList = custFactory.getCustomers();
		while (custList.hasNext()) {
			System.out.println("get here");
			ICustomer tempCust = custList.next();
			addRowToTable(tempCust, tableModel);
		}
		table.setModel(tableModel);
	}

	private void addRowToTable(ICustomer cust, DefaultTableModel tableModel) {
		tableModel.addRow(new String[] { String.valueOf(cust.getID()), cust.getCustomerType(), cust.getCustomerName(),
				cust.getPhoneNumber(), String.valueOf(cust.getBillAmount()), cust.getBillTime(), cust.getAddress() });
	}

	@Override
	public void update(Object code, Object params) {
		try {
			throw new Exception("Unimplemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void returnValueToParent() {
		try {
			throw new Exception("Unimplemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
