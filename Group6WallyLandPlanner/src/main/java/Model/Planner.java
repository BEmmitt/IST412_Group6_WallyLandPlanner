/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Controller.AttractionAdapter;
import Controller.AttractionNotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds the information for the itinerary.
 * 
 * @version 1.0
 * @since 2024-06-09
 * @author pault
 * 
 */
public class Planner implements Serializable{
    
    private User user;
    private List<Attraction> reservedAttractions;
    private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(Attraction.class, new AttractionAdapter(new Gson()))
        .setPrettyPrinting()
        .create();

    
    public Planner(User user) {
        this.reservedAttractions = new ArrayList<>();
        this.user = user;
    }
    
 /**
 * Gets the user who made the itinerary.
 * 
 * @return the user.
 */
    
    public User getUser()
    {
        return user;
    }
    
       /**
 * Sets the user who made the itinerary.
 * 
 * @param user the user to set for the itinerary.
 */
    
    
    public void setUser(User user)
    {
        this.user=user;
    }
    
           /**
 * Gets the user's reservations.
 * 
 * @return the user's reservations.
 */
    
    public List<Attraction> getAttractions()
    {
        return reservedAttractions;
    }
    
        /**
 * sets the list of the user's reservations in the itinerary.
 * 
 * @param reservedAttractions the reservations in the user's itinerary.
 */
    
    public void setAttractions(List<Attraction> reservedAttractions)
    {
        this.reservedAttractions=reservedAttractions;
    }
    
    public Attraction findAttraction(String name) throws AttractionNotFoundException {
        for (Attraction attraction : reservedAttractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        throw new AttractionNotFoundException("Attraction not found with name: " + name);
    }
    
    public int getNumberOfAttractions(){
        return reservedAttractions.size();
    }
    
    public boolean hasAttraction(Attraction attraction){
        return reservedAttractions.contains(attraction);
    }
    
    public static Planner loadPlanner(String username, User user) {
        try (Reader reader = new FileReader(getFilePath(username))) {
            Planner planner = gson.fromJson(reader, Planner.class);
            if (planner == null) {
                planner = new Planner(user);
            }
            if (planner.getUser() == null) {
                planner.setUser(user);
            }
            System.out.println("Planner successfully loaded for user: " + username);
            return planner;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load planner for user: " + username);
            return new Planner(user);
        } catch (JsonSyntaxException | JsonIOException e) {
            e.printStackTrace();
            System.out.println("Failed to parse planner JSON for user: " + username);
            return new Planner(user);
        }
    }

    public void savePlanner(String username) {
        try (Writer writer = new FileWriter(getFilePath(username))) {
            gson.toJson(this, writer);
            System.out.println("Planner successfully saved for user: " + username);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save planner for user: " + username);
        }
    }

    private static String getFilePath(String username) {
        return "planner_" + username + ".json";
    }
}
