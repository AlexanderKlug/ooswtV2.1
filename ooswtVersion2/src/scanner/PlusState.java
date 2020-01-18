package scanner;

import symbol.PlusSymbol;

/*
 * state while converting a plus character 
 */
public class PlusState extends State {
	
	@Override
	public void scan(Character c) {
		Scanner.getScanner().skip();
		Scanner.getScanner().addSymbol(PlusSymbol.getInstance());
		this.endOfProcessing();
	}

}
