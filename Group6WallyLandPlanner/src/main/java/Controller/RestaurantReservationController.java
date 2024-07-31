/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Order;
import Model.User;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the actions related to restaurant reservations.
 * 
 * @version 1.0
 * @since 2024-07-30
 * @author pault
 */
public class RestaurantReservationController {

    private Order order;
    private List<String> reservationHistory; // To track reservation history

    /**
     * Constructor for the RestaurantReservationController class.
     */
    public RestaurantReservationController() {
        this.order = new Order();
        this.reservationHistory = new ArrayList<>();
    }

    /**
     * Confirms the reservation by saving it to history.
     */
    public void confirmReservation() {
        if (order.getUser() == null || order.getItems() == null || order.getItems().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cannot confirm reservation. Please make sure all details are filled.");
            return;
        }

        // Simulate saving the reservation
        reservationHistory.add("Reservation confirmed for " + order.getUser().getUsername() + " with items: " + order.getItems());
    }

    /**
     * Cancels the current reservation.
     */
    public void cancelReservation() {
        if (order.getUser() == null) {
            JOptionPane.showMessageDialog(null, "No reservation to cancel.");
            return;
        }

        // Simulate cancellation
        reservationHistory.add("Reservation canceled for " + order.getUser().getUsername());
        order = new Order(); // Clear current order
    }

    /**
     * Adds the current reservation to the itinerary.
     */
    public void addToItinerary() {
        if (order.getUser() == null || order.getItems() == null || order.getItems().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cannot add to itinerary. Reservation details are incomplete.");
            return;
        }

        // Simulate adding to itinerary
        JOptionPane.showMessageDialog(null, "Reservation added to itinerary for " + order.getUser().getUsername() + ".");
    }

    /**
     * Gets the reservation status.
     * 
     * @return A string describing the reservation status.
     */
    public String getReservationStatus() {
        if (order.getUser() == null) {
            return "No reservation has been made.";
        }

        return "Reservation for " + order.getUser().getUsername() + " with items: " + order.getItems() + ". Total amount: $" + order.getTotalAmount();
    }

    /**
     * Sets the user for the current reservation.
     * 
     * @param user The user making the reservation.
     */
    public void setUserForOrder(User user) {
        order.setUser(user);
    }

    /**
     * Sets the items for the current reservation.
     * 
     * @param items A list of items for the reservation.
     */
    public void setItemsForOrder(List<String> items) {
        order.setItems(items);
    }

    /**
     * Sets the total amount for the current reservation.
     * 
     * @param totalAmount The total amount of the reservation.
     */
    public void setTotalAmount(double totalAmount) {
        order.setTotalAmount(totalAmount);
    }
}