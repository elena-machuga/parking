package by.epam.parking.command.impl;

import by.epam.parking.command.Action;

public class DefaultAction implements Action {

	@Override
	public void doAction() {
		System.out.println("Undefined action. Please try again.");
	}

}
