package funct.service;

import java.util.List;

import data.OracleCodeChicago;
import domain.Attendee;

/**
 * Get Average age of all attendees
 * 
 * @author Gautam
 *
 */
public class StreamExcercise {
	public static void main(String[] args) {
		List<Attendee> attendees = OracleCodeChicago.getAttendees();
		attendees.stream()
				 .map(Attendee::getFirstName)
				 .mapToInt(String::length)
				 .average()
				 .ifPresent(System.out::println);

		System.out.println(
				(double)attendees.stream()
				 .map(Attendee::getFirstName)
				 .map(String::length)
				 .reduce(0, (a, b) -> a + b)
				 .intValue()/attendees.size());
	}
}
