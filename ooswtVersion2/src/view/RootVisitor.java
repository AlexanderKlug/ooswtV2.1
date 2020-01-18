package view;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import basic.ConstantsForCaseDistinction;
import parser.BracketExpression;
import parser.Expression;
import parser.ExpressionVisitor;
import parser.Factor;
import parser.NaturalNumber;
import parser.Product;
import parser.Quotient;
import parser.Sum;
import parser.Summand;

/*
 * visitor to set root of Expression Tree
 */
public class RootVisitor implements ExpressionVisitor {
	private JTree currentTree;
	
	/*
	 * constructor
	 */
	public RootVisitor(JTree tree) {
		this.currentTree = tree;
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
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Sum");
		DefaultTreeModel tm = new DefaultTreeModel(root);
		this.currentTree.setModel(tm);
		sum.getFirstPart().accept(new TreeVisitor(root));
		root.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.PLUS));
		sum.getSecondPart().accept(new TreeVisitor(root));
	}

	@Override
	public void handle(Factor factor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handle(Product product) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Product");
		DefaultTreeModel tm = new DefaultTreeModel(root);
		this.currentTree.setModel(tm);
		product.getFirstPart().accept(new TreeVisitor(root));
		root.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.STAR));
		product.getSecondPart().accept(new TreeVisitor(root));
	}

	@Override
	public void handle(BracketExpression bracketExpression) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("BracketExpression");
		DefaultTreeModel tm = new DefaultTreeModel(root);
		this.currentTree.setModel(tm);
		root.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.LEFTBRACKET));
		bracketExpression.getContent().accept(new TreeVisitor(root));
		root.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.RIGHTBRACKET));
	}

	@Override
	public void handle(NaturalNumber naturalNumber) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("NaturalNumber");
		DefaultTreeModel tm = new DefaultTreeModel(root);
		this.currentTree.setModel(tm);
		root.add(new DefaultMutableTreeNode(naturalNumber.evaluate()));
	}

	@Override
	public void handle(Quotient quotient) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Quotient");
		DefaultTreeModel tm = new DefaultTreeModel(root);
		this.currentTree.setModel(tm);
		quotient.getFirstPart().accept(new TreeVisitor(root));
		root.add(new DefaultMutableTreeNode(ConstantsForCaseDistinction.DIVISION));
		quotient.getSecondPart().accept(new TreeVisitor(root));
	}

}
