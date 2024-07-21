/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Controller.AttractionNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds the information for the itinerary.
 * 
 * @version 1.0
 * @since 2024-06-09
 * @author pault
 * 
 */
public class Planner {
    
    private User user;
    private List<Attraction> reservedAttractions;
    
    public Planner() {
        this.reservedAttractions = new ArrayList<>();
    }
    
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
    
    public List<Attraction> getAttractions()
    {
        return reservedAttractions;
    }
    
        /**
 * sets the list of the user's reservations in the itinerary.
 * 
 * @param reservedAttractions the reservations in the user's itinerary.
 */
    
    public void setAttractions(List<Attraction> reservedAttractions)
    {
        this.reservedAttractions=reservedAttractions;
    }
    
    public Attraction findAttraction(String name) throws AttractionNotFoundException {
        for (Attraction attraction : reservedAttractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        throw new AttractionNotFoundException("Attraction not found with name: " + name);
    }
    
    public int getNumberOfAttractions(){
        return reservedAttractions.size();
    }
    
    public boolean hasAttraction(Attraction attraction){
        return reservedAttractions.contains(attraction);
    }
}
