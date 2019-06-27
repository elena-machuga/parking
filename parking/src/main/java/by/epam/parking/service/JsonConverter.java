package by.epam.parking.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.epam.parking.entity.Parking;

public class JsonConverter {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public String toJson(Parking parking) {
		return mapper.writeValueAsString(parking);
	}

	public Parking fromJson(String jsonString) {
		Parking parking = null;
		try {
			parking = mapper.readValue(jsonString, Parking.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parking;
	}
}
