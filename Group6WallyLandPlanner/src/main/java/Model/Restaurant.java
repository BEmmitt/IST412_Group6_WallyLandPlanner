/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 * Shows information about Restaurants including Address and Ratings.
 * 
 * @version 1.0
 * @since 2024-06-09
 * @author Praj
 */
public class Restaurant {
    
    private String name;
    private String address;
    private List<String> menu;
    private double rating;
    
    /**
     * Gets the name of the restaurant.
     * 
     * @return the name of the restaurant.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the restaurant.
     * 
     * @param name the name to set for the restaurant.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the address of the restaurant.
     * 
     * @return the address of the restaurant.
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Sets the address of the restaurant.
     * 
     * @param address the address to set for the restaurant.
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Gets the menu of the restaurant.
     * 
     * @return the menu of the restaurant.
     */
    public List<String> getMenu() {
        return menu;
    }
    
    /**
     * Sets the menu of the restaurant.
     * 
     * @param menu the menu to set for the restaurant.
     */
    public void setMenu(List<String> menu) {
        this.menu = menu;
    }
    
    /**
     * Gets the rating of the restaurant.
     * 
     * @return the rating of the restaurant.
     */
    public double getRating() {
        return rating;
    }
    
    /**
     * Sets the rating of the restaurant.
     * 
     * @param rating the rating to set for the restaurant.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
}
