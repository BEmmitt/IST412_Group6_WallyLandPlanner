/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;

/**
 *
 * @author Paul
 */
public class Attraction {
    
    private String name;
    private int capacity;
    private Date timeSlot;
    
    public String getName;
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public int getCapacity()
    {
        return capacity;
    }
    
    public void setCapacity(int Capacity)
    {
        this.capacity=capacity;
    }
    
    public Date getTimeSlot()
    {
        return timeSlot;
    }
    
    public void setTimeSlot(Date timeSlot)
    {
        this.timeSlot=timeSlot;
    }
}
