package funct.service;

import java.util.Comparator;
import java.util.List;

import data.Cities;
import domain.City;

/**
 * Get City with maximum population density
 * 
 * @author Gautam
 *
 */
public class PopulationSurveyService {
	public static void main(String[] args) {
		getCityWithMaxPopulationDensityUsingSorting(Cities.getAllCities());
		getCityWithMaxPopulationDensityUsingMapReduce(Cities.getAllCities());
	}

	private static void getCityWithMaxPopulationDensityUsingMapReduce(List<City> cities) {
		cities.stream()
			  .reduce((a, b) -> a.getPopulationDensity() > b.getPopulationDensity() ? a : b)
			  .ifPresent(System.out::println);
	}

	private static void getCityWithMaxPopulationDensityUsingSorting(List<City> cities) {
		cities.stream()
		  .sorted(Comparator.comparing(City::getPopulationDensity).reversed())
		  .findFirst()
		  .ifPresent(System.out::println);
	}
}
