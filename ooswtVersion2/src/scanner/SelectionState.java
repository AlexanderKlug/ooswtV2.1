package scanner;

import basic.*;

public class SelectionState extends State{
	
	@Override
	public void scan(Character c) {
		if(!(ConstantsForCaseDistinction.char_To_State_Map.containsKey(c))) {
			Scanner.getScanner().setCurrentState(new ErrorState());
		}
		else {
			Scanner.getScanner().setCurrentState(ConstantsForCaseDistinction.char_To_State_Map.get(c));
		}
	}

}
