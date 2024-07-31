/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a food stand with a name.
 * 
 * String holds name of food stand.
 * 
 * @version 1.0
 * @since 2024-31-07
 * @author Jordan
 * @author: bemmi
 */
public class FoodStand {

    private String name;
    private String location;
    private String description;
    private String specialty;
    private List<FoodItem> menu;

    /**
     * Constructor for the FoodStand class.
     * 
     * @param name        The name of the food stand.
     * @param location    The location of the food stand.
     * @param description A description of the food stand.
     * @param specialty   The specialty of the food stand.
     */
    public FoodStand(String name, String location, String description, String specialty) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.specialty = specialty;
        this.menu = new ArrayList<>();
    }

    /**
     * Gets the specialty of the food stand.
     * 
     * @return The specialty as a String.
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Sets the specialty of the food stand.
     * 
     * @param specialty The new specialty.
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * Adds a FoodItem to the food stand's menu.
     * 
     * @param foodItem The FoodItem to add.
     */
    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    /**
     * Removes a FoodItem from the food stand's menu.
     * 
     * @param foodItem The FoodItem to remove.
     */
    public void removeFoodItem(FoodItem foodItem) {
        menu.remove(foodItem);
    }

    /**
     * Removes a FoodItem from the food stand's menu by its index.
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
     * Gets the attraction type, which is "Food Stand" for this class.
     * 
     * @return The attraction type as a String.
     */
    public String getAttractionType() {
        return "Food Stand";
    }
}
