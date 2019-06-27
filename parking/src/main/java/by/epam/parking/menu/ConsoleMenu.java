package by.epam.parking.menu;

import java.io.IOException;

import by.epam.parking.command.Action;
import by.epam.parking.command.ActionController;
import by.epam.parking.utility.ConsoleInputReader;

public class ConsoleMenu {

	private static boolean goOn = true;

	public static void menuCycle() {

		ConsoleMenu menu = new ConsoleMenu();

		while (goOn) {
			menu.printMenu();

			String input = null;

			try {
				input = ConsoleInputReader.readUserInput();
			} catch (IOException e) {
				System.out.println("Cannot read");
				e.printStackTrace();
			}

			Action action = ActionController.defineAction(input);
			action.doAction();
		}

	}

	public static void setGoOn(boolean goOn) {
		ConsoleMenu.goOn = goOn;
	}

	private void printMenu() {
		System.out.println("Please select action number:");
		System.out.println("1. View parking state");
		System.out.println("2. Park a car");
		System.out.println("3. Remove a car from slot");
		System.out.println("4. Exit.");

	}

}
