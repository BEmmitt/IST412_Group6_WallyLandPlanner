/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.PlannerController;
import java.awt.BorderLayout;
import static java.util.Collections.list;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author bemmi
 */
public class PlannerView {
    
    PlannerController plannerControl = new PlannerController();
    private JFrame frame;
    private JList<String> list;
    private DefaultListModel<String> listModel;

     // Method to create the window with a space for a list
    public void createWindow() {
        frame = new JFrame("List Display");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        JScrollPane listScrollPane = new JScrollPane(list);

        frame.add(listScrollPane, BorderLayout.CENTER);
    }

    // Method to display the window
    public void showWindow() {
        if (frame != null) {
            frame.setVisible(true);
        }
    }

    // Method to hide the window
    public void hideWindow() {
        if (frame != null) {
            frame.setVisible(false);
        }
    }

    // Method to add items to the list
    public void addItem(String item) {
        listModel.addElement(item);
    }

    // Method to clear the list
    public void clearList() {
        listModel.clear();
    }
    
}
