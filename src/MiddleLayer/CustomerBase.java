package MiddleLayer;

public abstract class CustomerBase implements ICustomer{
	public enum STATUS{
		NEW, CHANGED, DELETED, NONE
	}
	protected int ID = 0;
	protected String customerName = "";
	protected String phoneNumber = "";
	protected int 	 billAmount = 0;
	protected String billTime = "";
	protected String address = "";
	protected String customerType = "";
	protected IValidateStrategy valStr = null;
	protected STATUS status = null;
	
	public CustomerBase(){
		status = STATUS.NONE;
	}
	
	public CustomerBase(ICustomer cust){
		this.ID 		  = cust.getID();
		this.customerName = cust.getCustomerName();
		this.customerType = cust.getCustomerType();
		this.billAmount   = cust.getBillAmount();
		this.billTime     = cust.getBillTime();
		this.phoneNumber  = cust.getPhoneNumber();
		this.address      = cust.getAddress();
		this.valStr		  = cust.getValStr();
		this.status       = cust.getStatus();
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public IValidateStrategy getValStr() {
		return valStr;
	}

	public void setValStr(IValidateStrategy valStr) {
		this.valStr = valStr;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getID() {
		return ID;
	}

	public void setID(String ID) {
		if(ID.equals("")) {
			this.ID = 0;
		} else {
			try {
				int tempID = Integer.parseInt(ID);
				this.ID = tempID;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		if(billAmount.equals("")) {
			this.billAmount = 0;
		} else {
			try {
				int tempAmt = Integer.parseInt(billAmount);
				this.billAmount = tempAmt;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String getBillTime() {
		return billTime;
	}

	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public abstract void validate() throws Exception;
	
	public abstract ICustomer clone();
	
	public void print(){
		
		System.out.println("Customer Type : " + this.customerType);
		System.out.println("Customer Name : " + this.customerName);
		System.out.println("Bill Amount   : " + this.billAmount);
		System.out.println("Bill Time     : " + this.billTime);
		System.out.println("Phone Number  : " + this.phoneNumber);
		System.out.println("Address       : " + this.address);
		System.out.println("*---------------------------------------*");
	}
	
}
