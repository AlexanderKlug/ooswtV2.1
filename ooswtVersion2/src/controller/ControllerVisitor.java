package controller;

import actionEvent.ActionEventVisitor;
import actionEvent.CheckSyntaxEvent;
import actionEvent.EvaluateEvent;

/*
 * visitor used by controller to separate Action Events
 */
public class ControllerVisitor implements ActionEventVisitor {
	private Controller controller;
	
	public ControllerVisitor(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void handle(CheckSyntaxEvent event) {
		controller.checkSyntaxEventReceived();
	}

	@Override
	public void handle(EvaluateEvent event) {
		controller.evalutionEventReceived();
	}

}
