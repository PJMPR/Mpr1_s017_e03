package domain;

public class Sum implements Expression {

	public Expression augend;
	public Expression addend;

	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Money reduce(Bank bank, String currency) {
		return new Money(
				addend.reduce(bank, currency).amount
				+ augend.reduce(bank, currency).amount
				,currency);
	}

	public Expression plus(Expression expression) {
		return new Sum(this, expression);
	}

	public Expression times(int multi) {
		return new Sum(
				this.augend.times(multi),
				this.addend.times(multi)
				);
	}

}
