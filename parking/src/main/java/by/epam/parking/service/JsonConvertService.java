package by.epam.parking.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.epam.parking.entity.Parking;

public class JsonConvertService {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public String toJson(Parking parking) {
		String result = null;
		try {
			result = mapper.writeValueAsString(parking);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Parking fromJson(String jsonString) {
		Parking parking = null;
		try {
			parking = mapper.readValue(jsonString, Parking.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parking;
	}
}
