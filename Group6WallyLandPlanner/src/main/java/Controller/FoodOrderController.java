/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.FoodStand;
import Model.Order;
import Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

    // Adds a FoodStand to the list of food stands
    public void addFoodStand(FoodStand foodStand) {
        foodStands.add(foodStand);
    }

    // Adds an item to the order
    public void addItemToOrder(String foodItem) {
        List<String> items = order.getItems();
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(foodItem);
        order.setItems(items);
    }

    // Removes an item from the order by the food item
    public void removeItemFromOrder(String foodItem) {
        List<String> items = order.getItems();
        if (items != null && items.contains(foodItem)) {
            items.remove(foodItem);
            order.setItems(items);
        }
    }

    // Removes an item from the order by index
    public void removeItemFromOrder(int index) {
        List<String> items = order.getItems();
        if (items != null && index >= 0 && index < items.size()) {
            items.remove(index);
            order.setItems(items);
        }
    }

    // Gets the number of items in the order
    public int getNumberOfFoodItems() {
        List<String> items = order.getItems();
        return (items != null) ? items.size() : 0;
    }

    // Clears all items from the order
    public void clearAllFoodItems() {
        order.setItems(new ArrayList<>());
    }

    // Sets the user for the order
    public void setUserForOrder(User user) {
        order.setUser(user);
    }

    // Gets the total amount of the order
    public double getTotalAmount() {
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