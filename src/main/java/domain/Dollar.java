package domain;

public class Dollar extends Money{

	public String currency(){
		return "USD";			
	}
	
	public Dollar(int amount) {
		this.amount = amount;
		this.currency = currency();
	}

	public Dollar times(int multiplier) {
		Dollar product = new Dollar(amount * multiplier);
		return product;
		

	}
}
