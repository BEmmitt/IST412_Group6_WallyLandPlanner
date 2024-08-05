/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Shows information about Restaurants including Address and Ratings.
 * 
 * @version 2.0
 * @since 2024-07-31
 * @author Jordan
 */
public class Restaurant extends Attraction{

    private String cuisineType;
    private String timeSlot;

    /**
     * Constructor for the Restaurant class.
     * 
     * @param name        The name of the restaurant.
     * @param location    The location of the restaurant.
     * @param description A description of the restaurant.
     * @param cuisineType The type of cuisine the restaurant offers.
     */
    public Restaurant(String name, String location, String description, String cuisineType) {
        setName(name);
        setLocation(location);
        setDescription(description);
        this.cuisineType = cuisineType;
    }

    /**
     * Gets the type of cuisine the restaurant offers.
     * 
     * @return The cuisine type as a String.
     */
    public String getCuisineType() {
        return cuisineType;
    }

    /**
     * Sets the type of cuisine the restaurant offers.
     * 
     * @param cuisineType The new cuisine type.
     */
    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
       
    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * Gets the attraction type, which is "Restaurant" for this class.
     * 
     * @return The attraction type as a String.
     */
    @Override
    public String getAttractionType() {
        return "Restaurant";
    }
    
    @Override
    public String toString() {
        return ("Type: " + getAttractionType() + " | Name: " + getName() + " | Cuisine Type: " + getCuisineType() + " | Location: " + getLocation() + " | Description: " + getDescription() + " | Reservation Time: " + getTimeSlot());
                
    }
}