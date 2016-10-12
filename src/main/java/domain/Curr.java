package domain;

	public abstract class Curr {
		
	protected int amount;
	
	public boolean equals(Object other){
		
		Curr curr = (Curr)other;
		getClass();
		return curr.amount == this.amount
				&& getClass().equals(other.getClass());
	}
	
	public static Curr dollar(int i){
		return null;
	}
	
	public static Curr franc(int i){
		return null;
	}
	
	public abstract Curr times(int multiplier);
		
	}