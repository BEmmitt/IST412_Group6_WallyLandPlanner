/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author bemmi
 * @author Jordan
 */

public class Ride extends Attraction {
    private int thrillLevel;

    /**
     * Constructs a new Ride object.
     * 
     * @param name the name of the ride.
     * @param location the location of the ride.
     * @param description the description of the ride.
     * @param thrillLevel the thrill level of the ride.
     */
    public Ride(String name, String location, String description, String thrillLevel) {
        setName(name);
        setLocation(location);
        setDescription(description);
        this.thrillLevel = Integer.parseInt(thrillLevel);
    }

    /**
     * Gets the thrill level of the ride.
     * 
     * @return the thrill level.
     */
    public int getThrillLevel() {
        return thrillLevel;
    }

    /**
     * Sets the thrill level of the ride.
     * 
     * @param thrillLevel the thrill level to set.
     */
    public void setThrillLevel(int thrillLevel) {
        this.thrillLevel = thrillLevel;
    }

    /**
     * Gets the type of the attraction.
     * 
     * @return the attraction type.
     */
    @Override
    public String getAttractionType() {
        return "Ride";
    }
    
    @Override
    public String toString() {
        return ("Type: " + getAttractionType() + " | Name: " + getName() + " | Location: " + getLocation() + " | Description: " + getDescription() + " | Thrill Level: " + getThrillLevel());
                
    }
}
