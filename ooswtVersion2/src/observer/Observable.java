package observer;

import java.util.ArrayList;
import java.util.List;

import actionEvent.ActionEvent;

/*
 * Observable -> Observer Pattern
 * can be watched by an Observer
 */
public abstract class Observable {
	private List<Observer> observers;													// List of Observers
	
	/*
	 * constructor
	 */
	public Observable() {
		this.observers = new ArrayList<Observer>();
	}
	
	/*
	 * notifies observers when changes appear
	 */
	public void notifyObservers(ActionEvent event) {
		for(Observer observer: this.observers) {
			observer.update(event);
		}
	}
	
	/*
	 * adds a new Observer
	 */
	public void register(Observer observer) {
		this.observers.add(observer);
	}
	
	/*
	 * removes Observer from list
	 */
	public void deregister(Observer observer) {
		this.observers.remove(observer);
	}
}
