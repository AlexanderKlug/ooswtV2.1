package scanner;

import symbol.DivisionSymbol;

/*
 * state while converting a division character
 */
public class DivisionState extends State{

	@Override
	public void scan(Character c) {
		Scanner.getScanner().skip();
		Scanner.getScanner().addSymbol(DivisionSymbol.getInstance());
		Scanner.getScanner().setCurrentState(new SelectionState());
	}

}
