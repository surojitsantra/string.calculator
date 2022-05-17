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

	@Test
	public void testWithOneNumber() {
		Assert.assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testWithTwoNumbers() {
		Assert.assertEquals(9, Calculator.add("4,5"));
	}

	@Test
	public void testWithThreeNumbers() {
		Assert.assertEquals(24, Calculator.add("9,2,13"));
	}

	@Test
	public void testNewLine() {
		Assert.assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testNegativeNumber() {
		try {
			Calculator.add("-1,2");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(e.getMessage(), "negatives not allowed -1");
		}

		try {
			Calculator.add("12,-4,30,-15");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(e.getMessage(), "negatives not allowed -4,-15");
		}
	}

	@Test
	public void testOtherDelimiter() {
		Assert.assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testInputOverFlow() {
		try {
			Calculator.add("1," + String.valueOf(Long.MAX_VALUE - 1000));
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(e.getMessage(), "Inuput number got overflow of Integer");
		}
	}

	@Test
	public void testSumOverFlow() {
		try {
			Calculator.add("100000," + String.valueOf(Integer.MAX_VALUE));
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(e.getMessage(), "Summation got overflow");
		}
	}
}
