package parser;

import java.util.List;

import exceptions.SymbolException;
import expression.Expression;
import symbol.*;

/*
 * entry of the application
 */
public class ExpressionParserProxy {
	
	/*
	 * converts a list of Symbols to an arithmetic Expression
	 * throws SymbolErros when syntax is not correct
	 */
	public Expression toExpression(List<Symbol> list) throws SymbolException {
		list.add(EndSymbol.getInstance());
		Expression temp =  new ExpressionParser(list).toExpression();
		if(list.size() > 1) {
			throw new SymbolException("unerwartetes " + list.get(0).toString());
		}
		return temp;
	}
}
