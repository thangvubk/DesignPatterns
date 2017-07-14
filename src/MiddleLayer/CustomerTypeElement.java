package MiddleLayer;

public class CustomerTypeElement extends ValidateDecorator{
	
	public CustomerTypeElement(IValidateElement element) {
		super(element);
	}

	@Override
	public void validate(ICustomer cust) throws Exception {
		element.validate(cust);
		if (cust.getCustomerType().equals("")) {
			throw new Exception("Require Customer Type");
		}
	}

}
