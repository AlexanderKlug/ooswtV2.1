package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JScrollPane;

/*
 * View for application
 * arithmetic expressions can be entered and evaluated
 */
public class View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private State currentState;
	private JButton evaluateButton;
	private JButton checkSyntaxButton;
	private JTextField statusTextField;
	private JTextField resultTextfield;
	private JTextField enterExpressionTextField;

	private JPanel contentPane;
	private JScrollPane treeContent;
	private JTree currentTree;



	/**
	 * Create the frame.
	 */
	public View() {
		
		setTitle("Bearbeitung arithmetischer Ausdr\u00FCcke");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(this.setEnterExpressionTextField());			// set TextField for user input
		contentPane.add(this.setInputTextFieldLabel());					// set Label for InputTextField
		
		contentPane.add(this.setResultTextField());						// set TextField for results
		
		contentPane.add(this.setEvaluateButton());						// set Button for evaluation of arithmetic expressions
		contentPane.add(this.setCheckSyntaxButton());					// set Button for syntax check of arithmetic expressions

		contentPane.add(this.setStatusTextField());
		
		treeContent = new JScrollPane();
		treeContent.setBounds(489, 278, 389, 241);
		contentPane.add(treeContent);									// add tree content
		
		this.currentState = new EvaluateButtonDisabled(this);
		
	}
	
	// set TextField for user input
	private JTextField setEnterExpressionTextField() {
		this.enterExpressionTextField = new JTextField();
		enterExpressionTextField.setBounds(299, 31, 282, 37);
		return this.enterExpressionTextField;
	}
	
	// set Label for user input
	private JLabel setInputTextFieldLabel() {
		JLabel label = new JLabel("Ausdruck eingeben");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(75, 31, 156, 37);
		return label;
	}
	
	// set TextField to show results
	private JTextField setResultTextField() {
		this.resultTextfield = new JTextField();
		resultTextfield.setBounds(299, 153, 282, 37);
		return resultTextfield;
	}
	
	// set TextField for status messages like errors or "Syntax in Ordnung!"
	private JTextField setStatusTextField() {
		this.statusTextField = new JTextField();
		statusTextField.setBounds(75, 543, 803, 37);
		return this.statusTextField;
	}
	
	// set Button to evaluate user entered expressions
	private JButton setEvaluateButton() {
		this.evaluateButton = new JButton("Auswertung");
		evaluateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		evaluateButton.setBounds(75, 153, 165, 37);
		return this.evaluateButton;
	}
	
	// set Button to check syntax of user entered expressions
	private JButton setCheckSyntaxButton() {
		this.checkSyntaxButton = new JButton("Syntax pr\u00FCfen");
		checkSyntaxButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkSyntaxButton.setBounds(75, 266, 165, 37);
		return this.checkSyntaxButton;
	}
		
	// getter for evaluation button
	public JButton getEvaluateButton() {
		return this.evaluateButton;
	}
	
	// getter for syntax button
	public JButton getCheckSyntaxButton() {
		return this.checkSyntaxButton;
	}
	
	// getter for status TextField
	public JTextField getStatusTextField() {
		return this.statusTextField;
	}
	
	// getter for result TextField
	public JTextField getResultTextField() {
		return this.resultTextfield;
	}
	
	// getter for user input TextField
	public JTextField getEnterExpressionTextField() {
		return this.enterExpressionTextField;
	}
	
	/*
	 * sets Viewpoint to Syntax Tree of an Expression
	 */
	public void setViewpointTree() {
		this.treeContent.setViewportView(this.currentTree);
	}
	
	/*
	 * removes expression tree from Tree Content
	 */
	public void clearTreeContent() {
		this.treeContent.setViewportView(new JPanel());
	}
	
	/*
	 * getter for Tree Content
	 */
	public JScrollPane getTreeContent() {
		return this.treeContent;
	}
	
	/*
	 * sets Attribut curtrentTree
	 */
	public void setTree(JTree tree) {
		this.currentTree = tree;
	}
	
	/*
	 * changes view's state
	 */
	public void setState(State state) {
		this.currentState = state;
	}
}
