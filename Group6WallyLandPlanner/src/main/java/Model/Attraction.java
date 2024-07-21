/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Abstract class to hold the information for general attractions.
 * 
 * @version 1.0
 * @since 2024-06/09
 * @author Paul
 * 
 */
public abstract class Attraction {
    
    private String name;
    private String location;
    private String description;
         
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
 * Gets the location of the attraction.
 * 
 * @return the location.
 */
    
    public String getLocation()
    {
        return location;
    }
    
/**
 * Sets the location of the attraction.
 * 
 * @param location the location of the attraction.
 */
    
    
    public void setLocation(String location)
    {
        this.location=location;
    }
    
        /**
 * Gets the description for the attraction.
 * 
 * @return the description.
 */
    
    public String getDescription()
    {
        return description;
    }
    
 /**
 * Sets the description for the attraction.
 * 
 * @param description the description for the attraction.
 */
    
    
    public void setDescription(String description)
    {
        this.description=description;
    }
    
    public abstract String getAttractionType();
}
