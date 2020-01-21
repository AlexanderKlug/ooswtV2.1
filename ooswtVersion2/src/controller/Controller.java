package controller;

import javax.swing.JTree;

import actionEvent.ActionEvent;
import basic.Constants;
import exceptions.DivisionException;
import exceptions.SymbolException;
import facade.Facade;
import observer.Observer;
import expression.Expression;
import view.EvaluateButtonDisabled;
import view.EvaluateButtonEnabled;
import view.RootVisitor;
import view.View;

/*
 * Application controller based on model-view-controller design
 * connecting entity between application logic and user interface
 */
public class Controller implements Observer {
	private View currentView;																	// current application view
	private Facade currentFacade;																// cuirrent application facade
	
	/*
	 * constructor
	 */
	public Controller(View view, Facade facade) {
		this.currentView = view;
		this.currentFacade = facade;
		this.currentView.getEvaluateButton().addActionListener((l) -> {
			this.onEvaluateButtonPressed();
		});
		this.currentView.getCheckSyntaxButton().addActionListener((l) -> {
			this.onCheckSyntaxButtonPressed();
		});
	}
	
	/*
	 * evaluates user entered expression from "enterExpressionTextField" 
	 * shows the expression's value in the view's "resultTextField"
	 */
	public void onEvaluateButtonPressed() {
		try {
			//this.currentView.getStatusTextField().setText("");										// clear status TextField
			//this.currentView.clearTreeContent();													// clear Tree Content
			String input = this.currentView.getEnterExpressionTextField().getText();
			Integer result = this.currentFacade.evaluate(input);
			this.currentView.getResultTextField().setText(result.toString());
			this.currentView.setState(new EvaluateButtonDisabled(this.currentView));
		}catch(SymbolException | DivisionException f) {
			this.currentView.getResultTextField().setText("");										// clear result TextField
			this.currentView.clearTreeContent();													// clear Tree Content
			this.currentView.getStatusTextField().setText(f.getMessage());							// show error message at status TextField
		}
	}
	

	/*
	 * checks syntax of user entered expression from "enterExpressionTextField" 
	 * shows result at statusTextField
	 */
	public void onCheckSyntaxButtonPressed() {
		try {
			this.currentView.getResultTextField().setText("");
			String input = this.currentView.getEnterExpressionTextField().getText();
			Expression result = this.currentFacade.checkSyntax(input);
			this.currentView.getStatusTextField().setText(Constants.SYNTAXCORRECTLY);
			this.createSyntaxTree(result);
			this.currentView.setViewpointTree();;
			this.currentView.setState(new EvaluateButtonEnabled(this.currentView));
		} catch(SymbolException f) {
			this.currentView.clearTreeContent();													// clear Tree Content
			this.currentView.getStatusTextField().setText(f.getMessage());							// set Error Message
		}
	}
	
	/*
	 * execute evaluation Observable (Facade) informed about
	 */
	public void evalutionEventReceived() {
		try {
			//this.currentView.getStatusTextField().setText("");										// clear status TextField
			//this.currentView.clearTreeContent();													// clear Tree Content
			String input = this.currentFacade.getCurrentInput();
			Integer result = this.currentFacade.evaluateWithoutNotifyObservers(input);
			this.currentView.getResultTextField().setText(result.toString());
		} catch(SymbolException | DivisionException e) {
			this.currentView.getResultTextField().setText("");										// clear result TextField
			this.currentView.clearTreeContent();													// clear Tree Content
			this.currentView.getStatusTextField().setText(e.getMessage());
		}
	}
	
	/*
	 * execute Syntax Check Observable (Facade) informed about
	 */
	public void checkSyntaxEventReceived() {
		try {
			this.currentView.getResultTextField().setText("");
			String input = this.currentFacade.getCurrentInput();
			this.currentView.getEnterExpressionTextField().setText(input);
			Expression result = this.currentFacade.checkSyntaxWithoutNotifyObservers(input);
			this.currentView.getStatusTextField().setText(Constants.SYNTAXCORRECTLY);
			this.createSyntaxTree(result);
			this.currentView.setViewpointTree();
		}catch(SymbolException e) {
			this.currentView.clearTreeContent();													// clear Tree Content
			this.currentView.getStatusTextField().setText(e.getMessage());							// set Error Message
		}
	}

	@Override
	public void update(ActionEvent event) {
		event.accept(new ControllerVisitor(this));
	}
	
	/*
	 * creates Syntax Tree
	 */
	public void createSyntaxTree(Expression expression) {
		JTree tree = new JTree();
		expression.accept(new RootVisitor(tree));
		this.currentView.setTree(tree);
	}

}
