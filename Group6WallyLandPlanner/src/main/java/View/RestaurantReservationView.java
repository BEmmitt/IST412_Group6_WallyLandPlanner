/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.RestaurantReservationController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
 * @since 2024-07-30
 * @author pault
 */

public class RestaurantReservationView {

    private JFrame frame;
    private JButton cancelButton;
    private JButton confirmButton;
    private JButton addToItineraryButton;
    private JButton reservationStatusButton;
    private RestaurantReservationController reservationController;

    /**
     * Constructor for the RestaurantReservationView class.
     * Initializes the controller and sets up the window.
     *
     * @param controller The RestaurantReservationController instance to handle actions.
     */
    public RestaurantReservationView(RestaurantReservationController controller) {
        this.reservationController = controller;
        createWindow();
    }

    /**
     * Sets up the main window and its components.
     */
    private void createWindow() {
        frame = new JFrame("Restaurant Reservation System");
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

        // Create the panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        cancelButton = new JButton("Cancel");
        confirmButton = new JButton("Confirm");
        addToItineraryButton = new JButton("Add to Itinerary");
        reservationStatusButton = new JButton("Reservation Status");

        // Add action listeners to buttons
        cancelButton.addActionListener((ActionEvent e) -> cancelButtonClicked());
        confirmButton.addActionListener((ActionEvent e) -> confirmButtonClicked());
        addToItineraryButton.addActionListener((ActionEvent e) -> addItineraryClicked());
        reservationStatusButton.addActionListener((ActionEvent e) -> reservationStatusClicked());

        buttonPanel.add(cancelButton);
        buttonPanel.add(confirmButton);
        buttonPanel.add(addToItineraryButton);
        buttonPanel.add(reservationStatusButton);

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
     * Action to be performed when the "Cancel" button is clicked.
     */
    private void cancelButtonClicked() {
        int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to cancel the reservation?", "Confirm Cancel", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            reservationController.cancelReservation();
            JOptionPane.showMessageDialog(frame, "Reservation has been canceled.");
        }
    }

    /**
     * Action to be performed when the "Confirm" button is clicked.
     */
    private void confirmButtonClicked() {
        reservationController.confirmReservation();
        JOptionPane.showMessageDialog(frame, "Reservation has been confirmed.");
    }

    /**
     * Action to be performed when the "Add to Itinerary" button is clicked.
     */
    private void addItineraryClicked() {
        reservationController.addToItinerary();
        JOptionPane.showMessageDialog(frame, "Reservation has been added to the itinerary.");
    }

    /**
     * Action to be performed when the "Reservation Status" button is clicked.
     */
    private void reservationStatusClicked() {
        String status = reservationController.getReservationStatus();
        JOptionPane.showMessageDialog(frame, "Reservation Status: " + status);
    }

    /**
     * Action to be performed when the window is closed.
     */
    private void exitApplication() {
        int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            hideWindow();
            System.exit(0);
        }
    }
}
