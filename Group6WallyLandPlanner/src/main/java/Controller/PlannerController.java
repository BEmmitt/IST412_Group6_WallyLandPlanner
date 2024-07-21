/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Attraction;
import Model.Planner;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
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
    
    User user;
    Planner planner;
    Gson gson;
    
    public PlannerController(User user) {
        this.user = user;
        this.planner = Planner.loadPlanner(user.getUsername(), user);
        System.out.println("PlannerController initialized for user: " + user.getUsername());
        
    }
    /**
     * Adds a reservation to the itinerary.
     * 
     * @param attraction the reservation to be added.
     * @return true if the reservation was added successfully, false otherwise.
     */
    public boolean addAttraction(Attraction attraction) {
        boolean result = planner.getAttractions().add(attraction);
        planner.savePlanner(user.getUsername());
        return result;
    }

    /**
     * Removes a reservation from the itinerary.
     * 
     * @param attraction the attraction to be removed.
     * @return true if the reservation was removed successfully, false otherwise.
     */
    public boolean removeAttraction(Attraction attraction) {
        boolean result = planner.getAttractions().remove(attraction);
        planner.savePlanner(user.getUsername());
        return result;
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
        if (planner.getUser() == null) {
            planner.setUser(user);
        }
        return planner;
    }
    
    
}