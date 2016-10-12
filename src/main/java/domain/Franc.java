package domain;

public class Franc extends Curr{

	public Franc(int amount) {
	
		this.amount = amount;
	}

	public Franc times(int multiplier) {
		Franc product = new Franc(amount * multiplier);
		return product;
	}
}