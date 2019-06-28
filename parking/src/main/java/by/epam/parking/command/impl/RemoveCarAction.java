package by.epam.parking.command.impl;

import java.util.List;

import by.epam.parking.command.Action;
import by.epam.parking.entity.Parking;
import by.epam.parking.entity.Slot;
import by.epam.parking.view.ConsoleMenu;

public class RemoveCarAction implements Action {

	@Override
	public void doAction() {
		Parking parking = PARKING_MANAGER.getParking();
		String carNumber = ConsoleMenu.removeCarMenu();

		if (carNumber != null) {
			List<Slot> slots = parking.getSlots();
			Slot slot = slots.stream().filter(sl -> sl.isOccupied())
					.filter(sl -> carNumber.equals(sl.getCar().getNumber())).findAny().orElse(null);
			if (slot != null) {
				slot.setOccupied(false);
				slot.setCar(null);
				PARKING_MANAGER.saveParking(parking);
				System.out.println("Thank you for using our service!");
			}else {
				System.out.println("Car not found");
			}
		} else {
			System.out.println("Operation failed");
		}

	}

}
