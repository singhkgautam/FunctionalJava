package funct.service;

import java.util.List;

import data.OracleCodeChicago;
import domain.Attendee;

/**
 * Check if there are 10 or more attendees 
 * less than 21 years old.
 * 
 * @author Gautam
 *
 */
public class LazyEvalExcercise {
	public static void main(String[] args) {
		lazyEval(OracleCodeChicago.getAttendees());
	}
	
	/**
	 * Optimal implementation only processing till it 
	 * found 10 attendees with age less than 21
	 * @param attendees
	 * @return
	 */
	public static boolean lazyEval(List<Attendee> attendees) {
		return attendees.stream()
						.parallel()
						.filter(a -> a.getAge() < 21)
						.peek(System.out::println)
						.limit(10)
						.count() == 10;
	}
	
	/**
	 * Non optimal implementation as it will 
	 * process all attendees in the list
	 * 
	 * @param attendees
	 * @return
	 */
	public static boolean evalAll(List<Attendee> attendees) {
		return attendees.stream()
						.parallel()
						.filter(a -> a.getAge() < 21)
						.peek(System.out::println)
						.count() >= 10;
	}
}
