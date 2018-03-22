package funct.service;

import java.util.Comparator;
import java.util.List;

import data.OracleCodeChicago;
import domain.Attendee;

/**
 * Print all Attendees with age in 
 * alphabetical order of their names
 *  
 * @author Gautam
 *
 */
public class OracleCodeEventManager {
	public static void main(String[] args) {
//		printAllAttendeesFirstAttempt(OracleCodeChicago.getAttendees());
//		printAllAttendeesSecondAttempt(OracleCodeChicago.getAttendees());
//		printAllAttendeesThirdAttempt(OracleCodeChicago.getAttendees());
		printAllAttendeesFinal(OracleCodeChicago.getAttendees());
	}

	/**
	 * With anonymous class
	 * @param attendees
	 */
	private static void printAllAttendeesFirstAttempt(List<Attendee> attendees) {
		attendees.sort( new Comparator<Attendee>() {
			@Override
			public int compare(Attendee a1, Attendee a2) {
				return a1.getLastName().compareTo(a2.getLastName());
			}
		});
		
		for (Attendee attendee : attendees) {
			System.out.println(attendee);
		}
	}
	
	/**
	 * Using Lambda with Parameter type
	 * @param attendees
	 */
	private static void printAllAttendeesSecondAttempt(List<Attendee> attendees) {
		attendees.sort((Attendee a1, Attendee a2) -> {
			return a1.getLastName().compareTo(a2.getLastName());
		});
		
		for (Attendee attendee : attendees) {
			System.out.println(attendee);
		}
	}

	/**
	 * Using Lambda without the parameter types
	 * @param attendees
	 */
	private static void printAllAttendeesThirdAttempt(List<Attendee> attendees) {
		attendees.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		for (Attendee attendee : attendees) {
			System.out.println(attendee);
		}
	}

	/**
	 * Final attempt using Method reference
	 * @param attendees
	 */
	private static void printAllAttendeesFinal(List<Attendee> attendees) {
		attendees.sort(Comparator.comparing(Attendee::getLastName));
		
		attendees.forEach(System.out::println);
	}

}
