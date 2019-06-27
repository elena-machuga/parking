package by.epam.parking.command;

import by.epam.parking.command.impl.ParkCarAction;
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
			action = null;
			break;
		case "4":
			action = null;
			break;
		default:
			action = null;
			break;
		}
		
		return action;

	}

}
