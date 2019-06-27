package by.epam.parking.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

	private File file = new File("resources/parking.json");

	public String readFile() {
		String jsonString = null;
		if (file.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(file));) {
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				jsonString = sb.toString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return jsonString;
	}

	public void writeFile(String jsonString) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
