/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;

/**
 * Holds the information for the order feature.
 * 
 * @version 1.0
 * @since 2024-06-09 
 * @author pault
 * 
 */
public class Order {
    
    private User user;
    private List<String> items;
    private double totalAmount;
    
    
    /**
 * Gets the user who made the order.
 * 
 * @return the user who made the reservation.
 */
    public User getUser() 
    {
        return user;
    }
    
    /**
 * Sets the user who made the order.
 * 
 * @param user the user to set for the order.
 */
    
    public void setUser(User user)
    {
        this.user=user;
    }
    
    /**
 * sets the list of items available to order.
 * 
 * @param items the list of items available.
 */
    
    public List<String> getItems() {
    return items;
}
    
    public void setItems(List<String> items)
    {
        this.items=items;
    }
    
    /**
 * Gets the total amount price.
 * 
 * @return the total amount price.
 */
    
    public double getTotalAmount()
    {
        return totalAmount;
    }
    
    /**
 * sets the total amount price.
 * 
 * @param totalAmount the total amount price.
 */ 
    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount=totalAmount;
    }
}
