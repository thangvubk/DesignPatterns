package Repository;

import CustomerFactory.ICustomerIterator;

public abstract class RepositoryBase implements IRepository, ICustomerIterator{
	@Override
	public void addAfterChecked(Object obj){
		if(find(obj) == null){
			insert(obj);
		}
		System.out.println("addAfterChecked");
	}
}