package domain;

public class Dollar extends Curr{

	public Dollar(int amount) {
	
		this.amount = amount;
	}

	public Franc times(int multiplier) {
		Franc product = new Franc(amount * multiplier);
		return product;
	}
}
