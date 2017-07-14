package Repository;

import java.util.ArrayList;

import MiddleLayer.ICustomer;

// Pattern Unit of Work
public class CustomerTransaction {
	
	private static CustomerTransaction custTran;
	
	private ArrayList<ICustomer> custList;
	private IRepository repo;
	
	private CustomerTransaction(){
		
	}
	public static CustomerTransaction getInstance(){
		if(custTran == null){
			custTran = new CustomerTransaction();
		}
		return custTran;
	}
	public void addCust(ICustomer cust){
		if(custList == null){
			custList = new ArrayList<>();
		}
		custList.add(cust);
	}
	public void commit(){
		if(repo == null){
			repo = new MySQLRepository();
		}
		for(ICustomer cust : custList){
			switch(cust.getStatus()){
			case NEW: 
				repo.addAfterChecked(cust);
				break;
			case CHANGED:
				repo.update(cust);
				break;
			case DELETED:
				repo.remove(cust);
				break;
			default:
				break;
			}
		}
		custList.clear();
	}
}
