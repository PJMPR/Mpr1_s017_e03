package domain;

public class Currency {
	protected int amount;
	
	public boolean equals(Object other)
	{
		Currency currency = (Currency)other;
		return currency.amount==this.amount;
	}
}
