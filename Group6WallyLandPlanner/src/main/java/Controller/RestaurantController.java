/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Planner;
import Model.Restaurant;
import View.PlannerView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the actions related to restaurant reservations.
 * 
 * @version 1.0
 * @since 2024-07-30
 * @author pault
 */
public class RestaurantController {

    private Planner planner;
    private PlannerView plannerView;
    private List<Restaurant> availableRestaurants; // To track reservation history

    /**
     * Constructor for the RestaurantReservationController class.
     */
    public RestaurantController() {
        this.availableRestaurants = new ArrayList<>();
    }
    
    public void loadRestaurantsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Skip the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                // Assuming each line is in the format: name,location,description,cuisineType,timeSlot
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String name = parts[0].trim();
                    String location = parts[1].trim();
                    String description = parts[2].trim();
                    String cuisineType = parts[3].trim();
                    String timeSlot = parts[4].trim();

                    Restaurant restaurant = new Restaurant(name, location, description, cuisineType);
                    restaurant.setTimeSlot(timeSlot);

                    addRestaurants(restaurant);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> getAvailableRestaurants() {
        return availableRestaurants;
    }

    // Adds an attraction to the planner
    public void addRestaurants(Restaurant restaurant) {
        if (!availableRestaurants.contains(restaurant)) {
            availableRestaurants.add(restaurant);
        }
    }
}