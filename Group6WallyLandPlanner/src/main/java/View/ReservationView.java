/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import Model.Show;
import Model.ShowReservation;



/**
 *
 * @author bemmi
 */

public class ReservationView {

    private JFrame frame;
    private JPanel panel;
    private JButton reserveShowButton;
    private JComboBox<String> showList;

    public ReservationView() {
        initializeDisplay();
        placeComponents();
    }

    public void initializeDisplay() {
        frame = new JFrame("Amusement Park Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        frame.add(panel);
    }

    public void placeComponents() {
        JLabel welcomeLabel = new JLabel("Welcome to the Amusement Park Reservation System!");
        panel.add(welcomeLabel);

        showList = new JComboBox<>(new String[]{"Show 1", "Show 2", "Show 3"});
        panel.add(showList);

        reserveShowButton = new JButton("Reserve Show");
        panel.add(reserveShowButton);

        reserveShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedShow = (String) showList.getSelectedItem();
                reserveShow(selectedShow);
            }
        });

        frame.setVisible(true);
    }

    public void reserveShow(String showName) {
        // Here you would interact with the Reservation model to create a reservation
        ShowReservation reservation = new ShowReservation();
        // Assuming default values for location, description, and showTime
        String location = "Default Location";
        String description = "Default Description";
        String showTime = "Default Time";
        reservation.setShow(new Show(showName, location, description, showTime));
        reservation.setReserveDate(new Date());
        // Set the user and other details as required
        // Save the reservation (pseudo-code)
        // reservationService.save(reservation);
        JOptionPane.showMessageDialog(frame, "Reserved: " + showName);
    }

    public static void main(String[] args) {
        new ReservationView();
    }
}