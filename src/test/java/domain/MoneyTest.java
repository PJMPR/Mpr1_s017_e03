package domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class MoneyTest {

	@Test
	public void testMultiplication(){
		Franc five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));
	}

	@Test
	public void testFrancMultiplication(){
		Franc five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));
	}

	@Test
	public void testEquality(){
		assertEquals(new Franc(5), new Franc(5));
		assertNotEquals(new Franc(5), new Franc(10));
	}
}
