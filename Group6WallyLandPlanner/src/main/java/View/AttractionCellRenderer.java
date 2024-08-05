package View;

import Model.Attraction;
import Model.FoodItem;
import Model.Restaurant;
import Model.Ride;
import Model.Show;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class AttractionCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (c instanceof JLabel) {
            JLabel label = (JLabel) c;
            String labelText = "";

            if (value instanceof Attraction) {
                Attraction attraction = (Attraction) value;

                if (attraction instanceof Restaurant) {
                    Restaurant restaurant = (Restaurant) attraction;
                    labelText = String.format(
                        "<html><b style='font-size:14px;'>%s</b><br>%s<br>%s<br>Cuisine: %s<br>Reservation Time: %s</html>",
                        restaurant.getName(),
                        restaurant.getAttractionType(),
                        restaurant.getDescription(),
                        restaurant.getCuisineType(),
                        restaurant.getTimeSlot()
                    );
                } else if (attraction instanceof Show) {
                    Show show = (Show) attraction;
                    labelText = String.format(
                        "<html><b style='font-size:14px;'>%s</b><br>%s<br>%s<br>Show Time: %s</html>",
                        show.getName(),
                        show.getAttractionType(),
                        show.getDescription(),
                        show.getShowTime()
                    );
                } else if (attraction instanceof Ride) {
                    Ride ride = (Ride) attraction;
                    labelText = String.format(
                        "<html><b style='font-size:14px;'>%s</b><br>%s<br>%s<br>Thrill Level: %s</html>",
                        ride.getName(),
                        ride.getAttractionType(),
                        ride.getDescription(),
                        ride.getThrillLevel()
                    );
                } else {
                    labelText = String.format(
                        "<html><b style='font-size:14px;'>%s</b><br>%s<br>%s</html>",
                        attraction.getName(),
                        attraction.getAttractionType(),
                        attraction.getDescription()
                    );
                }
            } else if (value instanceof FoodItem) {
                FoodItem foodItem = (FoodItem) value;
                labelText = String.format(
                    "<html><b style='font-size:14px;'>%s</b><br>Price: $%.2f</html>",
                    foodItem.getName(),
                    foodItem.getPrice()
                );
            }

            label.setText(labelText);
            label.setFont(new Font("Arial", Font.PLAIN, 12));
            label.setBorder(new EmptyBorder(10, 10, 10, 10));
            if (isSelected) {
                label.setBackground(new Color(184, 207, 229));
                label.setOpaque(true);
            } else {
                label.setBackground(Color.WHITE);
                label.setOpaque(true);
            }
        }
        return c;
    }
}
