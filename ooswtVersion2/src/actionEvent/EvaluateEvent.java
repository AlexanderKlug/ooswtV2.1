package actionEvent;

/*
 * event which can be triggered by facade's evaluate method
 */
public class EvaluateEvent implements ActionEvent {

	@Override
	public void accept(ActionEventVisitor visitor) {
		visitor.handle(this);
	}

}
