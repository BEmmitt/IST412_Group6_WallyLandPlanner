/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * Represents a show with a name, date, and time.
 * Provides methods to get and set these attributes.
 * 
 * @author Jordan
 */
public class Show extends Attraction {
    private String showTime;

    /**
     * Constructs a new Show object.
     * 
     * @param name the name of the show.
     * @param location the location of the show.
     * @param description the description of the show.
     * @param showTime the show time of the show.
     */
    public Show(String name, String location, String description, String showTime) {
        setName(name);
        setLocation(location);
        setDescription(description);
        this.showTime = showTime;
    }

    /**
     * Gets the show time of the show.
     * 
     * @return the show time.
     */
    public String getShowTime() {
        return showTime;
    }

    /**
     * Sets the show time of the show.
     * 
     * @param showTime the show time to set.
     */
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    /**
     * Gets the type of the attraction.
     * 
     * @return the attraction type.
     */
    @Override
    public String getAttractionType() {
        return "Show";
    }
}