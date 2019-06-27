package by.epam.parking.command.impl;

import by.epam.parking.command.Action;
import by.epam.parking.entity.Parking;

public class ParkCarAction implements Action {

	@Override
	public void doAction() {
		Parking parking = PARKING_MANAGER.getParking();
		
		

	}

}
