package by.epam.parking.control;

import java.util.ArrayList;
import java.util.List;

import by.epam.parking.entity.Parking;
import by.epam.parking.entity.Slot;
import by.epam.parking.service.FileService;
import by.epam.parking.service.JsonConverter;

public class ParkingManager {

	private FileService fs = new FileService();
	private JsonConverter jc = new JsonConverter();

	public Parking getParking() {
		Parking parking = null;
		String fileData = fs.readFile();
		if (fileData != null) {
			parking = jc.fromJson(fileData);
		}else {
			List<Slot> slots = new ArrayList<>();			
			for (int i = 0; i<10; i++) {
				slots.add(new Slot(i+1, false, null));
			}
			parking= new Parking(slots);
		}
		return parking;
	}

}
