package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void testMultiplication(){
		Dollar five = new Dollar(5);
		assertEquals(new Dollar(10), five.times(2));
		assertEquals(new Dollar(15), five.times(3));
	}
	
	@Test
	public void testEquality(){
		assertEquals(new Dollar(5), new Dollar(5));
		assertNotEquals(new Dollar(5), new Dollar(15));
	}

}
