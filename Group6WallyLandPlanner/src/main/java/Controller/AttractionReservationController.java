/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Attraction;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages reservations for attractions.
 * 
 * @version 1.0
 * @since 2024-06-09
 * 
 * @author: bemmi
 */
public class AttractionReservationController {
    
    List<Attraction> attractionList = new ArrayList<>();
    
    /**
     * Adds an attraction to the list.
     * 
     * @param attraction the attraction to be added.
     * @return true if the attraction was added successfully, false otherwise.
     */
    public boolean addAttraction(Attraction attraction) {
        return attractionList.add(attraction);
    }    
    
    /**
     * Removes an attraction from the list.
     * 
     * @param attraction the attraction to be removed.
     * @return true if the attraction was removed successfully, false otherwise.
     */
    public boolean removeAttraction(Attraction attraction) {
        return attractionList.remove(attraction);
    }
    
    /**
     * Gets the list of all attractions.
     * 
     * @return the list of all attractions.
     */
    public List<Attraction> getAttractions() {
        return new ArrayList<>(attractionList);
    }
    
    /**
     * Checks if an attraction is available.
     * 
     * @param attraction the attraction to check.
     * @return true if the attraction is available, false otherwise.
     */
    public boolean isAttractionAvailable(Attraction attraction) {
        return attractionList.contains(attraction);
    }
}
