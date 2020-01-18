package symbol;

import exceptions.SymbolException;

/*
 * Symbol for multiplication
 * implemented as singleton
 */
public class StarSymbol implements OperatorSymbol {
	private static final StarSymbol INSTANCE = new StarSymbol();		// singleton
	
	/*
	 * private constructor
	 */
	private StarSymbol() {
	}
	
	/*
	 * returns the reference to the StarSymbol
	 */
	public static StarSymbol getInstance() {
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
		return "StarSymbol";
	}

}
