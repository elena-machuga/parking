package by.epam.parking.command.impl;

import by.epam.parking.command.Action;
import by.epam.parking.entity.Car;
import by.epam.parking.entity.Parking;
import by.epam.parking.entity.Slot;

public class ViewParkStateAction implements Action {

	@Override
	public void doAction() {
		Parking parking = PARKING_MANAGER.getParking();
		for (Slot slot : parking.getSlots()) {
			int slotId = slot.getId();
			Car car = slot.getCar();
			String slotState;
			if (car != null) {
				slotState = car.toString();
			} else {
				slotState = "Available";
			}
			System.out.println("Slot #" + slotId + " " + slotState);
		}

	}

}
