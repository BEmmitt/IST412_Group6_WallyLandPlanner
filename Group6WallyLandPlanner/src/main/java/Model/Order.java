/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;

/**
 *
 * @author pault
 */
public class Order {
    
    private User user;
    private List<String> items;
    private double totalAmount;
    
    public User getUser() 
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user=user;
    }
    
    public void setItems(List<String> items)
    {
        this.items=items;
    }
    
    public double getTotalAmount()
    {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount=totalAmount;
    }
}
