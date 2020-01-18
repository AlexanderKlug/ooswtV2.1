package symbol;

import exceptions.SymbolException;

/*
 * symbol of division implemented as singleton
 */
public class DivisionSymbol implements OperatorSymbol {
	private static final DivisionSymbol INSTANCE = new DivisionSymbol();								// singleton
	
	/*
	 * getter for instance of DivisionSymbol
	 */
	public static DivisionSymbol getInstance() {
		return INSTANCE;
	}
	
	
	@Override
	public void accept(SymbolVisitor visitor) throws SymbolException {
		visitor.handle(this);
	}
	
	/*
	 * overrides the default implementation of toString
	 */
	public String toString() {
		return "DivisionSymbol";
	}

}
