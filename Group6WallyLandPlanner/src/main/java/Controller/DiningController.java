/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Restaurant;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages dining reservations and operations for restaurants.
 * 
 * @version 1.0
 * @since 2024-06-09
 * 
 * @author: bemmi
 */
public class DiningController {

    List<Restaurant> restaurantList = new ArrayList<>();
        
    /**
     * Adds a restaurant to the list.
     * 
     * @param restaurant the restaurant to be added.
     * @return true if the restaurant was added successfully, false otherwise.
     */
    public boolean addRestaurant(Restaurant restaurant) {
        return restaurantList.add(restaurant);
    }  
    
    /**
     * Removes a restaurant from the list.
     * 
     * @param restaurant the restaurant to be Removed.
     * @return true if the restaurant was removed successfully, false otherwise.
     */
    public boolean removeRestaurant(Restaurant restaurant) {
        return restaurantList.remove(restaurant);
    }
    
     /**
     * Gets the list of all restaurants.
     * 
     * @return the list of all restaurants.
     */
    public List<Restaurant> getRestaurants() {
        return new ArrayList<>(restaurantList);
    }

    /**
     * Checks if a restaurant is available.
     * 
     * @param restaurant the restaurant to check.
     * @return true if the restaurant is available, false otherwise.
     */
    public boolean isRestaurantAvailable(Restaurant restaurant) {
        return restaurantList.contains(restaurant);
    }
}
