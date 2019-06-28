package by.epam.parking.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam.parking.command.Action;
import by.epam.parking.command.ActionController;
import by.epam.parking.utility.ConsoleInputHandler;

public class ConsoleMenu {

	private static boolean goOn = true;
	private static boolean go = true;

	public static void menuCycle() {
		while (goOn) {
			ConsoleMenu.printMenu();
			String input = null;
			try {
				input = ConsoleInputHandler.readUserInput();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Action action = ActionController.defineAction(input);
			action.doAction();
		}

	}

	public static List<String> parkCarMenu() {
		System.out.println("Please enter car info and slot # for parking or q for cancel");
		String carName = null;
		String carNumber = null;
		String carOwner = null;
		String slotNumber = null;
		List<String> values = new ArrayList<>();
		if (go) {
			carName = requestString("Car model");
		}
		if (go) {
			carNumber = requestString("Car number");
		}
		if (go) {
			carOwner = requestString("Car owner");
		}
		if (go) {
			slotNumber = requestNumber("Slot number 1-10");
		}
		if (go) {
			values.add(carName);
			values.add(carNumber);
			values.add(carOwner);
			values.add(slotNumber);
		}
		go = true;
		return values;
	}

	public static String removeCarMenu() {
		System.out.println("Please enter car number to leave the parking or q for cancel");
		String carNumber = null;
		if (go) {
			carNumber = requestString("Car number");
		}
		go = true;
		return carNumber;
	}

	private static String requestNumber(String request) {
		String str = null;
		do {
			System.out.println(request);
			try {
				str = ConsoleInputHandler.readUserInput();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (str != null && !str.isEmpty()) {
				if (str.toUpperCase().equals("Q")) {
					go = false;
					System.out.println("Cancel");
					break;
				} else if (!isSlotNumber(str)) {
					str = null;
				}
			}
		} while (str == null || str.isEmpty());
		return str;
	}

	private static String requestString(String request) {
		String str = null;
		do {
			System.out.println(request);
			try {
				str = ConsoleInputHandler.readUserInput();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (str != null && !str.isEmpty()) {
				if (str.toUpperCase().equals("Q")) {
					go = false;
					System.out.println("Cancel");
					break;
				}
			}
		} while (str == null || str.isEmpty());
		return str;
	}

	private static boolean isSlotNumber(String str) {
		String regex = "[^0-9]";
		String fstr = str.replaceAll(regex, "");
		if (fstr != null && !fstr.isEmpty() && (Integer.parseInt(fstr) <= 10)) {
			return true;
		}
		return false;
	}

	private static void printMenu() {
		System.out.println("Please select action number:");
		System.out.println("1. View parking state");
		System.out.println("2. Park a car");
		System.out.println("3. Remove a car from slot");
		System.out.println("4. Exit");

	}

	public static void setGoOn(boolean goOn) {
		ConsoleMenu.goOn = goOn;
	}

}
