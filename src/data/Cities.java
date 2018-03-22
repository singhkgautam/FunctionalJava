package data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.City;

public class Cities {
	public static List<City> getAllCities() {
		List<City> cities = new ArrayList<City>();
		try {
			Path attendeeFilePath = Paths.get(ClassLoader.getSystemResource("cities.csv").toURI());
			cities = Files.lines(attendeeFilePath, Charset.forName("Cp1252"))
						.skip(1)
						.map(a -> {
								String[] cols = a.split(",");
								return City.builder()
										.name(cols[0].trim())
										.country(cols[1].trim())
										.population(Long.parseLong(cols[2].trim()))
										.area(Double.parseDouble(cols[3].trim()))
										.build();
							})
						.collect(Collectors.toList());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return cities;
	}
}
