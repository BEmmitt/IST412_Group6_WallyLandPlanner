/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * Represents a reservation for an attraction made by a user.
 * 
 * @version 1.0
 * @since 2024-06-09
 * 
 * @author: bemmi
 */
public class AttractionReservation extends Reservation{
    
    User user;
    Attraction attraction;
    Date reserveDate;
    
    /**
     * Gets the user who made the reservation.
     * 
     * @return the user who made the reservation.
     */
    @Override
    public User getUser(){
        return user;
    }
    
    /**
     * Sets the user who made the reservation.
     * 
     * @param user the user to set for the reservation.
     */
    @Override
    public void setUser(User user){
        this.user = user;
    }
    
     /**
     * Gets the attraction that has been reserved.
     * 
     * @return the attraction that has been reserved.
     */
    public Attraction getAttraction(){
        return attraction;
    }
    
    /**
     * Sets the attraction that has been reserved.
     * 
     * @param attraction the attraction to set for the reservation.
     */
    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
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
