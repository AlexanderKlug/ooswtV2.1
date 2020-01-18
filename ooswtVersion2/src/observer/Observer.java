package observer;

import actionEvent.ActionEvent;

/*
 * Observer -> Observer Pattern
 * can watch an Observer
 */
public interface Observer {
	
	public void update(ActionEvent event);
}


