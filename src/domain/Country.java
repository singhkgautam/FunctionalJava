package domain;

/**
A country with a name, population, and area.
*/
public class Country
{
private String name;
private int population;
private double area;

/**
   Constructs a country.
   @param aName the name of the country
   @param aPopulation the population of the country
   @param anArea the area of the country
*/
public Country(String aName, int aPopulation, double anArea) 
{ 
   name = aName;
   population = aPopulation;
   area = anArea; 
}

/**
   Gets the country name.
   @return the name
*/
public String getName() 
{
   return name;
}

/**
   Gets the area of the country.
   @return the area
*/
public double getArea() 
{
   return area;
}

/**
   Gets the population of the country.
   @return the population
*/
public int getPopulation() 
{
   return population;
}

public static Country fromString(String input)
{
   String[] inputs = input.split(",");
   return new Country(inputs[0], Integer.parseInt(inputs[1]),
      Double.parseDouble(inputs[2]));
}

public String toString()
{
   return (name + ";" + population + ";" + area).replaceAll(".0$", "");
}
}
