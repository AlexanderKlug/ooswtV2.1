package actionEvent;

/*
 * Visitor to handle different kinds of ActionEvents
 */
public interface ActionEventVisitor {
	
	public void handle(CheckSyntaxEvent event);
	
	public void handle(EvaluateEvent event);
}
