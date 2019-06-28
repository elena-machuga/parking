package by.epam.parking.command.impl;

import by.epam.parking.command.Action;
import by.epam.parking.view.ConsoleMenu;

public class ExitAction implements Action {

	@Override
	public void doAction() {
		ConsoleMenu.setGoOn(false);
		System.out.println("Bye!");

	}

}
