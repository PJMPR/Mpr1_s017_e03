package domain;

	public class Curr {
		
	protected int amount;
	
	public boolean equals(Object other){
		
		Curr curr = (Curr)other;
		return curr.amount==this.amount;
	}
		
	}