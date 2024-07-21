/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Attraction;
import Model.Planner;
import Model.Reservation;
import java.util.List;

/**
 * Manages the itinerary, allowing reservations to be added, removed, and viewed.
 * 
 * @version 1.0
 * @since 2024-06-09
 * 
 * @author: bemmi
 */
public class PlannerController {
    
    Planner planner = new Planner();
    
    /**
     * Adds a reservation to the itinerary.
     * 
     * @param attraction the reservation to be added.
     * @return true if the reservation was added successfully, false otherwise.
     */
    public boolean addAttraction(Attraction attraction) {
        return planner.getAttractions().add(attraction);
    }

    /**
     * Removes a reservation from the itinerary.
     * 
     * @param attraction the attraction to be removed.
     * @return true if the reservation was removed successfully, false otherwise.
     */
    public boolean removeAttraction(Attraction attraction) {
        return planner.getAttractions().remove(attraction);
    }

    /**
     * Gets the list of reservations in the itinerary.
     * 
     * @return the list of reservations in the itinerary.
     */
    public List<Attraction> getReservations() {
        return planner.getAttractions();
    }

    public Planner getPlanner(){
        return planner;
    }
}