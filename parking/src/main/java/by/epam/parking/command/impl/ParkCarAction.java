package by.epam.parking.command.impl;

import java.util.List;

import by.epam.parking.command.Action;
import by.epam.parking.entity.Car;
import by.epam.parking.entity.Parking;
import by.epam.parking.entity.Slot;
import by.epam.parking.view.ConsoleMenu;

public class ParkCarAction implements Action {

	@Override
	public void doAction() {
		Parking parking = PARKING_MANAGER.getParking();
		List<String> values = ConsoleMenu.parkCarMenu();
		if (values.size() == 4) {
			int slotNumber = Integer.parseInt(values.get(3)) - 1;
			Slot slot = parking.getSlots().get(slotNumber);
			if (!slot.isOccupied()) {
				Car car = new Car(values.get(0), values.get(1), values.get(2));
				slot.setCar(car);
				slot.setOccupied(true);
				PARKING_MANAGER.saveParking(parking);
				System.out.println("Done");
			} else {
				System.out.println("Slot is occupied");
			}
		}
	}

}
