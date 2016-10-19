package domain;

public class Dollar extends Money{

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int multiplier) {
		Dollar product = new Dollar(amount * multiplier);
		return product;
		
	}
}
