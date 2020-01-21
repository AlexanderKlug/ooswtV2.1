package view;

/*
 * state in which the Evaluate Button can not be used
 */
public class EvaluateButtonDisabled extends State{
	
	/*
	 * constructor
	 * disables the Evaluate Button
	 */
	public EvaluateButtonDisabled(View view) {
		super(view);
		this.getMyView().getEvaluateButton().setEnabled(false);
	}

}
