/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.LoginController;
import Controller.PlannerController;
import Model.Attraction;
import Model.User;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author bemmi
 */
public class PlannerView {
    LoginController loginController;
    PlannerController plannerControl = new PlannerController();
    private JFrame frame;
    private JList<Attraction> list;
    private DefaultListModel<Attraction> listModel;
    
     public void setLoginController(LoginController controller) {
        this.loginController = controller;
    }

     // Method to create the window with a space for a list
    public void createWindow(User user, LoginController controller) {
        setLoginController(controller);
        
        frame = new JFrame(user.getUsername() + "'s Planner");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        updateList();

        JScrollPane listScrollPane = new JScrollPane(list);
        frame.add(listScrollPane, BorderLayout.CENTER);
        
        JButton reservationButton = new JButton("Add a new Reservation");
        reservationButton.addActionListener((ActionEvent e) -> {
            ReservationView reservationView = new ReservationView();
            //reservationView.createWindow();
        });

        // Panel for the reservation button with FlowLayout to center the button
        JPanel reservationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        reservationPanel.add(reservationButton);
        frame.add(reservationPanel, BorderLayout.NORTH);
        
         // Logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener((ActionEvent e) -> {
            System.out.println("Logout button clicked"); // Debug statement
            if (loginController != null) {
                loginController.logout();
            } else {
                System.out.println("LoginController is null");
            }
        });

        // Panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(logoutButton, BorderLayout.EAST);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    // Method to display the window
    public void showWindow() {
        if (frame != null) {
            frame.setVisible(true);
        }
    }

    // Method to hide the window
    public void hideWindow() {
        if (frame != null) {
            frame.setVisible(false);
        }
    }

    // Method to add items to the list
    public void addItem(Attraction attraction) {
        listModel.addElement(attraction);
    }
    
    public void updateList() {
        listModel.clear();
        for (Attraction attraction : plannerControl.getReservations()) {
            listModel.addElement(attraction);
        }
    }

    // Method to clear the list
    public void clearList() {
        listModel.clear();
    }
    
}
