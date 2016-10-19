package domain;

public class Bank {

	public Money reduce(Expression expression, String currency) {
		Sum sum = (Sum) expression;
		
		return new Money(sum.addend.amount + sum.augend.amount, currency);
	}

}
