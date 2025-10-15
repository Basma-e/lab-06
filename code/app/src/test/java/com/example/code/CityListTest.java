package com.example.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the functionality of the CityList class.
 */
class CityListTest {

    /**
     * Helper method to create a mock CityList containing one city.
     * @return a CityList with one city added
     */
    private com.example.code.CityList mockCityList() {
        com.example.code.CityList cityList = new com.example.code.CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Helper method to create a mock City object.
     * @return a sample City object
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * Test the add() method.
     * Ensures that adding a city increases the list size
     * and that the city is contained in the list.
     */
    @Test
    void testAdd() {
        com.example.code.CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Test that adding a duplicate city throws an IllegalArgumentException.
     */
    @Test
    void testAddException() {
        com.example.code.CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    /**
     * Test that getCities() returns a correctly sorted list.
     */
    @Test
    void testGetCities() {
        com.example.code.CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     * Test hasCity() to verify if a city exists in the list.
     */
    @Test
    void testHasCity() {
        com.example.code.CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        City notAdded = new City("Toronto", "Ontario");
        assertFalse(cityList.hasCity(notAdded));
    }

    /**
     * Test delete() to ensure it removes a city correctly.
     */
    @Test
    void testDeleteCity() {
        com.example.code.CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    /**
     * Test delete() to ensure an exception is thrown when deleting a city not in the list.
     */
    @Test
    void testDeleteException() {
        com.example.code.CityList cityList = mockCityList();
        City city = new City("Toronto", "Ontario");
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(city));
    }

    /**
     * Test countCities() to ensure it returns the correct count.
     */
    @Test
    void testCountCities() {
        com.example.code.CityList cityList = mockCityList();
        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());
    }
}
