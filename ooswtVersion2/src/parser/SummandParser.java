package parser;

import java.util.List;

import exceptions.SymbolException;
import symbol.DivisionSymbol;
import symbol.EndSymbol;
import symbol.ErrorToken;
import symbol.LeftBracketSymbol;
import symbol.NumberSymbol;
import symbol.PlusSymbol;
import symbol.RightBracketSymbol;
import symbol.StarSymbol;
import symbol.Symbol;

/*
 * converts symbols into Products or Factors
 */
public class SummandParser extends Parser {
	private Summand mySummand;
	
	public SummandParser(List<Symbol> symbols) {
		super(symbols);
	}
	
	/*
	 * converts a Symbol into an Expression
	 */
	public Summand toExpression() throws SymbolException{
		this.mySummand = new FactorParser(super.getSymbols()).toExpression();
		super.getCurrentSymbol().accept(this);
		return this.mySummand;
	}
	
	/*
	 * how to handle a PlusSymbol
	 */
	public void handle(PlusSymbol symbol) throws SymbolException {	
	}
	
	/*
	 * how to handle a StarSymbol
	 */
	public void handle(StarSymbol symbol) throws SymbolException {
		super.skip();
		
		this.mySummand = new Product((Factor) this.mySummand, new SummandParser(super.getSymbols()).toExpression());
	}
	
	/*
	 * how to handle EndSymbols;
	 */
	public void handle(EndSymbol symbol) {	
	}
	
	/*
	 * how to handle RightBracket Symbols
	 */
	public void handle(RightBracketSymbol symbol) throws SymbolException {
	}
	
	/*
	 * how to handle Division Symbols
	 */
	public void handle(DivisionSymbol symbol) throws SymbolException {
		super.skip();
		this.mySummand = new Quotient((Factor) this.mySummand, new SummandParser(super.getSymbols()).toExpression());
	}

	/*
	 * how to handle a NumberSymbol
	 */
	@Override
	public void handle(NumberSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
	}

	/*
	 * how to handle a LeftBracktSymbol
	 */
	@Override
	public void handle(LeftBracketSymbol symbol) throws SymbolException {
		this.errorHandling(symbol);
	}

	/*
	 * how to handle an ErrorToken
	 */
	@Override
	public void handle(ErrorToken symbol) throws SymbolException {
		this.errorHandling(symbol);
	}
	
	/*
	 * throws new SymbolException when unexpected symbols appear
	 */
	@Override
	public void errorHandling(Symbol symbol) throws SymbolException {
		throw new SymbolException("Gefunden " + symbol.toString() + ", erwartet " + EndSymbol.getInstance().toString() + " oder OperatorSymbol");
	}

}
