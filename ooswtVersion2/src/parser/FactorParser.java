package parser;

import java.util.List;

import exceptions.SymbolException;
import expression.BracketExpression;
import expression.Factor;
import expression.NaturalNumber;
import symbol.*;

/*
 * converts symbols into NaturalNumbers or BracketExpressions
 */
public class FactorParser extends Parser{
	private Factor myFactor;
	
	/*
	 * constructor
	 */
	public FactorParser(List<Symbol> symbols) {
		super(symbols);
	}

	/*
	 * converts a Symbol into an Expression
	 */
	public Factor toExpression() throws SymbolException {
		super.getCurrentSymbol().accept(this);
		return this.myFactor;
	}
	
	/*
	 * how to handle a NumberSymbol
	 */
	public void handle(NumberSymbol symbol) throws SymbolException{
		this.myFactor = new NaturalNumber(Integer.valueOf(symbol.getValue()));
		super.skip();
	}
	
	/*
	 * how to handle a LeftBracketExpression
	 */
	public void handle(LeftBracketSymbol symbol) throws SymbolException {
		super.skip();
		this.myFactor = new BracketExpression(new ExpressionParser(super.getSymbols()).toExpression());
		if(super.getCurrentSymbol().equals(RightBracketSymbol.getInstance())) {
			super.skip();
		}
		else
		{
			throw new SymbolException("missing RightBracketSymbol");
		}
	}

	
	/*
	 * how to handle a PlusSymbol
	 */
	@Override
	public void handle(PlusSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
	}

	/*
	 * how to handle a StarSymbol
	 */
	@Override
	public void handle(StarSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
	}

	/*
	 * how to handle a RightBracketSymbol
	 */
	@Override
	public void handle(RightBracketSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
	}

	/*
	 * how to handle an Error Token
	 */
	@Override
	public void handle(ErrorToken symbol) throws SymbolException {
		this.errorHandling(symbol);	
	}

	/*
	 * how to handle an EndSymbol
	 */
	@Override
	public void handle(EndSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
	}

	/*
	 * how to handle a DivisionSymbol
	 */
	@Override
	public void handle(DivisionSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
	}

	/*
	 * throws new SymbolException when unexpected symbols appear
	 */
	@Override
	public void errorHandling(Symbol symbol) throws SymbolException {
		throw new SymbolException("Gefunden " + symbol.toString() + ", erwartet Zahl oder " + LeftBracketSymbol.getInstance().toString());
	}

}
 