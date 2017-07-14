package MiddleLayer;

public class CustomerIDElement implements IValidateElement{

	@Override
	public void validate(ICustomer cust) throws Exception {
		if(cust.getID() == 0){
			throw new Exception("Require customer ID");
		}
	}

}
