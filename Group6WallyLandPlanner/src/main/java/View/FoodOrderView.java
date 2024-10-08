/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.FoodOrderController;
import Controller.PlannerController;
import Model.FoodStand;
import Model.Planner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the user interface for the food ordering system.
 *
 * @version 1.0
 * @since 2024-07-28
 * @author pault
 */

public class FoodOrderView {

    private JFrame frame;
    private JList<FoodStand> list;
    private DefaultListModel<FoodStand> listModel;
    
    private JButton addFoodItemButton;
    private JButton removeFoodItemButton;
    private JButton cancelOrderButton;
    private FoodOrderController foodOrderController;
    private Planner planner;
    private PlannerView plannerView;
    private PlannerController plannerController;
    private JTextField searchField;
    private JButton searchButton;
    private JButton clearButton;

    private JButton backButton;
    private JButton placeOrderButton;
    

    /**
     * Constructor for the FoodOrderView class.
     * Initializes the controller and sets up the window.
     * 
     * @param controller The FoodOrderController instance to handle actions.
     * @param planner
     * @param plannerController
     * @param plannerView
     */
    public FoodOrderView(FoodOrderController controller, Planner planner, PlannerController plannerController, PlannerView plannerView) {
        this.foodOrderController = controller;
        this.planner = planner;
        this.plannerController = plannerController;
        this.plannerView = plannerView;
    }

    /**
     * Sets up the main window and its components.
     */
    public void createWindow() {
        foodOrderController.loadFoodStandsFromFile("foodstands.txt");
        frame = new JFrame("Food Order System");
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
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButton = new JButton("Back");
        backButton.addActionListener((ActionEvent e) -> backToPlannerView());
        buttonPanel.add(backButton, BorderLayout.EAST);

        placeOrderButton = new JButton("Place Mobile Order");
        placeOrderButton.addActionListener((ActionEvent e) -> placeOrderClick());
        buttonPanel.add(placeOrderButton, BorderLayout.CENTER);
        
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

    public void updateList() {
        listModel.clear();
        List<FoodStand> foodStands = foodOrderController.getFoodStands();
        for (FoodStand foodStand : foodStands) {
            listModel.addElement(foodStand);
        }
    } 
    
    private void placeOrderClick() {        
        MobileOrderView foodOrderView = new MobileOrderView(this,foodOrderController, list.getSelectedValue(), plannerView);
        foodOrderView.createWindow();
        this.hideWindow();
    }
    
    // Method to perform search and update the list
    private void performSearch() {
        String searchTerm = searchField.getText().trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            updateList();
            return;
        }

        listModel.clear();
        List<FoodStand> foodStands = foodOrderController.getFoodStands();
        for (FoodStand foodStand : foodStands) {
            if (foodStand.getName().toLowerCase().contains(searchTerm) || 
                foodStand.getAttractionType().toLowerCase().contains(searchTerm) || 
                foodStand.getDescription().toLowerCase().contains(searchTerm)) {
                listModel.addElement(foodStand);
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