package domain;

import static org.junit.Assert.*;

import domain.model.Person;
import org.junit.Test;

import java.util.GregorianCalendar;

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
	public void testPersonPesel() {
        Person person = new Person();
        person.setPesel("96032184313");
        assertEquals(true,person.checkPesel());
        assertEquals(Person.Gender.Male,person.getGender());
        assertEquals(20,person.getAge());
        assertEquals(new GregorianCalendar(1996,3,21),person.getDayOfBirth());

		Person person2 = new Person();
		person2.setPesel("05321577701");
		assertEquals(true,person2.checkPesel());
		assertEquals(Person.Gender.Female,person2.getGender());
		assertEquals(11,person2.getAge());
		assertEquals(new GregorianCalendar(2005,12,15),person2.getDayOfBirth());
	}
}

























