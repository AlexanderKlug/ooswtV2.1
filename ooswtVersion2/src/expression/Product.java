package expression;

import exceptions.DivisionException;

/*
 * arithmetic product
 */
public class Product implements Summand {
	private Factor first;
	private Summand second;
	
	/*
	 * constructor
	 */
	public Product(Factor first, Summand second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public Integer evaluate() throws DivisionException {
		return this.first.evaluate() * this.second.evaluate();
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.handle(this);
	}
	
	/*
	 * getter for First Part
	 */
	public Factor getFirstPart() {
		return this.first;
	}
	
	/*
	 * getter for Second Part
	 */
	public Summand getSecondPart() {
		return this.second;
	}
}
