/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Itinerary;
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
    
    Itinerary itinerary = new Itinerary();
    
    /**
     * Adds a reservation to the itinerary.
     * 
     * @param reservation the reservation to be added.
     * @return true if the reservation was added successfully, false otherwise.
     */
    public boolean addReservation(Reservation reservation) {
        return itinerary.getReservations().add(reservation);
    }

    /**
     * Removes a reservation from the itinerary.
     * 
     * @param reservation the reservation to be removed.
     * @return true if the reservation was removed successfully, false otherwise.
     */
    public boolean removeReservation(Reservation reservation) {
        return itinerary.getReservations().remove(reservation);
    }

    /**
     * Gets the list of reservations in the itinerary.
     * 
     * @return the list of reservations in the itinerary.
     */
    public List<Reservation> getReservations() {
        return itinerary.getReservations();
    }

    /**
     * Checks if a reservation is in the itinerary.
     * 
     * @param reservation the reservation to check.
     * @return true if the reservation is in the itinerary, false otherwise.
     */
    public boolean isResInItin(Reservation reservation) {
        return itinerary.getReservations().contains(reservation);
    }
}