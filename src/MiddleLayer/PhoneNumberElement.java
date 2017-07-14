package MiddleLayer;

public class PhoneNumberElement extends ValidateDecorator{
	
	public PhoneNumberElement(IValidateElement element) {
		super(element);
	}

	@Override
	public void validate(ICustomer cust) throws Exception {
		element.validate(cust);
		if(cust.getPhoneNumber().equals("")){
			throw new Exception("Require Phone Number");
		}
	}
}
