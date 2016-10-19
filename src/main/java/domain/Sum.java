package domain;

public class Sum implements Expression {
	
	

	public Sum(Money augend, Money addend) {
		
		this.addend = addend;
		this.augend = augend;
		
	}

	public Money addend;
	public Money augend;

}
