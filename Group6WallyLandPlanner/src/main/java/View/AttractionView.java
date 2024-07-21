/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.AttractionController;
import Controller.PlannerController;
import Model.Attraction;
import Model.Planner;
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

public class AttractionView {
    private AttractionController attractionController;
    private Planner planner;
    private PlannerView plannerView;
    private PlannerController plannerController;
    private JFrame frame;
    private JList<Attraction> list;
    private DefaultListModel<Attraction> listModel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton clearButton;
    private JButton addButton;
    private JButton returnButton;

     public AttractionView(AttractionController attractionController, Planner planner, PlannerController plannerController, PlannerView plannerView) {
        this.attractionController = attractionController;
        this.planner = planner;
        this.plannerController = plannerController;
        this.plannerView = plannerView; // Initialize the PlannerView reference
    }

    // Method to create the window with a space for a list
    public void createWindow() {
        attractionController.loadAttractionsFromFile("attractions.txt");
        frame = new JFrame("Attractions");
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

        frame.setVisible(true);
        
        JPanel buttonPanel = new JPanel(new BorderLayout());
        addButton = new JButton("Reserve Attraction");
        addButton.addActionListener((ActionEvent e) -> addReservation());
        buttonPanel.add(addButton, BorderLayout.WEST);
        
        returnButton = new JButton("Back");
        returnButton.addActionListener(ActionEvent e) -> 
        
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    // Method to update the list with all attractions
    public void updateList() {
        listModel.clear();
        List<Attraction> attractions = attractionController.getAttractions();
        for (Attraction attraction : attractions) {
            listModel.addElement(attraction);
        }
    }

    // Method to perform search and update the list
    private void performSearch() {
        String searchTerm = searchField.getText().trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            updateList();
            return;
        }

        listModel.clear();
        List<Attraction> attractions = planner.getAttractions();
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
    private void addReservation(){
        Attraction selectedAttraction = list.getSelectedValue();
        if (selectedAttraction != null) {
            plannerController.addAttraction(selectedAttraction);
            System.out.println("Added reservation: " + selectedAttraction.getName());
            frame.dispose(); // Close the AttractionView window
            plannerView.updateList(); // Update the PlannerView list
            plannerView.showWindow(); // Reopen the PlannerView
        }
    }
}