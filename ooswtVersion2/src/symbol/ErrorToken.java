package symbol;

import exceptions.SymbolException;

/*
 * Symbol for an incorrect input
 */
public class ErrorToken implements Symbol {
	private String content;		// content of an ErrorToken

	/*
	 * Constructor
	 */
	public ErrorToken(String content) {
		this.content = content;
	}
	
	/*
	 * overrides the default implementation of equals
	 * returns true if object is an ErrorToken and both contents are equal
	 */
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof ErrorToken)) {
			return false;
		}
		else {
			ErrorToken other = (ErrorToken) obj;
			return other.content.equals(this.content);
		}
	}
	
	@Override
	public void accept(SymbolVisitor visitor) throws SymbolException {
		visitor.handle(this);
	}
	
	/*
	 * returns the content of an ErrorToken as String
	 */
	public String toString() {
		return this.content;
	}

}
