package MiddleLayer;

public class FullValidateStrategy implements IValidateStrategy{
	IValidateElement element;
	@Override
	public void validate(CustomerBase cust) throws Exception {
		element = new CustomerIDElement();
		element = new CustomerNameElement(element);
		element = new CustomerTypeElement(element);
		element = new PhoneNumberElement(element);
		element = new BillAmountElement(element);
		element = new BillTimeElement(element);
		element = new AddressElement(element);
		element.validate(cust);
	}
}
