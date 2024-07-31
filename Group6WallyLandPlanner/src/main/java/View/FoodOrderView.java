/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.FoodOrderController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Represents the user interface for the food ordering system.
 *
 * @version 1.0
 * @since 2024-07-28
 * @author pault
 */

public class FoodOrderView {

    private JFrame frame;
    private JButton addFoodItemButton;
    private JButton removeFoodItemButton;
    private JButton cancelOrderButton;
    private FoodOrderController foodOrderController;

    /**
     * Constructor for the FoodOrderView class.
     * Initializes the controller and sets up the window.
     * 
     * @param controller The FoodOrderController instance to handle actions.
     */
    public FoodOrderView(FoodOrderController controller) {
        this.foodOrderController = controller;
        createWindow();
    }

    /**
     * Sets up the main window and its components.
     */
    private void createWindow() {
        frame = new JFrame("Food Order System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApplication();
            }
        });
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(400, 300));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        addFoodItemButton = new JButton("Add Food Item");
        removeFoodItemButton = new JButton("Remove Food Item");
        cancelOrderButton = new JButton("Cancel Order");

        addFoodItemButton.addActionListener((ActionEvent e) -> addFoodItemClicked());
        removeFoodItemButton.addActionListener((ActionEvent e) -> removeFoodItemClicked());
        cancelOrderButton.addActionListener((ActionEvent e) -> cancelOrderClicked());

        buttonPanel.add(addFoodItemButton);
        buttonPanel.add(removeFoodItemButton);
        buttonPanel.add(cancelOrderButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * Makes the window visible.
     */
    public void showWindow() {
        if (frame != null) {
            frame.setVisible(true);
        }
    }

    /**
     * Hides the window.
     */
    public void hideWindow() {
        if (frame != null) {
            frame.setVisible(false);
        }
    }

    /**
     * Displays the menu or any relevant information.
     * (Placeholder for future implementation)
     */
    public void displayMenu() {
        JOptionPane.showMessageDialog(frame, "Display menu here.");
    }

    private void addFoodItemClicked() {
        String foodItemName = JOptionPane.showInputDialog(frame, "Enter the name of the food item to add:");
        if (foodItemName != null && !foodItemName.isEmpty()) {
            foodOrderController.addItemToOrder(foodItemName);
            JOptionPane.showMessageDialog(frame, "Food item added to order: " + foodItemName);
        }
    }

    private void removeFoodItemClicked() {
        String foodItemName = JOptionPane.showInputDialog(frame, "Enter the name of the food item to remove:");
        if (foodItemName != null && !foodItemName.isEmpty()) {
            foodOrderController.removeItemFromOrder(foodItemName);
            JOptionPane.showMessageDialog(frame, "Food item removed from order: " + foodItemName);
        }
    }

    private void cancelOrderClicked() {
        int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to cancel the order?", "Confirm Cancel", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            foodOrderController.clearAllFoodItems();
            JOptionPane.showMessageDialog(frame, "Order has been canceled.");
        }
    }

    private void exitApplication() {
        int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            hideWindow();
            System.exit(0);
        }
    }
}