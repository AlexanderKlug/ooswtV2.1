package actionEvent;

/*
 * event which can be triggered by using a method
 */
public interface ActionEvent {
	
	public void accept(ActionEventVisitor visitor);

}
