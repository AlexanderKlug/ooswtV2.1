package actionEvent;

/*
 * event which can be triggered by facades's checkSyntax method
 */
public class CheckSyntaxEvent implements ActionEvent {

	@Override
	public void accept(ActionEventVisitor visitor) {
		visitor.handle(this);
	}

}
