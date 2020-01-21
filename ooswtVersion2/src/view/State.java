package view;

/*
 * State Pattern
 * state in which the view can be
 */
public abstract class State {
	private View myView;
	
	/*
	 * constructor
	 */
	public State(View view) {
		this.myView = view;
	}
	
	/*
	 * getter for current View
	 */
	public View getMyView() {
		return this.myView;
	}
}
