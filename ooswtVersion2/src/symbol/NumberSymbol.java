package symbol;

import exceptions.SymbolException;

/*
 * Symbol for natural numbers
 */
public class NumberSymbol implements Symbol {
	private Integer value;		// value of a natural number
	
	/*
	 * Constructor
	 */
	public NumberSymbol(Integer value) {
		this.value = value;
	}
	
	/*
	 * overrides the default implementation of equals
	 * returns true if object is a NumberSymbol and both values are equal
	 */
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof NumberSymbol)) {
			return false;
		}
		else {
			NumberSymbol other = (NumberSymbol) obj;
			return other.value.equals(this.value);
		}
	}
	
	@Override
	public void accept(SymbolVisitor visitor) throws SymbolException {
		visitor.handle(this);
	}
	
	/*
	 * overrides the default implementation of toString
	 * returns the value of a NumberSymbol as string
	 */
	public String toString() {
		return this.value.toString();
	}
	
	/*
	 * returns the value of the natural number
	 */
	public Integer getValue() {
		return this.value;
	}

}
