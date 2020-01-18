package symbol;

import exceptions.SymbolException;

/*
 * Symbol that shows the end of a Symbol List
 * implemented as singleton
 */
public class EndSymbol implements Symbol {
	public static final EndSymbol INSTANCE = new EndSymbol();		// singleton
	
	/*
	 * private constructor
	 */
	private EndSymbol() {
	}
	
	/*
	 * returns the reference to the EndSymbol
	 */
	public static EndSymbol getInstance() {
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
		return "EndSymbol";
	}

}
