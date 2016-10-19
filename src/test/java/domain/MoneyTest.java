package domain;

import static org.junit.Assert.*;

import org.junit.Test;

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
	public void test_Constructing_Money_With_Currency(){
		
		Money dollar = Money.dollar(1);
		Money franc = Money.franc(1);
		assertEquals("USD", dollar.currency);
		assertEquals("CHF", franc.currency);
		
	}

}
