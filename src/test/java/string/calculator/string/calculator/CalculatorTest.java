package string.calculator.string.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void testEmptyString1() {
		Assert.assertEquals(0, Calculator.add(""));
	}
	
	@Test
	public void testEmptyString2() {
		Assert.assertEquals(0, Calculator.add("     "));
	}
}
