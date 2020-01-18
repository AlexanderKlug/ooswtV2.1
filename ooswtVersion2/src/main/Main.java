package main;

import controller.Controller;
import facade.Facade;
import view.View;

/*
 * starts application
 */
public class Main {

	public static void main(String[] args) {
		Facade facade = new Facade();
		View view1 = new View();
		view1.setVisible(true);
		Controller controller1 = new Controller(view1, facade);
		View view2 = new View();
		view2.setVisible(true);
		Controller controller2 = new Controller(view2, facade);
		facade.register(controller2);
		facade.register(controller1);
	}
}
