package parser;

import java.util.List;

import exceptions.SymbolException;
import symbol.*;


public class ExpressionParser extends Parser {
	private Expression myExpression;
	
	/*
	 * constructor
	 */
	public ExpressionParser(List<Symbol> symbols) {
		super(symbols);
	}
	/*
	 * converts a Symbol into an Expression
	 */
	public Expression toExpression() throws SymbolException {
		this.myExpression = new SummandParser(super.getSymbols()).toExpression();
		super.getCurrentSymbol().accept(this);
		return this.myExpression;
	}
	
	/*
	 * how to handle a PlusSymbol
	 */
	public void handle(PlusSymbol symbol) throws SymbolException {
		super.skip();
		this.myExpression = new Sum( (Summand) this.myExpression, new ExpressionParser(super.getSymbols()).toExpression());
	}
	
	/*
	 * how to handle EndSymbols
	 */
	public void handle(EndSymbol symbol) {
	}
	
	/*
	 * how to handle RightBracketSymbols 
	 */
	public void handle(RightBracketSymbol symbol) {
	}
	
	/*
	 * how to handle NumberSymbol
	 */
	@Override
	public void handle(NumberSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
		
	/*
	 * how to handle StarSymbol
	 */
	}
	@Override
	public void handle(StarSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
		
	/*
	 * how to handle LeftBracketSymbol
	 */
	}
	@Override
	public void handle(LeftBracketSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
		
	/*
	 * how to handle ErrorToken
	 */
	}
	@Override
	public void handle(ErrorToken symbol) throws SymbolException {
		this.errorHandling(symbol);
		
	/*
	 * how to handle Division Symbol
	 */
	}
	@Override
	public void handle(DivisionSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
	}
	
	/*
	 * throws new SymbolException when unexpected symbols appear
	 */
	@Override
	public void errorHandling(Symbol symbol) throws SymbolException {
		this.errorHandling(symbol);
	}
}
