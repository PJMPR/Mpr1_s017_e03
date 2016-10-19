package domain;

public class Dollar extends Money{

	public Dollar(int amount) {
		this.amount = amount;
		this.currency="USD";
	}

	public Dollar times(int multiplier) {
		Dollar product = new Dollar(amount * multiplier);
		return product;
		
	}
	public String currency(String string) {
		return "USD";
	}

	
}
