package view;

public class EvaluateButtonEnabled extends State {
	
	
	/*
	 * constructor
	 * enables Evaluate Button
	 */
	public EvaluateButtonEnabled(View view) {
		super(view);
		this.getMyView().getEvaluateButton().setEnabled(true);
	}

}
