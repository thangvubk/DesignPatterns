package MiddleLayer;

public class Customer extends CustomerBase {
	public Customer() {
		super();
	}

	public Customer(ICustomer cust) {
		super(cust);
	}

	@Override
	public void validate() throws Exception {
		if (valStr == null) {
			valStr = new FullValidateStrategy();
		}
		valStr.validate(this);
	}

	@Override
	public ICustomer clone() {
		return new Customer(this);
	}
}
