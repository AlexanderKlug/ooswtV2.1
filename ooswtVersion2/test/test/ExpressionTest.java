package test;

import parser.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import exceptions.DivisionException;

/*
 * testing of arithmetic expressions
 */
public class ExpressionTest {
	
	@Test
	void expressionTest1() throws DivisionException {
		NaturalNumber number = new NaturalNumber(5);
		assertEquals(5, number.evaluate());
	}
	
	@Test
	void sumTest1() throws DivisionException {
		NaturalNumber number1 = new NaturalNumber(5);
		NaturalNumber number2 = new NaturalNumber(5);
		Sum sum1 = new Sum(number1, number2);
		assertEquals(10, sum1.evaluate());
	}

	@Test
	void sumTest2() throws DivisionException {
		Summand number1 = new NaturalNumber(5);
		Expression number2 = new NaturalNumber(5);
		Sum sum1 = new Sum(number1, number2);
		assertEquals(10, sum1.evaluate());
	}
	
	@Test
	void sumTest3() throws DivisionException {
		Summand number1 = new NaturalNumber(5);
		Expression number2 = new NaturalNumber(5);
		Expression sum1 = new Sum(number1, number2);
		Sum sum2 = new Sum(number1, sum1);
		assertEquals(15, sum2.evaluate());
	}
	
	@Test
	void sumTest4() throws DivisionException {
		Summand number1 = new NaturalNumber(5);
		Expression number2 = new NaturalNumber(5);
		Expression sum1 = new Sum(number1, number2);
		
		Factor factor1 = new NaturalNumber(3);
		Summand factor2 = new NaturalNumber(2);
		Product product = new Product(factor1, factor2);
		
		Sum sum2 = new Sum(product, sum1);
		
		assertEquals(16, sum2.evaluate());
	}
	
	@Test
	void divisionTest1() throws DivisionException {
		Factor factor = new NaturalNumber(4);
		Summand summand = new NaturalNumber(2);
		Quotient quotient = new Quotient(factor, summand);
		
		assertEquals(2, quotient.evaluate());
	}
	
	@Test
	void divisionTest2(){
		try {
		Factor factor = new NaturalNumber(4);
		Summand summand = new NaturalNumber(0);
		Quotient quotient = new Quotient(factor, summand);
		quotient.evaluate();
		fail("Fehler keine Exception");
		} catch (Exception e) {
			assertEquals(e.getClass(), DivisionException.class);
		}
	
	}
}
