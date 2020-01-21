 package facade;

import java.util.List;

import actionEvent.CheckSyntaxEvent;
import actionEvent.EvaluateEvent;
import exceptions.DivisionException;
import exceptions.SymbolException;
import observer.Observable;
import expression.Expression;
import parser.ExpressionParserProxy;
import scanner.Scanner;
import symbol.Symbol;

/*
 * Entry point into application logic
 * summarizes the functionalities of scanner and parser
 */
public class Facade extends Observable {
	private String currentInput;
	private Integer currentValue;
	private Expression currentExpression;
	
	/*
	 * evaluates arithmetic expresions
	 * evaluation order from right to left!
	 */
	public Integer evaluate(String input) throws SymbolException, DivisionException{
		this.currentInput = input;
		this.notifyObservers(new EvaluateEvent());
		this.currentValue = this.compile(input).evaluate();
		return this.currentValue;
	}
	
	/*
	 * evaluates arithmetic expressions
	 * evaluation order from right to left!
	 * doesn't notify observers
	 */
	public Integer evaluateWithoutNotifyObservers(String input) throws SymbolException, DivisionException{
		this.currentInput = input;
		this.currentValue = this.compile(input).evaluate();
		return this.currentValue;
	}
	
	/*
	 * checks syntax of user entered arithmetic expression
	 */
	public Expression checkSyntax(String input) throws SymbolException {
		this.currentInput = input;
		this.notifyObservers(new CheckSyntaxEvent());
		this.currentExpression = this.compile(input);
		return this.currentExpression;
	}
	
	/*
	 * checks syntax of user entered arithmetic expression
	 * doesn't notify observers
	 */
	public Expression checkSyntaxWithoutNotifyObservers(String input) throws SymbolException {
		this.currentInput = input;
		this.currentExpression = this.compile(input);
		return this.currentExpression;
	}
	
	/*
	 * converts an user entered String into an expression
	 * throws SymbolExceptions
	 */
	private Expression compile(String input) throws SymbolException {
		ExpressionParserProxy proxyParser = new ExpressionParserProxy();
		List<Symbol> listOfSymbols = Scanner.getScanner().toSymbolSequence(input);
		Expression expression = proxyParser.toExpression(listOfSymbols);
		return expression;
	}
	
	/*
	 * getter for current Result of evaluation
	 */
	public Integer getCurrentValue() {
		return this.currentValue;
	}
	
	/*
	 * getter for current Expression
	 */
	public Expression getCurrentExpression() {
		return this.currentExpression;
	}
	
	/*
	 * getter for current input String
	 */
	public String getCurrentInput() {
		return this.currentInput;
	}
}
