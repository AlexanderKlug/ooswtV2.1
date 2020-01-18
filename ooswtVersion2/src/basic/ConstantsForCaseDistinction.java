package basic;

import java.util.HashMap;

import scanner.*;

/*
 * class that stores constants which are used to differ characters
 */
public class ConstantsForCaseDistinction {
	
	public static final Character LEFTBRACKET = '(';		// constant for opening bracket
	public static final Character RIGHTBRACKET = ')';		// constant for closing bracket
	public static final Character STAR = '*';				// constant for multiplication
	public static final Character PLUS = '+';				// constant for addition
	public static final Character WHITESPACE = ' ';			// constant for whitespace
	public static final Character TAB = '	';				// constant for tab
	public static final Character DIVISION = '/';			// constant for division
	
	/*
	 * hash map to convert a char into a state
	 */
	public static final HashMap<Character, State> char_To_State_Map = new HashMap<Character, State>();
	
	static {
		char_To_State_Map.put(LEFTBRACKET, new LeftBracketState());
		char_To_State_Map.put(RIGHTBRACKET,	new RightBracketState());
		char_To_State_Map.put(STAR, new StarState());
		char_To_State_Map.put(PLUS, new PlusState());
		char_To_State_Map.put(WHITESPACE,new WhitespaceState());
		char_To_State_Map.put(TAB, new WhitespaceState());
		char_To_State_Map.put(DIVISION, new DivisionState());
		char_To_State_Map.put('0', new DigitState());
		char_To_State_Map.put('1', new DigitState());
		char_To_State_Map.put('2', new DigitState());
		char_To_State_Map.put('3', new DigitState());
		char_To_State_Map.put('4', new DigitState());
		char_To_State_Map.put('5', new DigitState());
		char_To_State_Map.put('6', new DigitState());
		char_To_State_Map.put('7', new DigitState());
		char_To_State_Map.put('8', new DigitState());
		char_To_State_Map.put('9', new DigitState());
	}

}
