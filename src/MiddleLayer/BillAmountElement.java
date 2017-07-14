package MiddleLayer;

public class BillAmountElement extends ValidateDecorator {

	public BillAmountElement(IValidateElement element) {
		super(element);
	}

	@Override
	public void validate(ICustomer cust) throws Exception {
		element.validate(cust);
		if (cust.getBillAmount() == 0) {
			throw new Exception("Require Bill Amount");
		}
	}
}
