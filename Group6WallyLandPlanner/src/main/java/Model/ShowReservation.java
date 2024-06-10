/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * Represents a reservation for a show made by a user.
 * 
 * @version 1.0
 * @since 2024-06-09
 * 
 * @author: bemmi
 */
public class ShowReservation extends Reservation {
    
    User user;
    Show show;
    Date reserveDate;
    
     /**
     * Gets the user who made the reservation.
     * 
     * @return the user who made the reservation.
     */
    @Override
    public User getUser() {
        return user;
    }
    
    /**
     * Sets the user who made the reservation.
     * 
     * @param user the user to set for the reservation.
     */
    @Override
    public void setUser(User user) {
        this.user = user;
    }

     /**
     * Gets the show that has been reserved.
     * 
     * @return the show that has been reserved.
     */
    public Show getShow() {
        return show;
    }

    /**
     * Sets the show that has been reserved.
     * 
     * @param show the show to set for the reservation.
     */
    public void setShow(Show show) {
        this.show = show;
    }

    /**
     * Gets the date of the reservation.
     * 
     * @return the date of the reservation.
     */
    @Override
    public Date getReserveDate() {
        return reserveDate;
    }

    /**
     * Sets the date of the reservation.
     * 
     * @param reserveDate the date to set for the reservation.
     */
    @Override
    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }   
}
