package domain;

public class Pieniądze { 
	private int amount;

	public Pieniądze(int amount) {
		this.amount = amount;
	}

	public Pieniądze times(int multiplier) {
		Pieniądze product = new Pieniądze(amount * multiplier);
		return product;
		
	}
	
	public boolean equals(Object other){
		Pieniądze dollar = (Pieniądze)other;
		return this.amount == dollar.amount;
	}


}
