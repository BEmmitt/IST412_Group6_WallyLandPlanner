/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.FoodItem;
import Model.FoodStand;
import Model.Order;
import Model.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @version 1.0
 * @since 2024-07-28
 * @author pault
 */

public class FoodOrderController {
    private List<FoodStand> foodStands;
    private Order order;

    public FoodOrderController() {
        this.foodStands = new ArrayList<>();
        this.order = new Order();
    }

     public void loadFoodStandsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming each line is in the format: name,location,description,specialty
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    String location = parts[1].trim();
                    String description = parts[2].trim();
                    String specialty = parts[3].trim();

                    FoodStand foodStand = new FoodStand(name, location, description, specialty);
                    foodStands.add(foodStand);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadMenuForFoodStand(FoodStand foodStand) {
        String filename = foodStand.getName() + " Menu.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming each line is in the format: itemName,description,price
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String itemName = parts[0].trim();
                    double itemPrice = Double.parseDouble(parts[1].trim());

                    FoodItem foodItem = new FoodItem(itemName, itemPrice);
                    foodStand.addFoodItem(foodItem);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
     
    // Adds a FoodStand to the list of food stands
    public void addFoodStand(FoodStand foodStand) {
        if (!foodStands.contains(foodStand)){
            foodStands.add(foodStand);
        }
    }

    // Adds an item to the order
    public void addItemToOrder(FoodItem foodItem) {
        order.addItem(foodItem);
    }

    // Removes an item from the order by the food item
    public void removeItemFromOrder(FoodItem foodItem) {
        List<FoodItem> items = order.getItems();
        if (items != null && items.contains(foodItem)) {
            items.remove(foodItem);
            order.setItems(items);
        }
    }


    // Gets the number of items in the order
    public int getNumberOfFoodItems() {
        List<FoodItem> items = order.getItems();
        return (items != null) ? items.size() : 0;
    }

    // Clears all items from the order
    public void clearAllFoodItems() {
        order.setItems(new ArrayList<>());
    }


    // Gets the total amount of the order
    public String getTotalAmount() {
        return order.getTotalAmount();
    }

    // Sets the total amount for the order
    public void setTotalAmount(double totalAmount) {
        order.setTotalAmount(totalAmount);
    }

    // Gets the list of food stands
    public List<FoodStand> getFoodStands() {
        return foodStands;
    }

    // Gets the order
    public Order getOrder() {
        return order;
    }
}