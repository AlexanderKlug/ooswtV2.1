package scanner;

import basic.ConstantsForCaseDistinction;
import symbol.ErrorToken;

/*
 * state while converting undefined chars
 */
public class ErrorState extends State {
	private StringBuilder result;		// private StringBuilder to save the undefined characters
	
	/*
	 * constructor
	 */
	public ErrorState() {
		this.result = new StringBuilder();
	}
	
	@Override
	public void scan(Character c) {
		if(!(ConstantsForCaseDistinction.char_To_State_Map.containsKey(c))) {
			Scanner.getScanner().skip();
			this.result.append(c);
		}
	else {
		this.exit();
		this.endOfProcessing();
		}
	}
	
	/*
	 * finishes the scan process of the state
	 */
	public void exit() {
		Scanner.getScanner().addSymbol(new ErrorToken(this.result.toString()));
	}

}
