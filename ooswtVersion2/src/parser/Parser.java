package parser;

import java.util.List;

import exceptions.SymbolException;
import expression.Expression;
import symbol.Symbol;
import symbol.SymbolVisitor;

/*
 * Parser that converts a list of symbols to an arithmetic expression
 * throws SymbolError if syntax is wrong
 */
public abstract class Parser implements SymbolVisitor {
	private List<Symbol> symbols;
	
	/*
	 * constructor
	 */
	public Parser(List<Symbol> symbols) {
		this.symbols = symbols;
	}

	/*
	 * removes the first symbol
	 */
	public void skip() {
		this.symbols.remove(0);
	}
	
	/*
	 * returns the first symbol of the list
	 */
	public Symbol getCurrentSymbol() {
		return this.symbols.get(0);
	}
	
	/*
	 * returns the current list of symbols
	 */
	public List<Symbol> getSymbols() {
		return this.symbols;
	}
	
	/*
	 * converts a List of symbols into an arithmetic expression
	 */
	public abstract Expression toExpression() throws SymbolException;
	
	/*
	 * throws new SymbolException when unexpected symbols appear
	 */
	public abstract void errorHandling(Symbol symbol) throws SymbolException;
}
