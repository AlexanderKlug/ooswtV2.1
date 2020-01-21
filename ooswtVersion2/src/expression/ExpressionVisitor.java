package expression;

/*
 * Expression visitor for case distinction of expressions
 * -> Visitor Pattern
 */
public interface ExpressionVisitor {

	/*
	 * hot to handle an Expression
	 */
	public void handle(Expression expression);
	
	/*
	 * hot wo handle a Summand
	 */
	public void handle(Summand summand);
	
	/*
	 * how to handle a Sum
	 */
	public void handle(Sum sum);
	
	/*
	 * how to handle a Factor
	 */
	public void handle(Factor factor);
	
	/*
	 * how to handle a Product
	 */
	public void handle(Product product);
	
	/*
	 * how to handle a BracketExpression
	 */
	public void handle(BracketExpression bracketExpression);
	
	/*
	 * how to handle a NaturalNumber
	 */
	public void handle(NaturalNumber naturalNumber);
	
	/*
	 * how to handle a Quotient
	 */
	public void handle(Quotient quotient);
	
}
