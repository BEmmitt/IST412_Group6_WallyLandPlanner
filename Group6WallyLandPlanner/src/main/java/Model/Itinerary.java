/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;

/**
 *
 * @author pault
 * @version 1.0
 * @since 2024-06-09
 */
public class Itinerary {
    
    private User user;
    private List<Reservation> reservations;
    
       /**
 * Gets the user who made the itinerary.
 * 
 * @return the user.
 */
    
    public User getUser()
    {
        return user;
    }
    
       /**
 * Sets the user who made the itinerary.
 * 
 * @param user the user to set for the itinerary.
 */
    
    
    public void setUser(User user)
    {
        this.user=user;
    }
    
           /**
 * Gets the user's reservations.
 * 
 * @return the user's reservations.
 */
    
    public List<Reservation> getReservations()
    {
        return reservations;
    }
    
        /**
 * sets the list of the user's reservations in the itinerary.
 * 
 * @param reservations the reservations in the user's itinerary.
 */
    
    public void setReservations(List<Reservation> reservations)
    {
        this.reservations=reservations;
    }
            
    
}
