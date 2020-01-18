package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import scanner.Scanner;
import symbol.*;

/*
 * testing of the package scanner and symbol
 */
class ScannerTest {
	
	@Test
	void scannerTest1() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(new NumberSymbol(5));
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("5");
		assertEquals(symbolList, result);
	}
	
	@Test
	void scannerTest2() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(new NumberSymbol(5));
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("  5  ");
		assertEquals(symbolList, result);
	}

	@Test
	void scannerTest3() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(new NumberSymbol(5));
		symbolList.add(PlusSymbol.getInstance());
		symbolList.add(new NumberSymbol(5));
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("5+5");
		assertEquals(symbolList, result);
	}
	
	@Test
	void scannerTest4() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(new NumberSymbol(5));
		symbolList.add(PlusSymbol.getInstance());
		symbolList.add(new NumberSymbol(5));
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("  5 +             5");
		assertEquals(symbolList, result);
	}
	
	@Test
	void scannerTest5() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(new NumberSymbol(27));
		symbolList.add(StarSymbol.getInstance());
		symbolList.add(new NumberSymbol(27));
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("27*27");
		assertEquals(symbolList, result);
	}
	
	@Test
	void scannerTest6() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence(" ");
		assertEquals(symbolList, result);
	}
	
	@Test
	void scannerTest7() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("");
		assertEquals(symbolList, result);
	}
	
	@Test
	void bracketTest1() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(LeftBracketSymbol.getInstance());
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("(");
		assertEquals(symbolList, result);
	}
	
	@Test
	void bracketTest2() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(RightBracketSymbol.getInstance());
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence(")");
		assertEquals(symbolList, result);
	}
	
	@Test
	void bracketTest3() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(LeftBracketSymbol.getInstance());
		symbolList.add(new NumberSymbol(178));
		symbolList.add(RightBracketSymbol.getInstance());
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("(178)");
		assertEquals(symbolList, result);
	}
	
	@Test
	void bracketTest4() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(LeftBracketSymbol.getInstance());
		symbolList.add(new NumberSymbol(178));
		symbolList.add(StarSymbol.getInstance());
		symbolList.add(new NumberSymbol(14));
		symbolList.add(RightBracketSymbol.getInstance());
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("(178 *14)");
		assertEquals(symbolList, result);
	}
	
	@Test
	void bracketTest5() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(LeftBracketSymbol.getInstance());
		symbolList.add(LeftBracketSymbol.getInstance());
		symbolList.add(new NumberSymbol(178));
		symbolList.add(StarSymbol.getInstance());
		symbolList.add(new NumberSymbol(14));
		symbolList.add(RightBracketSymbol.getInstance());
		symbolList.add(RightBracketSymbol.getInstance());
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("((178 *14))");
		assertEquals(symbolList, result);
	}
	
	@Test
	void errorTokenTest1() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(new ErrorToken("huurz!"));
		Scanner scanner = Scanner.getScanner();
		List <Symbol> result = scanner.toSymbolSequence(" huurz!   ");
		assertEquals(symbolList, result);
	}
	
	@Test
	void errorTokenTest2() {
		List<Symbol> symbolList = new ArrayList<Symbol>();
		symbolList.add(new NumberSymbol(5));
		symbolList.add(PlusSymbol.getInstance());
		symbolList.add(new NumberSymbol(5));
		symbolList.add(new ErrorToken("!"));
		Scanner scanner = Scanner.getScanner();
		List<Symbol> result = scanner.toSymbolSequence("5+5!");
		assertEquals(symbolList, result);
	}
	
	@Test
	void equalsTest1() {
		NumberSymbol one = new NumberSymbol(17);
		NumberSymbol two = new NumberSymbol(15);
		assertFalse(one.equals(two));
	}
	
	@Test
	void equalsTest2() {
		NumberSymbol one = new NumberSymbol(17);
		NumberSymbol two = new NumberSymbol(17);
		assertTrue(one.equals(two));
	}
	
	@Test
	void equalsTest3() {
		NumberSymbol one = new NumberSymbol(17);
		NumberSymbol two = new NumberSymbol(15);
		assertFalse(two.equals(one));
	}
	
	@Test
	void equalsTest4() {
		NumberSymbol one = new NumberSymbol(17);
		NumberSymbol two = new NumberSymbol(17);
		assertTrue(two.equals(one));
	}
	
	@Test
	void equalsTest5() {
		ErrorToken one = new ErrorToken("falsch");
		ErrorToken two = new ErrorToken("richtig");
		assertFalse(one.equals(two));
	}
	
	@Test
	void equalsTest6() {
		ErrorToken one = new ErrorToken("falsch");
		ErrorToken two = new ErrorToken("richtig");
		assertFalse(two.equals(one));
	}
	
	@Test
	void equalsTest7() {
		ErrorToken one = new ErrorToken("falsch");
		ErrorToken two = new ErrorToken("falsch");
		assertTrue(two.equals(one));
	}
	
	@Test
	void equalsTest8() {
		ErrorToken one = new ErrorToken("falsch");
		ErrorToken two = new ErrorToken("falsch");
		assertTrue(one.equals(two));
	}

}
