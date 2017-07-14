package MiddleLayer;

public class PartValidateStrategy implements IValidateStrategy {
	IValidateElement element;
	@Override
	public void validate(CustomerBase cust) throws Exception {
		element = new CustomerIDElement();
		element = new CustomerNameElement(element);
		element = new CustomerTypeElement(element);
		element.validate(cust);
	}
}
