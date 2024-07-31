package Model;

/**
 * Represents a food item with a name and price.
 *
 * @author Jordan
 * @since 2024-07-31
 */
public class FoodItem {

    private String name;
    private double price;

    /**
     * Constructor for the FoodItem class.
     * 
     * @param name  The name of the food item.
     * @param price The price of the food item.
     */
    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the food item.
     * 
     * @return The name of the food item.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the food item.
     * 
     * @param name The new name of the food item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the food item.
     * 
     * @return The price of the food item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the food item.
     * 
     * @param price The new price of the food item.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
