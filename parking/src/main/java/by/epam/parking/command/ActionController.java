package by.epam.parking.command;

import by.epam.parking.command.impl.DefaultAction;
import by.epam.parking.command.impl.ExitAction;
import by.epam.parking.command.impl.ParkCarAction;
import by.epam.parking.command.impl.RemoveCarAction;
import by.epam.parking.command.impl.ViewParkStateAction;

public class ActionController {

	public static Action defineAction(String input) {
		Action action = null;

		switch (input) {
		case "1":
			action = new ViewParkStateAction();
			break;
		case "2":
			action = new ParkCarAction();
			break;
		case "3":
			action = new RemoveCarAction();
			break;
		case "4":
			action = new ExitAction();
			break;
		default:
			action = new DefaultAction();
			break;
		}

		return action;

	}

}
