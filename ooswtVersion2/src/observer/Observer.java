package observer;

import actionEvent.ActionEvent;

/*
 * Observer -> Observer Pattern
 * can watch an Observer
 */
public interface Observer {
	
	/*
	 * operation that will be executed when observable got new Data
	 */
	public void update(ActionEvent event);
}


