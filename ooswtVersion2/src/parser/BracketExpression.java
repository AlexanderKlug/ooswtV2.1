package parser;

import exceptions.DivisionException;

/*
 * arithmetic expression in brackets
 */
public class BracketExpression implements Factor {
	private Expression content;
	
	/*
	 * constructor
	 */
	public BracketExpression(Expression content) {
		this.content = content;
	}

	@Override
	public Integer evaluate() throws DivisionException {
		return this.content.evaluate();
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.handle(this);
	}
	
	/*
	 * getter for Content of a Bracket Expression
	 */
	public Expression getContent() {
		return this.content;
	}

}
