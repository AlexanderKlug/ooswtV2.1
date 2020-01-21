package expression;

import exceptions.DivisionException;

/*
 * arithmetic sum
 */
public class Sum implements Expression {
	private Summand first;		
	private Expression second;
	
	/*
	 * constructor
	 */
	public Sum(Summand first, Expression second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public Integer evaluate() throws DivisionException {
		return this.first.evaluate() + this.second.evaluate();
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.handle(this);
	}
	
	/*
	 * getter for first Part
	 */
	public Summand getFirstPart() {
		return this.first;
	}
	
	/*
	 * getter for second Part
	 */
	public Expression getSecondPart() {
		return this.second;
	}

}
