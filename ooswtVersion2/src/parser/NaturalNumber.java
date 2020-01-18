package parser;
/*
 * natural number
 */
public class NaturalNumber implements Factor {
	private Integer value;
	
	/*
	 * constructor
	 */
	public NaturalNumber(Integer value) {
		this.value = value;
	}

	@Override
	public Integer evaluate() {
		return this.value;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.handle(this);
	}

}
