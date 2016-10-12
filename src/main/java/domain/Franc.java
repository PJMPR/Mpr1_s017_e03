package domain;

public class Franc {

	private int amount;
	public Franc(int amount) {
		this.amount=amount;
	}

	public Franc times(int multiplier) {
		return new Franc(this.amount*multiplier);
	}
	
	public boolean equals(Object other){
		Franc franc = (Franc) other;
		return franc.amount==this.amount;
	}

}