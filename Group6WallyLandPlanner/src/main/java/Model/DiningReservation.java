/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * Represents a reservation for a dining experience made by a user.
 * 
 * @version 1.0
 * @since 2024-06-09
 * 
 * @author: Praj
 */
public class DiningReservation {
    
    User user;
    Restaurant restaurant;
    Date reserveDate;
    
    /**
     * Gets the user who made the reservation.
     * 
     * @return the user who made the reservation.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who made the reservation.
     * 
     * @param user the user to set for the reservation.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the restaurant that has been reserved.
     * 
     * @return the restaurant that has been reserved.
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * Sets the restaurant that has been reserved.
     * 
     * @param restaurant the restaurant to set for the reservation.
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * Gets the date of the reservation.
     * 
     * @return the date of the reservation.
     */
    public Date getReserveDate() {
        return reserveDate;
    }

    /**
     * Sets the date of the reservation.
     * 
     * @param reserveDate the date to set for the reservation.
     */
    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }
}