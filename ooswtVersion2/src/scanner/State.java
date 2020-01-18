package scanner;

/*
 * state that a scanner can have while converting a string to a list if symbols
 */
public abstract class State {
	
	/*
	 * converts a string into a list of symbols
	 */
	public abstract void scan(Character c);
	
	/*
	 * finishes the scan process of the state
	 */
	public void exit() {
		
	}
	
	/*
	 * sets a new SelectionState
	 */
	public void endOfProcessing( ) {
		Scanner.getScanner().setCurrentState(new SelectionState());	
	}

}
