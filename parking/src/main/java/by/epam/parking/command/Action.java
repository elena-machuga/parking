package by.epam.parking.command;

import by.epam.parking.manager.ParkingManager;

public interface Action {

	static final ParkingManager PARKING_MANAGER = new ParkingManager();
	
	void doAction();
}
