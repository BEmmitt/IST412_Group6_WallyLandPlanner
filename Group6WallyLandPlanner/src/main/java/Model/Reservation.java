/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * Represents a general reservation.
 * This abstract class will be extended by specific reservation types.
 * 
 * @version 1.0
 * @since 2024-06-09
 * 
 * @author: bemmi
 */
public abstract class Reservation {
    
    /**
     * Gets the user who made the reservation.
     * 
     * @return the user who made the reservation.
     */
    public abstract User getUser();

    /**
     * Sets the user who made the reservation.
     * 
     * @param user the user to set for the reservation.
     */
    public abstract void setUser(User user);

    /**
     * Gets the date of the reservation.
     * 
     * @return the date of the reservation.
     */
    public abstract Date getReserveDate();

    /**
     * Sets the date of the reservation.
     * 
     * @param reserveDate the date to set for the reservation.
     */
    public abstract void setReserveDate(Date reserveDate);
}