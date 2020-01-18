package scanner;

import symbol.RightBracketSymbol;

/*
 * state while convertig an closing bracket
 */
public class RightBracketState extends State {

	@Override
	public void scan(Character c) {
		Scanner.getScanner().skip();
		Scanner.getScanner().addSymbol(RightBracketSymbol.getInstance());
		this.endOfProcessing();
	}
}
