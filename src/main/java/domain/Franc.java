package domain;

public class Franc extends Money {

	public String currency(){
		return "CHD";			
	}
	
	public Franc(int amount) {
		this.amount=amount;
		this.currency = currency();
	}

	
	public Franc times(int multiplier) {
		return new Franc(this.amount*multiplier);
	}
	
	

}
