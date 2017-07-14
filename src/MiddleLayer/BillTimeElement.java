package MiddleLayer;

public class BillTimeElement extends ValidateDecorator{

	public BillTimeElement(IValidateElement element) {
		super(element);
	}

	@Override
	public void validate(ICustomer cust) throws Exception {
		element.validate(cust);
		if(cust.getBillTime().equals("")){
			throw new Exception("Require Bill Time");
		}
	}
}