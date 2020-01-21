package expression;

import exceptions.DivisionException;

/*
 * division result
 */
public class Quotient implements Summand {
	private Factor first;
	private Summand second;
	
	/*
	 * constructor
	 */
	public Quotient(Factor factor, Summand summand) {
		this.first = factor;
		this.second = summand;
	}
	
	@Override
	// second Part could be 0 -> has to be checked
	public Integer evaluate() throws DivisionException {
		Integer temp = this.second.evaluate();
		if(temp == 0) {
			throw new DivisionException("Fehler! Division durch 0!");
		} else {
		return this.first.evaluate() / temp;
		}
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.handle(this);
	}
	
	/*
	 * getter for first Part
	 */
	public Factor getFirstPart() {
		return this.first;
	}
	
	/*
	 * getter for second Part
	 */
	public Summand getSecondPart() {
		return this.second;
	}

}
