package MiddleLayer;

public class Lead extends CustomerBase{
	
	public Lead(){
	}

	public Lead(ICustomer cust) {
		super(cust);
	}

	@Override
	public void validate() throws Exception {
		if(valStr == null){
			valStr = new PartValidateStrategy();
		}
		valStr.validate(this);
	}

	@Override
	public ICustomer clone() {
		return new Lead(this);
	}
}
