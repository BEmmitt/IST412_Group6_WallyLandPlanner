/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;

/**
 * Holds the information for the attractions.
 * 
 * @version 1.0
 * @since 2024-06/09
 * @author Paul
 * 
 */
public class Attraction {
    
    private String name;
    private int capacity;
    private Date timeSlot;
         
 /**
 * Gets the name of the attraction.
 * 
 * @return the attraction.
 */
    
    public String getName()
    {
        return name;
    }
    
/**
 * Sets the name of the attraction.
 * 
 * @param name the name of the attraction.
 */
    
    public void setName(String name)
    {
        this.name=name;
    }
    
 /**
 * Gets the capacity of the attraction.
 * 
 * @return the capacity.
 */
    
    public int getCapacity()
    {
        return capacity;
    }
    
/**
 * Sets the capacity of the attraction.
 * 
 * @param capacity the capacity of the attraction.
 */
    
    
    public void setCapacity(int capacity)
    {
        this.capacity=capacity;
    }
    
        /**
 * Gets the time slots for the attraction.
 * 
 * @return the time slots.
 */
    
    public Date getTimeSlot()
    {
        return timeSlot;
    }
    
 /**
 * Sets the time slots for the attraction.
 * 
 * @param timeSlot the time slots for the attraction.
 */
    
    
    public void setTimeSlot(Date timeSlot)
    {
        this.timeSlot=timeSlot;
    }
}
