package com.example.code;

/**
 * This is a class that defines a City.
 * Each City has a name and a province.
 * It implements Comparable so that cities can be sorted alphabetically by name.
 */
public class City implements Comparable<City> {

    /** The city name */
    private String city;

    /** The province name */
    private String province;

    /**
     * Constructs a City object.
     * @param city the name of the city
     * @param province the name of the province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name.
     * @return the city name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Gets the province name.
     * @return the province name
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares two cities by name alphabetically.
     * @param other another City object to compare with
     * @return a negative, zero, or positive integer if this city's name
     *         is lexicographically less than, equal to, or greater than the other city's name
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Determines equality based on both city and province.
     * @param obj another object to compare
     * @return true if both city and province match
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    @Override
    public int hashCode() {
        return this.city.hashCode() + this.province.hashCode();
    }

    @Override
    public String toString() {
        return this.city + ", " + this.province;
    }
}
