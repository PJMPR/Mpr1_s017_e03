package domain;

import static org.junit.Assert.*;

import domain.model.Person;
import org.junit.Test;

import java.text.ParseException;

public class MoneyTest {

	@Test
	public void testMultiplication(){
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}
	
	@Test
	public void testFrancMultiplication(){
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	}
	
	@Test
	public void testEquality(){
		assertEquals(Money.dollar(5), Money.dollar(5));
		assertNotEquals(Money.dollar(5), Money.dollar(10));
		assertEquals(Money.franc(5), Money.franc(5));
		assertNotEquals(Money.franc(5), Money.franc(10));
		assertNotEquals(Money.franc(5), Money.dollar(5));
	}
	
	@Test
	public void testCurrency(){
		assertEquals("USD" , Money.dollar(1).currency());
		assertEquals("CHF" , Money.franc(1).currency());
	}
	
	@Test
	public void testPlusReturnSum(){
		Money five = Money.dollar(5);
		Money ten = Money.dollar(10);
		Expression result = five.plus(ten);
		Sum sum = (Sum)result;
		assertEquals(five, sum.augend);
		assertEquals(ten, sum.addend);
		
	}
	
	@Test
	public void testSimpleAddition(){
		Money five = Money.dollar(5);
		
		Expression sum = five.plus(five);
		
		Bank bank = new Bank();
		
		Money result = bank.reduce(sum, "USD");
		
		assertEquals(result,  Money.dollar(10));
	}
	
	@Test
	public void testReduceMoney(){
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), "USD");
		assertEquals(result, Money.dollar(1));
		
	}
	
	@Test
	public void testReduceMoneyDifferentCurrency(){
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}

	@Test
	public void test_Addition_With_Different_Currency(){
		Money fiveBucks = Money.dollar(5);
		Money tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.dollar(10), result);
	}
	@Test
	public void testSumPlusMoney(){
		Money fiveBucks = Money.dollar(5);
		Money tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
		
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(15), result);
		
	}

	@Test
	public void testSumPlusMoneyMultiplyByValue(){
		Money fiveBucks = Money.dollar(5);
		Money tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrancs)
				.times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);
		
	}

	@Test
	public void testIfPeselFormatIsCorrect(){
		Person person = new Person("96112501544");
		assertEquals(true, person.checkPesel());
		assertEquals(true, person.checkPeselLength());
	}

	@Test
	public void testIfGenderCorrect(){
		Person person = new Person("96112501544");
		assertEquals(Person.Gender.Female, person.getGender() );
	}

	@Test
	public void testIfDayOfBirthCorrect() throws ParseException{
		Person person = new Person("96112501544");
		assertEquals("96/11/25", person.getDayOfBirth());
	}

	@Test
	public void testIfAgeCorrectlyCalculated() throws ParseException{
		Person person = new Person("96112501544");
		assertEquals(19,person.getAge());
	}

}

























