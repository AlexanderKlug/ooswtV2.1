package scanner;

import java.util.ArrayList;
import java.util.List;
import symbol.*;

/*
 * Scanner that converts a string into a list of symbols
 * implemented as singleton
 */
public class Scanner {
	private static final Scanner SCANNER = new Scanner();	// singleton
	private List<Symbol> currentResult;		// list of symbols
	private State currentState;				//	state of the scanner while converting a string to a list of symbols
	private String currentExpression;		// string which has to be converted
	
	/*
	 * private constructor
	 */
	private Scanner() {
	}
	
	/*
	 * converts a string to a list of symbols
	 */
	public List<Symbol> toSymbolSequence(String expression) {
		this.currentResult = new ArrayList<Symbol>();
		this.currentState = new SelectionState();
		this.currentExpression = expression;
		
		while(this.currentExpression.length() > 0) {
			this.currentState.scan(this.currentExpression.charAt(0));
		}
		
		this.currentState.exit();
		return this.currentResult;
	}
	
	/*
	 * returns the reference to the scanner
	 */
	public static Scanner getScanner() {
		return SCANNER;
	}
	
	/*
	 * setter method for the attribute currentState
	 */
	public void setCurrentState(State state) {
		this.currentState = state;
	}
	
	/*
	 * deletes the first character of the attribute currentExpression
	 */
	public void skip() {
		if(this.currentExpression.length() > 0) {
			this.currentExpression = this.currentExpression.substring(1);
		}
	}
	
	/*
	 * adds a symbol to currentResult
	 */
	public void addSymbol(Symbol symbol) {
		this.currentResult.add(symbol);
	}
}
