package MiddleLayer;

public class CustomerNameElement extends ValidateDecorator{
	
	public CustomerNameElement(IValidateElement element) {
		super(element);
	}

	@Override
	public void validate(ICustomer cust) throws Exception {
		element.validate(cust);
		if(cust.getCustomerName().equals("")){
			throw new Exception("Require Customer Name");
		}
	}
}
