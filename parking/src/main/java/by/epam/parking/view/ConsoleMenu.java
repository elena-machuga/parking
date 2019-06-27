package by.epam.parking.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam.parking.command.Action;
import by.epam.parking.command.ActionController;
import by.epam.parking.utility.ConsoleInputReader;

public class ConsoleMenu {

	private static boolean goOn = true;
	private static boolean goOnPark = true;

	public static void menuCycle() {
		while (goOn) {
			ConsoleMenu.printMenu();
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

	public static void parkCarMenu() {
		while (goOnPark) {
			ConsoleMenu.printMenuPark();
			String input = null;
			List<String> values = new ArrayList<>();
			try {
				for (int i = 0; i < 4; i++) {
					input = ConsoleInputReader.readUserInput();
					if (input.toUpperCase().equals("Q")) {
						break;
					} else {
						values.add(input);
					}
				}

			} catch (IOException e) {
				System.out.println("Cannot read");
				e.printStackTrace();
			}
		}

	}

	public static void setGoOn(boolean goOn) {
		ConsoleMenu.goOn = goOn;
	}

	private static void printMenu() {
		System.out.println("Please select action number:");
		System.out.println("1. View parking state");
		System.out.println("2. Park a car");
		System.out.println("3. Remove a car from slot");
		System.out.println("4. Exit");

	}

	private static void printMenuPark() {
		System.out.println("Please enter info one by one or q for cancel");
		System.out.println("1. Car model");
		System.out.println("2. Car number");
		System.out.println("3. Car owner");
		System.out.println("4. Slot number");

	}

}
