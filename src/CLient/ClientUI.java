package CLient;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import MiddleLayer.ICustomer;

@SuppressWarnings("serial")
public class ClientUI extends JFrame {

	private JPanel contentPane;
	private JButton btGetAll;
	private JTable tbCustInfo;
	private DefaultTableModel tableModel;
	private JButton btAdd;
	private JButton btSave;

	public ClientUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(ICustomer.getMainAttributes());
		tbCustInfo = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(tbCustInfo);
		scrollPane.setBounds(50, 100, 900, 300);
		tbCustInfo.setFillsViewportHeight(true);
		tbCustInfo.setBounds(50, 100, 900, 300);
		contentPane.add(scrollPane);

		btGetAll = new JButton("Get All");
		btGetAll.setBounds(64, 11, 89, 23);
		contentPane.add(btGetAll);

		btAdd = new JButton("Add");
		btAdd.setBounds(186, 11, 89, 23);
		contentPane.add(btAdd);

		btSave = new JButton("Save");
		btSave.setBounds(305, 11, 89, 23);
		contentPane.add(btSave);

		setVisible(true);
	}

	public void setUIVisible(boolean isVisible) {
		setVisible(isVisible);
	}

	// add listener functions
	void addBtListener(ActionListener actionListener) {
		btGetAll.addActionListener(actionListener);
		btAdd.addActionListener(actionListener);
		btSave.addActionListener(actionListener);
	}

	void addTbCustomerInfoListenr(MouseAdapter adapter) {
		tbCustInfo.addMouseListener(adapter);
	}

	// show message box
	void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	// getters and setters

	public JButton getBtGetAll() {
		return btGetAll;
	}

	public void setBtGetAll(JButton btGetAll) {
		this.btGetAll = btGetAll;
	}

	public JTable getTbCustInfo() {
		return tbCustInfo;
	}

	public void setTbCustInfo(JTable tbCustInfo) {
		this.tbCustInfo = tbCustInfo;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JButton getBtAdd() {
		return btAdd;
	}

	public void setBtAdd(JButton btAdd) {
		this.btAdd = btAdd;
	}

	public JButton getBtSave() {
		return btSave;
	}

	public void setBtSave(JButton btSave) {
		this.btSave = btSave;
	}
	
}
