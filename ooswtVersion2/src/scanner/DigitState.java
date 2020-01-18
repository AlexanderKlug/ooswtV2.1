package scanner;

import symbol.NumberSymbol;

/*
 * state while converting a natural number
 */
public class DigitState extends State {
	private StringBuilder digits;		// attribute to collect digits
	
	/*
	 * constructor
	 */
	public DigitState() {
		this.digits = new StringBuilder();
	}

	@Override
	public void scan(Character c) {
		if(Character.isDigit(c)) {
			Scanner.getScanner().skip();
			this.digits.append(c);
		}
		else {
			this.exit();
			this.endOfProcessing();
		}
	}
	
	/*
	 * ends the currentState and adds the collected digits to SymbolList
	 */
	public void exit() {
		Scanner.getScanner().addSymbol(new NumberSymbol(Integer.valueOf(this.digits.toString())));
		this.digits = new StringBuilder();
	}
}
