package scanner;

import symbol.StarSymbol;

/*
 * state while converting multiplication character
 */
public class StarState extends State{
	
	@Override
	public void scan(Character c) {
		Scanner.getScanner().skip();
		Scanner.getScanner().addSymbol(StarSymbol.getInstance());
		this.endOfProcessing();
	}

}
