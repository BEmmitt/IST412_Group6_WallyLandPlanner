/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.AttractionController;
import Controller.FoodOrderController;
import Controller.LoginController;
import Controller.PlannerController;
import Controller.RestaurantController;
import Model.Attraction;
import Model.FoodItem;
import Model.Order;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author bemmi
 */
public class PlannerView {

    LoginController loginController;
    PlannerController plannerController;
    private JFrame frame;
    private JList<Attraction> list;
    private DefaultListModel<Attraction> listModel;
    private JTextField searchField;
    private Order order;

    private JButton searchButton;
    private JButton clearButton;
    private JButton deleteButton;
    

    
     public void setLoginController(LoginController controller) {
        this.loginController = controller;
        order = null;
    }

     // Method to create the window with a space for a list
    public void createWindow(User user, LoginController controller) {
        setLoginController(controller);
        plannerController = new PlannerController(user);
        
        frame = new JFrame(user.getUsername() + "'s Planner");
        frame.setSize(960, 720);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                hideWindow();
                logout();
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
        
        
        // Panel for the reservation and logout buttons with FlowLayout to position them side by side
        JPanel mainButtonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JPanel bottomButtonPanel = new JPanel(new BorderLayout());
        
        JButton reservationButton = new JButton("Reserve an Attraction");
        reservationButton.addActionListener((ActionEvent e) -> {
            AttractionController attractionController = new AttractionController();
            AttractionView attractionView = new AttractionView(attractionController, plannerController.getPlanner(), plannerController, this);
            attractionView.createWindow();
            this.hideWindow();
        });        
        mainButtonPanel.add(reservationButton);
        
        JButton restaurantButton = new JButton("Reserve a Restaurant");
        restaurantButton.addActionListener((ActionEvent e) -> {           
            RestaurantController restaurantController = new RestaurantController();
            RestaurantView restaurantView = new RestaurantView(restaurantController, plannerController.getPlanner(), plannerController, this);
            restaurantView.createWindow();
            this.hideWindow();            
        });   
        mainButtonPanel.add(restaurantButton);
        
        JButton mobileOrderButton = new JButton("FoodStand Mobile Order");
        mobileOrderButton.setPreferredSize(new Dimension(200, 50));
        mobileOrderButton.addActionListener((ActionEvent e) -> {
            
            if (order != null){
                if(LocalDateTime.now().isAfter(order.getPickupTime())){
                    order = null;
                }else{
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
                    String formattedPickupTime = order.getPickupTime().format(formatter);
                    JOptionPane.showMessageDialog(frame, """
                                                      There is already an order.
                                                      Only one order can be active per account.
                                                      Sorry for any inconvienence.
                                                      You can reorder after""" + " " + formattedPickupTime);
                }
            }else{
                FoodOrderController foodOrderController = new FoodOrderController();
                FoodOrderView restaurantView = new FoodOrderView(foodOrderController, plannerController.getPlanner(), plannerController, this);
                restaurantView.createWindow();
                this.hideWindow();
            }
        }); 
        mainButtonPanel.add(mobileOrderButton);
        
        JButton checkOrderButton = new JButton("Check Order");
        checkOrderButton.setPreferredSize(new Dimension(200, 50));
        checkOrderButton.addActionListener((ActionEvent e) -> checkOrderClick());
        mainButtonPanel.add(checkOrderButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener((ActionEvent e) -> logout());
        bottomButtonPanel.add(logoutButton, BorderLayout.EAST);
        
        deleteButton = new JButton("Delete Reservation");
        deleteButton.addActionListener((ActionEvent e) -> deleteItem(list.getSelectedValue()));     
        bottomButtonPanel.add(deleteButton, BorderLayout.WEST);

        // Main panel to hold both button panels
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(mainButtonPanel, BorderLayout.NORTH);
        buttonPanel.add(bottomButtonPanel, BorderLayout.SOUTH);

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

     public void setOrder(Order order) {
        this.order = order;
    }
    // Method to add items to the list
    public void addItem(Attraction attraction) {
        listModel.addElement(attraction);
    }
    
    public void deleteItem(Attraction attraction) {
        int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this reservation?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION){
            listModel.removeElement(attraction);
            plannerController.removeAttraction(attraction);
        }
    }
    
    public void updateList() {
        listModel.clear();
        for (Attraction attraction : plannerController.getReservations()) {
            listModel.addElement(attraction);
        }
    }

    public void checkOrderClick() {
        
        if(order == null){
            JOptionPane.showMessageDialog(frame, "No orders to display.");
        }else {
            List<FoodItem> orderItems = order.getItems();
            StringBuilder orderDetails = new StringBuilder("Order Details:\n");
            double totalAmount = 0.0;

            for (FoodItem item : orderItems) {
                orderDetails.append(item.getName()).append(" - $").append(String.format("%.2f", item.getPrice())).append("\n");
                totalAmount += item.getPrice();
            }            
            if (order.getPickupTime() != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
                String formattedPickupTime = order.getPickupTime().format(formatter);
                orderDetails.append("\nPickup Time: ").append(formattedPickupTime);
            }

            JOptionPane.showMessageDialog(frame, orderDetails.toString(), "Current Order", JOptionPane.INFORMATION_MESSAGE);
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
            if (attraction.getName().toLowerCase().contains(searchTerm) || 
                attraction.getAttractionType().toLowerCase().contains(searchTerm) || 
                attraction.getDescription().toLowerCase().contains(searchTerm)) {
                listModel.addElement(attraction);
            }
        }
    }
    
    //Logout Method
    private void logout(){
        int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to Logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION){
            if (loginController != null) {
                loginController.logout();
            }
        }
    }
    
    // Method to clear the search field and update the list
    private void clearSearch() {
        searchField.setText("");
        updateList();
    }
}
