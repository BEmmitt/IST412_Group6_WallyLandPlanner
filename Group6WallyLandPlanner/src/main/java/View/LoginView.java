/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author bemmi
 */
public class LoginView {
    
    LoginController loginControl;
    private JFrame frame;
    private JTextField userText;
    private JTextField passwordText;
    private JButton loginButton;
    private JLabel messageLabel;
    
    public void setLoginController(LoginController controller) {
        this.loginControl = controller;
    }
    
    public void createWindow(LoginController controller)
    {
        frame = new JFrame("Login");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 25);
        frame.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(150, 50, 150, 25);
        frame.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 80, 100, 25);
        frame.add(passwordLabel);

        passwordText = new JTextField(20);
        passwordText.setBounds(150, 80, 150, 25);
        frame.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 110, 80, 25);
        frame.add(loginButton);
        
        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 140, 250, 25);
        frame.add(messageLabel);
        
        loginButton.addActionListener((ActionEvent e) -> {
            if (loginControl != null) {
                loginControl.login();
            }
        });
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

    // Getter for the username
    public String getUsername() {
        return userText.getText();
    }

    // Getter for the password
    public String getPassword() {
        return passwordText.getText();
    }

    // Method to set the message label text
    public void setMessage(String message) {
        if (messageLabel != null) {
            messageLabel.setText(message);
        }
    }
}