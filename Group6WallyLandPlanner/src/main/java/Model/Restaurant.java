/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Shows information about Restaurants including Address and Ratings.
 * 
 * @version 2.0
 * @since 2024-07-31
 * @author Jordan
 */
public class Restaurant {

    private String name;
    private String location;
    private String description;
    private String cuisineType;
    private List<FoodItem> menu;

    /**
     * Constructor for the Restaurant class.
     * 
     * @param name        The name of the restaurant.
     * @param location    The location of the restaurant.
     * @param description A description of the restaurant.
     * @param cuisineType The type of cuisine the restaurant offers.
     */
    public Restaurant(String name, String location, String description, String cuisineType) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.cuisineType = cuisineType;
        this.menu = new ArrayList<>();
    }

    /**
     * Gets the type of cuisine the restaurant offers.
     * 
     * @return The cuisine type as a String.
     */
    public String getCuisineType() {
        return cuisineType;
    }

    /**
     * Sets the type of cuisine the restaurant offers.
     * 
     * @param cuisineType The new cuisine type.
     */
    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    /**
     * Adds a FoodItem to the restaurant's menu.
     * 
     * @param foodItem The FoodItem to add.
     */
    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    /**
     * Removes a FoodItem from the restaurant's menu.
     * 
     * @param foodItem The FoodItem to remove.
     */
    public void removeFoodItem(FoodItem foodItem) {
        menu.remove(foodItem);
    }

    /**
     * Removes a FoodItem from the restaurant's menu by its index.
     * 
     * @param index The index of the FoodItem to remove.
     */
    public void removeFoodItem(int index) {
        if (index >= 0 && index < menu.size()) {
            menu.remove(index);
        }
    }

    /**
     * Finds a FoodItem by its name.
     * 
     * @param name The name of the FoodItem.
     * @return The FoodItem with the specified name, or null if not found.
     */
    public FoodItem findFoodItemByName(String name) {
        for (FoodItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Gets the number of FoodItems in the menu.
     * 
     * @return The number of FoodItems.
     */
    public int getNumberOfFoodItems() {
        return menu.size();
    }

    /**
     * Checks if a specific FoodItem is in the menu.
     * 
     * @param foodItem The FoodItem to check.
     * @return true if the FoodItem is in the menu, false otherwise.
     */
    public boolean hasFoodItem(FoodItem foodItem) {
        return menu.contains(foodItem);
    }

    /**
     * Clears all FoodItems from the menu.
     */
    public void clearAllFoodItems() {
        menu.clear();
    }

    /**
     * Gets the attraction type, which is "Restaurant" for this class.
     * 
     * @return The attraction type as a String.
     */
    public String getAttractionType() {
        return "Restaurant";
    }
}