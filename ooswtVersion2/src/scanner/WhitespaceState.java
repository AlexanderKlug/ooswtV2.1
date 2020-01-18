package scanner;

/*
 * state while converting whitespace 
 */
public class WhitespaceState extends State {
	
	@Override
	public void scan(Character c) {
		Scanner.getScanner().skip();
		this.endOfProcessing();
	}

}
