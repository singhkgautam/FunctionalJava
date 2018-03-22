package domain;

public class City {
	private final String name;
	private final String country;
	private final long population;
	private final double area;

	private City(Builder builder) {
		this.name = builder.name;
		this.country = builder.country;
		this.population = builder.population;
		this.area = builder.area;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public double getArea() {
		return area;
	}

	public long getPopulation() {
		return population;
	}
	
	public double getPopulationDensity() {
		return population/area;
	}

	public String toString() {
		return (name + " : " + population + " : " + area + " : " + country);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String name;
		private String country;
		private long population;
		private double area;

		private Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder country(String country) {
			this.country = country;
			return this;
		}

		public Builder population(long population) {
			this.population = population;
			return this;
		}

		public Builder area(double area) {
			this.area = area;
			return this;
		}

		public City build() {
			return new City(this);
		}
	}

}
