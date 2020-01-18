package parser;

import exceptions.DivisionException;

/*
 * arithmetic expression
 */
public interface Expression {
	
	/*
	 * evaluates the arithmetic expression
	 */
	public Integer evaluate() throws DivisionException;
	
	/*
	 * case distinction by using Visitor Pattern
	 */
	public void accept(ExpressionVisitor visitor);

}
