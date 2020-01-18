package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import exceptions.DivisionException;
import exceptions.SymbolException;
import parser.ExpressionParserProxy;
import scanner.Scanner;
import symbol.Symbol;

public class ParserTest {

	Scanner scanner = Scanner.getScanner();
	ExpressionParserProxy parser = new ExpressionParserProxy();
		

	@Test
	public void evaluateNumber() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("5");
		assertEquals(new Integer(5),parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluateSum() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("5+5");
		assertEquals(new Integer(10),parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluateProduct() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("5*5");
		assertEquals(new Integer(25),parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluatePunktvorStrich() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("5*5+2");
		assertEquals(new Integer(27),parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluatePvS2() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("3*2+1");
		assertEquals(new Integer(7), parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluateKlammer() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("(3*2)");
		assertEquals(new Integer(6), parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluateKlammer2() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("(1)");
		assertEquals(new Integer(1), parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluateKlammer3() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("3* (5*5)");
		assertEquals(new Integer(75), parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluateKlammer4() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("(5+5)*3");
		assertEquals(new Integer(30), parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluateKlammer5() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("(2+5)*(4+3)");
		assertEquals(new Integer(49), parser.toExpression(liste).evaluate());
	}
		
	@Test
	public void evaluateKlammer6()  throws SymbolException {
		List<Symbol> liste = scanner.toSymbolSequence("5+5)");
		assertThrows(SymbolException.class, () ->  parser.toExpression(liste));
	}
		
	@Test
	public void evaluateKlammer7()  throws SymbolException  {
		List<Symbol> liste = scanner.toSymbolSequence("(5+5");
		assertThrows(SymbolException.class, () -> parser.toExpression(liste));
	}
		
	@Test
	public void evaluateKlammer8()  throws SymbolException  {
		List<Symbol> liste = scanner.toSymbolSequence("1+1)+1");
		assertThrows(SymbolException.class,() -> parser.toExpression(liste));
	}
		
	@Test
	public void evaluatePlus()  throws SymbolException  {
		List<Symbol> liste = scanner.toSymbolSequence("5++5");
		assertThrows(SymbolException.class, () -> parser.toExpression(liste));
	}
		
	@Test
	public void evaluatePlus2()  throws SymbolException  {
		List<Symbol> liste = scanner.toSymbolSequence("5+5+");
		assertThrows(SymbolException.class, () -> parser.toExpression(liste));
	}
		
	@Test
	public void evaluateEmpty()  throws SymbolException  {
		List<Symbol> liste = scanner.toSymbolSequence("");
		assertThrows(SymbolException.class, () -> parser.toExpression(liste));
	}
		
	@Test
	public void evaluatePlusOne()  throws SymbolException  {
		List<Symbol> liste = scanner.toSymbolSequence("+1");
		assertThrows(SymbolException.class, () -> parser.toExpression(liste));
	}
		
	@Test
	public void evaluateMultiplication()  throws SymbolException  {
		List<Symbol> liste = scanner.toSymbolSequence("1*1*");
		assertThrows(SymbolException.class, () -> parser.toExpression(liste));
	}
		
	@Test
	public void evaluateError()  throws SymbolException  {
		List<Symbol> liste = scanner.toSymbolSequence("1* Hallo 1");
		assertThrows(SymbolException.class, () -> parser.toExpression(liste), "falsche Eingabe");
	}
		
	@Test
	public void evaluateKlammer9() throws SymbolException, DivisionException {
		List<Symbol> liste = scanner.toSymbolSequence("3 * ((2+2)*4)");
		assertEquals(new Integer(48), parser.toExpression(liste).evaluate());
	}

}
