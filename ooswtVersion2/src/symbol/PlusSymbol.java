package symbol;

import exceptions.SymbolException;

/*
 * Symbol for addition
 * implemented as singleton 
 */
public class PlusSymbol implements OperatorSymbol {
	private static final PlusSymbol INSTANCE = new PlusSymbol();		// singleton
	
	/*
	 * private constructor
	 */
	private PlusSymbol() {
	}
	
	/*
	 * returns the reference to the PlusSymbol
	 */
	public static PlusSymbol getInstance() {
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
		return "PlusSymbol";
	}

}
