package view;

/*
 * state in which the Evaluate Button can not be used
 */
public class EvaluateButtonDisabled implements State{
	private View myView;
	
	/*
	 * constructor
	 * disables the Evaluate Button
	 */
	public EvaluateButtonDisabled(View view) {
		this.myView = view;
		this.myView.getEvaluateButton().setEnabled(false);
	}

}
