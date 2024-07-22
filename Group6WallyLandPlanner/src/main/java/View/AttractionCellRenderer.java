/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Attraction;
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

        if (c instanceof JLabel && value instanceof Attraction) {
            Attraction attraction = (Attraction) value;
            JLabel label = (JLabel) c;

            String labelText;
            if (attraction instanceof Show) {
                Show show = (Show) attraction;
                labelText = String.format(
                    "<html><b style='font-size:14px;'>%s</b><br>%s<br>%s<br>%s</html>",
                    show.getName(),
                    show.getAttractionType(),
                    show.getDescription(),
                    "Show Time: " + show.getShowTime()
                );
            } else if (attraction instanceof Ride) {
                Ride ride = (Ride) attraction;
                labelText = String.format(
                    "<html><b style='font-size:14px;'>%s</b><br>%s<br>%s<br>%s</html>",
                    ride.getName(),
                    ride.getAttractionType(),
                    ride.getDescription(),
                    "Thrill Level: " + ride.getThrillLevel()
                );
            } else {
                labelText = String.format(
                    "<html><b style='font-size:14px;'>%s</b><br>%s<br>%s<br>%s</html>",
                    attraction.getName(),
                    attraction.getAttractionType(),
                    attraction.getDescription(),
                    ""
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
