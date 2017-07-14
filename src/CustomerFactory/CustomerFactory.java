package CustomerFactory;

import java.util.HashMap;
import java.util.Iterator;

import MiddleLayer.Customer;
import MiddleLayer.ICustomer;
import MiddleLayer.Lead;

public class CustomerFactory implements ICustomerIterator{
	private static String[] customerType;
	private HashMap<String, ICustomer> hash; // Store Customer prototype
	private HashMap<Integer, ICustomer> customers; // Store Customer List with
													// ID and Object
	private static CustomerFactory instance = null;

	private CustomerFactory() {
		customers = new HashMap<>();
	}

	public static CustomerFactory getInstance() {
		if (instance == null) {
			instance = new CustomerFactory();
		}
		return instance;
	}

	public static String[] getCustomerType() {
		if (customerType == null) {
			customerType = new String[] { "Lead", "Customer" };
		}
		return customerType;
	}

	public ICustomer createCustomer(String type) {
		if (hash == null) {
			getCustomerType();
			hash = new HashMap<>();
			hash.put(customerType[0], new Lead());
			hash.put(customerType[1], new Customer());
		}
		return (ICustomer) hash.get(type).clone();
	}

	public void addCustomer(ICustomer cust) {
		customers.put(cust.getID(), cust);
	}

	public void updateCustomer(ICustomer cust) {
		customers.put(cust.getID(), cust);
	}

	public void deleteCutomer(ICustomer cust) {
		customers.remove(cust.getID());
	}
	
	public ICustomer findCustomer(ICustomer cust){
		return customers.get(cust.getID());
	}

	public Iterator<ICustomer> getCustomers() {
		return createIterator();
	}

	public void setCustomers(HashMap<Integer, ICustomer> customers) {
		this.customers = customers;
	}

	@Override
	public Iterator<ICustomer> createIterator() {
		return customers.values().iterator();
	}
}
