package scanner;

import symbol.LeftBracketSymbol;

/*
 * state while converting an opening bracket
 */
public class LeftBracketState extends State {

	@Override
	public void scan(Character c) {
		Scanner.getScanner().skip();
		Scanner.getScanner().addSymbol(LeftBracketSymbol.getInstance());
		this.endOfProcessing();
	}
}
