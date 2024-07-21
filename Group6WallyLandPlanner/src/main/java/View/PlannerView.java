/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.AttractionController;
import Controller.LoginController;
import Controller.PlannerController;
import Model.Attraction;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author bemmi
 */
public class PlannerView {
    LoginController loginController;
    PlannerController plannerController = new PlannerController();
    private JFrame frame;
    private JList<Attraction> list;
    private DefaultListModel<Attraction> listModel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton clearButton;
    
     public void setLoginController(LoginController controller) {
        this.loginController = controller;
    }

     // Method to create the window with a space for a list
    public void createWindow(User user, LoginController controller) {
        setLoginController(controller);
        
        frame = new JFrame(user.getUsername() + "'s Planner");
        frame.setSize(960, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(640, 480));

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        updateList();

        JScrollPane listScrollPane = new JScrollPane(list);
        frame.add(listScrollPane, BorderLayout.CENTER);
        
        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        clearButton = new JButton("Clear");
        
        searchButton.addActionListener((ActionEvent e) -> performSearch());
        clearButton.addActionListener((ActionEvent e) -> clearSearch());

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(clearButton);
        frame.add(searchPanel, BorderLayout.NORTH);
        
        JButton reservationButton = new JButton("Add a new Reservation");
        reservationButton.addActionListener((ActionEvent e) -> {
            AttractionController attractionController = new AttractionController();
            AttractionView attractionView = new AttractionView(attractionController, plannerController.getPlanner());
            attractionView.createWindow();
            this.hideWindow();
        });
        // Panel for the reservation and logout buttons with FlowLayout to position them side by side
        JPanel buttonPanel = new JPanel(new BorderLayout());
        
//        reservationButton = new JButton("Add a new Reservation");
//        reservationButton.addActionListener((ActionEvent e) -> {
//            //AttractionView reservationView = new AttractionView();
//            // reservationView.createWindow();
//        });
        buttonPanel.add(reservationButton, BorderLayout.WEST);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener((ActionEvent e) -> {
            if (loginController != null) {
                loginController.logout();
            }
        });
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
        for (Attraction attraction : plannerController.getReservations()) {
            listModel.addElement(attraction);
        }
    }

    // Method to clear the list
    public void clearList() {
        listModel.clear();
    }
    
    // Method to perform search and update the list
    private void performSearch() {
        String searchTerm = searchField.getText().trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            updateList();
            return;
        }

        listModel.clear();
        List<Attraction> attractions = plannerController.getReservations();
        for (Attraction attraction : attractions) {
            if (attraction.getName().toLowerCase().contains(searchTerm)) {
                listModel.addElement(attraction);
            }
        }
    }
    
    // Method to clear the search field and update the list
    private void clearSearch() {
        searchField.setText("");
        updateList();
    }
}
