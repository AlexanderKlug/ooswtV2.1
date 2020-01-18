package view;

public class EvaluateButtonEnabled implements State {
	private View myView;
	
	/*
	 * constructor
	 * enables Evaluate Button
	 */
	public EvaluateButtonEnabled(View view) {
		this.myView = view;
		this.myView.getEvaluateButton().setEnabled(true);
	}

}
