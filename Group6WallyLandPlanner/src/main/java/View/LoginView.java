/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.LoginController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class handles all the functionality for creating and displaying the
 * LoginView window. It also handles user input.
 * 
 * @author bemmi
 */
public class LoginView {
    
    LoginController loginControl;
    private JFrame frame;
    private JTextField userText;
    private JTextField passwordText;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel messageLabel;
    
    public void setLoginController(LoginController controller) {
        this.loginControl = controller;
    }
    /*
     *   Method to create the Login Window
    */
    public void createWindow(LoginController controller)
    {
        frame = new JFrame("Login");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        // Banner message
        JLabel bannerLabel = new JLabel("Welcome to the WallyLand Planner Application!");
        bannerLabel.setBounds(50, 10, 540, 30);
        bannerLabel.setFont(new Font("Serif", Font.BOLD, 20)); // Set larger font
        frame.add(bannerLabel);
        
        // Instructions message
        JLabel instructionsLabel = new JLabel("Please enter your username and password to log in or register.");
        instructionsLabel.setBounds(50, 50, 540, 25);
        frame.add(instructionsLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 90, 100, 25);
        frame.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(150, 90, 150, 25);
        frame.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 120, 100, 25);
        frame.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 120, 150, 25);
        frame.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 80, 25);
        frame.add(loginButton);
        
        // Register button
        registerButton = new JButton("Register");
        registerButton.setBounds(240, 150, 100, 25);
        frame.add(registerButton);
        
        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 180, 250, 25);
        frame.add(messageLabel);
        
        loginButton.addActionListener((ActionEvent e) -> {
            if (loginControl != null) {
                loginControl.login();
            }
        });
        
        registerButton.addActionListener((ActionEvent e) -> {
            if (loginControl != null) {
                loginControl.register();
            }
        });
    }
    /*        
     * Method to display the window
     */
    public void showWindow() {
        if (frame != null) {
            frame.setVisible(true);
        }
    }

    /*
     * Method to hide the window
     */
    public void hideWindow() {
        if (frame != null) {
            frame.setVisible(false);
        }
    }

    /*
     * Getter for the username
     */
    public String getUsername() {
        return userText.getText();
    }

    /*
     * Getter for the password
     */
    public String getPassword() {
        return passwordText.getText();
    }

    /*
     * Method to set the message label text
     */
    public void setMessage(String message) {
        if (messageLabel != null) {
            messageLabel.setText(message);
        }
    }
}