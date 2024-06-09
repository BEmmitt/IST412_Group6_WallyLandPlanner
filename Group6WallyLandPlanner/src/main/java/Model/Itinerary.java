/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;

/**
 *
 * @author pault
 */
public class Itinerary {
    
    private User user;
    private List<Reservation> Reservations;
    
    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user=user;
    }
    
    public List<Reservation> getReservations()
    {
        return reservations;
    }
    
    public void setReservations(List<Reservation> reservations)
    {
        this.reservations=reservations;
    }
            
    
}
