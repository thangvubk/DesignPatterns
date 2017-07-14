package MiddleLayer;

public class AddressElement extends ValidateDecorator{
	

	public AddressElement(IValidateElement element) {
		super(element);
	}

	@Override
	public void validate(ICustomer cust) throws Exception {
		element.validate(cust);
		if(cust.getAddress().equals("")){
			throw new Exception("Require Address");
		}
	}
}