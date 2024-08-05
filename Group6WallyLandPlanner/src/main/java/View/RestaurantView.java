/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.PlannerController;
import Controller.RestaurantController;
import Model.Planner;
import Model.Restaurant;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @version 1.0
 * @since 2024-07-30
 * @author pault
 */

public class RestaurantView {

    private RestaurantController restaurantController;
    private Planner planner;
    private PlannerView plannerView;
    private PlannerController plannerController;
    private JFrame frame;
    private JList<Restaurant> list;
    private DefaultListModel<Restaurant> listModel;
    
    private JTextField searchField;
    private JButton searchButton;
    private JButton clearButton;

    private JButton backButton;
    private JButton addPlannerButton;

    /**
     * Constructor for the RestaurantReservationView class.
     * Initializes the controller and sets up the window.
     *
     * @param controller The RestaurantReservationController instance to handle actions.
     * @param planner
     * @param plannerController
     * @param plannerView
     */
    public RestaurantView(RestaurantController controller, Planner planner, PlannerController plannerController, PlannerView plannerView) {
        this.restaurantController = controller;
        this.planner = planner;
        this.plannerController = plannerController;
        this.plannerView = plannerView;
    }

    /**
     * Sets up the main window and its components.
     */
    public void createWindow() {
        restaurantController.loadRestaurantsFromFile("restaurants.txt");
        frame = new JFrame("Restaurant Reservation System");
        frame.setSize(960, 720);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                backToPlannerView();
            }
        });
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(640, 480));

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setCellRenderer(new AttractionCellRenderer());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        
        frame.setVisible(true);
        
        // Create the panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        backButton = new JButton("Back");
        backButton.addActionListener((ActionEvent e) -> backToPlannerView());
        buttonPanel.add(backButton, BorderLayout.EAST);

        addPlannerButton = new JButton("Add to Planner");
        addPlannerButton.addActionListener((ActionEvent e) -> addPlannerClicked());
        buttonPanel.add(addPlannerButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
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
    // Method to update the list with all attractions
    public void updateList() {
        listModel.clear();
        List<Restaurant> restaurants = restaurantController.getAvailableRestaurants();
        for (Restaurant restaurant : restaurants) {
            listModel.addElement(restaurant);
        }
    }    

    /**
     * Action to be performed when the "Add to Itinerary" button is clicked.
     */
    private void addPlannerClicked() {
        Restaurant selectedRestaurant = list.getSelectedValue();
        if (selectedRestaurant != null) {
            plannerController.addAttraction(selectedRestaurant);
            System.out.println("Added reservation: " + selectedRestaurant.getName());
            frame.dispose(); // Close the AttractionView window
            plannerView.updateList(); // Update the PlannerView list
            plannerView.showWindow(); // Reopen the PlannerView
        }
        JOptionPane.showMessageDialog(frame, "Restaurant reservation has been added to the planner.");
    }
    // Method to perform search and update the list
    private void performSearch() {
        String searchTerm = searchField.getText().trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            updateList();
            return;
        }

        listModel.clear();
        List<Restaurant> restaurants = restaurantController.getAvailableRestaurants();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().toLowerCase().contains(searchTerm) || 
                restaurant.getAttractionType().toLowerCase().contains(searchTerm) || 
                restaurant.getDescription().toLowerCase().contains(searchTerm)) {
                listModel.addElement(restaurant);
            }
        }
    }

    // Method to clear the search field and update the list
    private void clearSearch() {
        searchField.setText("");
        updateList();
    }
       
    public void backToPlannerView(){
        this.hideWindow();
        plannerView.showWindow();
    }
}
