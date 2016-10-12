package domain;

	public class Curr {
		
	protected int amount;
	
	public boolean equals(Object other){
		
		Curr curr = (Curr)other;
		getClass();
		return curr.amount == this.amount
				&& getClass().equals(other.getClass());
	}
		
	}