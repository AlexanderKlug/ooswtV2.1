package view;

import javax.swing.tree.DefaultMutableTreeNode;
import basic.ConstantsForCaseDistinction;
import expression.BracketExpression;
import expression.Expression;
import expression.ExpressionVisitor;
import expression.Factor;
import expression.NaturalNumber;
import expression.Product;
import expression.Quotient;
import expression.Sum;
import expression.Summand;

/*
 * visitor to set the nodes of Expression Tree
 */
public class TreeVisitor implements ExpressionVisitor {
	private DefaultMutableTreeNode currentNode;
	
	/*
	 * constructor
	 */
	public TreeVisitor(DefaultMutableTreeNode node) {
		this.currentNode = node;
	}
	
	@Override
	public void handle(Expression expression) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handle(Summand summand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handle(Sum sum) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Sum");
		sum.getFirstPart().accept(new TreeVisitor(node));
		node.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.PLUS));
		sum.getSecondPart().accept(new TreeVisitor(node));
		currentNode.add(node);
	}

	@Override
	public void handle(Factor factor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handle(Product product) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Product");
		product.getFirstPart().accept(new TreeVisitor(node));
		node.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.STAR));
		product.getSecondPart().accept(new TreeVisitor(node));
		currentNode.add(node);
	}

	@Override
	public void handle(BracketExpression bracketExpression) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("BracketExpression");
		node.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.LEFTBRACKET));
		bracketExpression.getContent().accept(new TreeVisitor(node));
		node.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.RIGHTBRACKET));
		currentNode.add(node);
	}

	@Override
	public void handle(NaturalNumber naturalNumber) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("NaturalNumber");
		node.add(new DefaultMutableTreeNode(naturalNumber.evaluate().toString()));
		this.currentNode.add(node);
	}

	@Override
	public void handle(Quotient quotient) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Quotient");
		quotient.getFirstPart().accept(new TreeVisitor(node));
		node.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.DIVISION));
		quotient.getSecondPart().accept(new TreeVisitor(node));
		currentNode.add(node);
	}

}
