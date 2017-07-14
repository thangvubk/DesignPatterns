package MiddleLayer;

import MiddleLayer.CustomerBase.STATUS;

public interface ICustomer {
	
	public static String[] getMainAttributes(){
		return new String[]{"ID", "CustomerType", "CustomerName", "PhoneNumber", "BillAmount", "BillTime", "Address"}; 
	}

	public STATUS getStatus();

	public void setStatus(STATUS status);

	public int getID();

	public void setID(String ID);

	public String getCustomerName();

	public void setCustomerName(String customerName);

	public String getPhoneNumber();

	public void setPhoneNumber(String phoneNumber);

	public int getBillAmount();

	public void setBillAmount(String billAmount);

	public String getBillTime();

	public void setBillTime(String billTime);

	public String getAddress();

	public void setAddress(String address);

	public String getCustomerType();

	public void setCustomerType(String customerType);

	public IValidateStrategy getValStr();

	public void setValStr(IValidateStrategy valStr);

	public abstract void validate() throws Exception;

	public ICustomer clone();

	// for unit test purpose
	public void print();
}
