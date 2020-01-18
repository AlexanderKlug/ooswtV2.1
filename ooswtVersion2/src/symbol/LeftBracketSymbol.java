package symbol;

import exceptions.SymbolException;

/*
 * Symbol for an opening bracket
 * implemented as singleton
 */
public class LeftBracketSymbol implements BracketSymbol {
	private static final LeftBracketSymbol INSTANCE = new LeftBracketSymbol();		// singleton
	
	/*
	 * private constructor
	 */
	private LeftBracketSymbol() {
	}
	
	/*
	 * returns the reference to the Left_Bracket_Symbol
	 */
	public static LeftBracketSymbol getInstance() {
		return INSTANCE;
	}
	
	/*
	 * overrides the default implementation of equals
	 */
	public boolean equals(Object obj) {
		return obj == INSTANCE;
	}

	@Override
	public void accept(SymbolVisitor visitor) throws SymbolException {
		visitor.handle(this);
	}
	
	/*
	 * overrides the default implementation of toString
	 */
	public String toString() {
		return "Left_Bracket_Symbol";
	}

}
