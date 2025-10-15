package com.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of City objects.
 */
public class CityList {

    /** The list of cities */
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not already exist.
     * @param city This is the city to add
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in the list.");
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities by their names.
     * @return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether the list contains the specified city.
     * @param city the city to look for
     * @return true if the city exists in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list if it exists.
     * @param city the city to delete
     * @throws IllegalArgumentException if the city is not found
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in list.");
        }
        cities.remove(city);
    }

    /**
     * Returns how many cities are in the list.
     * @return the number of cities
     */
    public int countCities() {
        return cities.size();
    }
}
