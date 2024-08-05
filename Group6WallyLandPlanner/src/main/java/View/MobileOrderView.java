/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.FoodOrderController;
import Model.FoodItem;
import Model.FoodStand;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * FoodStandMenuView class displays the menu and selected items for a specific food stand.
 *
 * @version 1.0
 * @since 2024-08-05
 */
public class MobileOrderView {

    private JFrame frame;
    private JList<FoodItem> menuList;
    private DefaultListModel<FoodItem> menuListModel;
    private JList<FoodItem> selectedItemsList;
    private DefaultListModel<FoodItem> selectedItemsListModel;
    
    private JButton addFoodItemButton;
    private JButton removeFoodItemButton;
    private JButton confirmOrderButton;
    private JButton backButton;

    private FoodOrderView foodOrderView;
    private FoodOrderController foodOrderController;
    private FoodStand selectedFoodStand;
    private PlannerView plannerView;
    


    /**
     * Constructor for the FoodStandMenuView class.
     * 
     * @param foodOrderView
     * @param controller The FoodOrderController instance to handle actions.
     * @param foodStand The FoodStand for which the menu is displayed.
     */
    public MobileOrderView(FoodOrderView foodOrderView, FoodOrderController controller, FoodStand foodStand, PlannerView plannerView) {
        this.foodOrderView = foodOrderView;
        this.foodOrderController = controller;
        this.selectedFoodStand = foodStand;
        this.plannerView = plannerView;
    }

    /**
     * Sets up the main window and its components.
     */
    public void createWindow() {
        //foodOrderController.loadMenuForFoodStand(selectedFoodStand);
        frame = new JFrame("Food Stand Menu");
        frame.setSize(960, 720);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                backToFoodOrderView();
            }
        });
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(640, 480));

        menuListModel = new DefaultListModel<>();
        menuList = new JList<>(menuListModel);
        menuList.setCellRenderer(new AttractionCellRenderer());
        menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        updateMenuList();

        selectedItemsListModel = new DefaultListModel<>();
        selectedItemsList = new JList<>(selectedItemsListModel);
        selectedItemsList.setCellRenderer(new AttractionCellRenderer());
        selectedItemsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Panel for menu list
        JPanel menuPanel = new JPanel(new BorderLayout());
        JLabel menuLabel = new JLabel("MENU", SwingConstants.CENTER);
        menuLabel.setFont(new Font("Arial", Font.BOLD, 16));
        menuPanel.add(menuLabel, BorderLayout.NORTH);
        menuPanel.add(new JScrollPane(menuList), BorderLayout.CENTER);

        // Panel for selected items list
        JPanel orderPanel = new JPanel(new BorderLayout());
        JLabel orderLabel = new JLabel("Order", SwingConstants.CENTER);
        orderLabel.setFont(new Font("Arial", Font.BOLD, 16));
        orderPanel.add(orderLabel, BorderLayout.NORTH);
        orderPanel.add(new JScrollPane(selectedItemsList), BorderLayout.CENTER);

        // Panel to hold both menuPanel and orderPanel
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.add(menuPanel);
        mainPanel.add(orderPanel);

        // Add the mainPanel to the center of the frame
        frame.add(mainPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addFoodItemButton = new JButton("Add to Order");
        addFoodItemButton.addActionListener((ActionEvent e) -> addItemToOrder());
        controlPanel.add(addFoodItemButton);

        removeFoodItemButton = new JButton("Remove from Order");
        removeFoodItemButton.addActionListener((ActionEvent e) -> removeItemFromOrder());
        controlPanel.add(removeFoodItemButton);

        confirmOrderButton = new JButton("Confirm Order");
        confirmOrderButton.addActionListener((ActionEvent e) -> confirmOrder());
        controlPanel.add(confirmOrderButton);

        backButton = new JButton("Back");
        backButton.addActionListener((ActionEvent e) -> backToFoodOrderView());
        controlPanel.add(backButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

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
     * Updates the menu list with items from the selected food stand.
     */
    private void updateMenuList() {
       foodOrderController.loadMenuForFoodStand(selectedFoodStand);
       for(FoodItem foodItem: selectedFoodStand.getMenu()){
           menuListModel.addElement(foodItem);
       }
    }

    /**
     * Adds the selected menu item to the order list.
     */
    private void addItemToOrder() {
        FoodItem selectedItem = menuList.getSelectedValue();
        if (selectedItem != null) {
            selectedItemsListModel.addElement(selectedItem);
            foodOrderController.addItemToOrder(selectedItem);
        }
    }

    /**
     * Removes the selected item from the order list.
     */
    private void removeItemFromOrder() {
        FoodItem selectedItem = selectedItemsList.getSelectedValue();
        if (selectedItem != null) {
            selectedItemsListModel.removeElement(selectedItem);
            foodOrderController.removeItemFromOrder(selectedItem);
        }
    }

    /**
     * Confirms the order and sends it to the controller for processing.
     */
    private void confirmOrder() {      
        int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to Checkout?", "Order Complete Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION){
            LocalDateTime pickupTime = LocalDateTime.now().plusMinutes(20);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
            String formattedPickupTime = pickupTime.format(formatter);
            foodOrderController.getOrder().setPickupTime(pickupTime);
            JOptionPane.showMessageDialog(frame, "Order has been placed successfully!\n" +
                                                 "Your Order will be ready for pickup at: " + formattedPickupTime + "!\n" +
                                                "Total: $" + foodOrderController.getTotalAmount());

            plannerView.setOrder(foodOrderController.getOrder());
            backToPlannerView();
        }
    }

    public void backToFoodOrderView(){
        this.hideWindow();
        foodOrderView.showWindow();
    }
    
    public void backToPlannerView(){
        this.hideWindow();
        plannerView.showWindow();
    }
}
