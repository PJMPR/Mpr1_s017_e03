package domain;

public class Franc extends Money {

	public Franc(int amount) {
		this.amount=amount;
	}
	
	public String currency(){
		return "USD";			
	}

	public Franc times(int multiplier) {
		return new Franc(this.amount*multiplier);
	}
	
	

}
