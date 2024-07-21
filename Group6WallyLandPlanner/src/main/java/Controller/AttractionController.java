/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Attraction;
import Model.Planner;
import Model.Ride;
import Model.Show;
import View.AttractionView;
import View.PlannerView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pault
 */


public class AttractionController {

    
    private Planner planner;
    private List<Attraction> attractionList;
    private PlannerView plannerView;
    
    public AttractionController() {
        this.attractionList = new ArrayList<>();
                
//   public AttractionController(AttractionView view, Planner planner) {
//        this.view = view;
//        this.planner = planner;
//        loadAttractionsFromFile("attractions.txt");
//    }
                
                // Method to load attractions from a file
                
    }

//   public AttractionController(AttractionView view, Planner planner) {
//        this.view = view;
//        this.planner = planner;
//        loadAttractionsFromFile("attractions.txt");
//    }

    // Method to load attractions from a file
    public void loadAttractionsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming each line is in the format: type,name,location,description,additionalInfo
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String type = parts[0].trim();
                    String name = parts[1].trim();
                    String location = parts[2].trim();
                    String description = parts[3].trim();
                    String additionalInfo = parts[4].trim();

                    Attraction attraction = null;
                    if (type.equalsIgnoreCase("Ride")) {
                        attraction = new Ride(name, location, description, additionalInfo);
                    } else if (type.equalsIgnoreCase("Show")) {
                        attraction = new Show(name, location, description, additionalInfo);
                    }

                    if (attraction != null) {
                        addAttraction(attraction);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adds an attraction to the planner
    public void addAttraction(Attraction attraction) {
        if (!attractionList.contains(attraction)) {
            attractionList.add(attraction);
           // updateAttractionView();
        }
    }

    // Updates the view with the latest list of attractions
//    public void updateAttractionView() {
//        view.updateList();
//    }
    
    public List<Attraction> getAttractions() {
        return attractionList;
    }
    
    
}