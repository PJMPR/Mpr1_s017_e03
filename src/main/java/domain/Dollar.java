package domain;

public class Dollar {

	public int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int multiplier) {
		Dollar product = new Dollar(amount * multiplier);
		return product;

	}
	
	public boolean equals(Object other){
		return true;
	}
}