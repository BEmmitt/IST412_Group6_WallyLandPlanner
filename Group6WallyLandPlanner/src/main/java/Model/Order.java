/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    
    LocalDateTime pickupTime;
    private List<FoodItem> items = new ArrayList();
    private double totalAmount;
    
    
    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }
    /**
     * sets the list of items available to order.
     * 
     * 
     * @return list of items in order.
    */
    
    public List<FoodItem> getItems() {
        return items;
    }
    
    public void setItems(List<FoodItem> items)
    {
        this.items=items;
    }
    
    public void addItem(FoodItem item){
        items.add(item);
    }
    
    /**
 * Gets the total amount price.
 * 
 * @return the total amount price.
 */
    
    public String getTotalAmount()
    {
        for(FoodItem item: items){
            totalAmount += item.getPrice();
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(totalAmount);
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
