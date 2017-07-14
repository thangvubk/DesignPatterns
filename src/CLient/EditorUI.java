package CLient;

import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CustomerFactory.CustomerFactory;

public class EditorUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected JTextField tAddress;
	protected JTextField tBillTime;
	protected JTextField tBillAmt;
	protected JTextField tCustPhone;
	protected JTextField tCustName;
	protected JComboBox<String> cbCustType;
	protected JTextField tID;

	public EditorUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 800, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("ID ");
		lblNewLabel_2.setBounds(50, 50, 150, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Customer Type");
		lblNewLabel.setBounds(50, 100, 150, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setBounds(50, 150, 150, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblCustomerName = new JLabel("Customer Number");
		lblCustomerName.setBounds(50, 200, 150, 14);
		contentPane.add(lblCustomerName);

		JLabel lblBillAmount = new JLabel("Bill Amount");
		lblBillAmount.setBounds(400, 50, 150, 14);
		contentPane.add(lblBillAmount);

		JLabel lblBillData = new JLabel("Bill Time");
		lblBillData.setBounds(400, 100, 150, 14);
		contentPane.add(lblBillData);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(400, 150, 150, 14);
		contentPane.add(lblAddress);

		tID = new JTextField();
		tID.setBounds(200, 50, 150, 20);
		contentPane.add(tID);
		tID.setColumns(10);

		cbCustType = new JComboBox<>(CustomerFactory.getCustomerType());
		cbCustType.setBounds(200, 100, 150, 20);
		cbCustType.setSelectedIndex(-1);
		contentPane.add(cbCustType);

		tCustName = new JTextField();
		tCustName.setBounds(200, 150, 150, 20);
		contentPane.add(tCustName);
		tCustName.setColumns(10);

		tCustPhone = new JTextField();
		tCustPhone.setBounds(200, 200, 150, 20);
		contentPane.add(tCustPhone);
		tCustPhone.setColumns(10);

		tBillAmt = new JTextField();
		tBillAmt.setBounds(550, 50, 150, 20);
		contentPane.add(tBillAmt);
		tBillAmt.setColumns(10);

		tBillTime = new JTextField();
		tBillTime.setBounds(550, 100, 150, 20);
		contentPane.add(tBillTime);
		tBillTime.setColumns(10);

		tAddress = new JTextField();
		tAddress.setBounds(550, 150, 150, 20);
		contentPane.add(tAddress);
		tAddress.setColumns(10);
		//setVisible(true);

	}
	
	public void showMessage(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	
	
	public void addCbCustTypeListener(ItemListener itemListener){
		cbCustType.addItemListener(itemListener);
	}

	public JTextField gettAddress() {
		return tAddress;
	}

	public void settAddress(JTextField tAddress) {
		this.tAddress = tAddress;
	}

	public JTextField gettBillTime() {
		return tBillTime;
	}

	public void settBillTime(JTextField tBillTime) {
		this.tBillTime = tBillTime;
	}

	public JTextField gettBillAmt() {
		return tBillAmt;
	}

	public void settBillAmt(JTextField tBillAmt) {
		this.tBillAmt = tBillAmt;
	}

	public JTextField gettCustPhone() {
		return tCustPhone;
	}

	public void settCustPhone(JTextField tCustPhone) {
		this.tCustPhone = tCustPhone;
	}

	public JTextField gettCustName() {
		return tCustName;
	}

	public void settCustName(JTextField tCustName) {
		this.tCustName = tCustName;
	}

	public JComboBox<String> getCbCustType() {
		return cbCustType;
	}

	public void setCbCustType(JComboBox<String> cbCustType) {
		this.cbCustType = cbCustType;
	}

	public JTextField gettID() {
		return tID;
	}

	public void settID(JTextField tID) {
		this.tID = tID;
	}

}
