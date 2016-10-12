package domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class MoneyTest {

	@Test
	public void testMultiplication(){
		Curr five = Curr.dollar(5);
		assertEquals(Curr.dollar(10), five.times(2));
		assertEquals(Curr.dollar(15), five.times(3));
	}

	@Test
	public void testFrancMultiplication(){
		Curr five = Curr.franc(5);
		assertEquals(Curr.franc(10), five.times(2));
		assertEquals(Curr.franc(15), five.times(3));
	}

	@Test
	public void testEquality(){
		assertEquals(Curr.dollar(5), Curr.franc(5));
		assertNotEquals(Curr.franc(5), Curr.franc(10));
	}
}
