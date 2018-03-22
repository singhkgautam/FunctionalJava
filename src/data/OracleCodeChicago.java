package data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Attendee;

public class OracleCodeChicago {
	public static List<Attendee> getAttendees() {
		List<Attendee> attendees = new ArrayList<Attendee>();
		try{
			Path attendeeFilePath = Paths.get(ClassLoader.getSystemResource("attendee.csv").toURI());
			attendees = Files.lines(attendeeFilePath)
							 .skip(1)
							 .map(a -> { 
								 	String[] csvValues = a.split(","); 
								 	return new Attendee(csvValues[0], csvValues[1], csvValues[2], csvValues[4], Integer.parseInt(csvValues[3])); 
								 })
							 .collect(Collectors.toList());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return attendees;
	}
}
