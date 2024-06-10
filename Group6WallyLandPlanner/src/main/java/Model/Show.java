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
public class Show {
    
    private String name;
    private Date date;
    int capacity;
    private Date time;
    
    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * Gets the name of the show.
     * 
     * @return the name of the show
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the show.
     * 
     * @param name the new name of the show
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date of the show.
     * 
     * @return the date of the show
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the show.
     * 
     * @param date the new date of the show
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the time of the show.
     * 
     * @return the time of the show
     */
    public Date getTime() {
        return time;
    }

    /**
     * Sets the time of the show.
     * 
     * @param time the new time of the show
     */
    public void setTime(Date time) {
        this.time = time;
    }
}


