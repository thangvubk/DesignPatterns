package CustomerFactory;

import java.util.Iterator;

import MiddleLayer.ICustomer;

//Iterator Pattern
public interface ICustomerIterator {
	public Iterator<ICustomer> createIterator();
}
