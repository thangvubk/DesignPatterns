package MiddleLayer;

public class ValidateDecorator implements IValidateElement{
	protected IValidateElement element;
	public ValidateDecorator(IValidateElement element) {
		this.element = element;
	}
	@Override
	public void validate(ICustomer cust) throws Exception {
		element.validate(cust);
	}
}
