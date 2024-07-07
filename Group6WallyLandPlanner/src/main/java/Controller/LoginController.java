/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import View.LoginView;
import View.PlannerView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * The LoginController class manages user authentication, including logging in, registering, and logging out users
 * This implementation will use a list to store user information
 * 
 * @author bemmi 
 * @author Jordan
 */
public class LoginController {
    
    private List<User> userList;
    private User loggedInUser;
    private LoginView loginView;
    private PlannerView plannerView;

    /**
     * Constructs a new LoginController with an empty user list
     * @param loginView
     * @param plannerView
     * @param userList
     */
    public LoginController(LoginView loginView, PlannerView plannerView, List<User> userList) {
        this.loginView = loginView;
        this.plannerView = plannerView;
        this.userList = userList;
    }
    
    // Method to start the login process
    public void startLoginProcess() {
        loginView.setLoginController(this);
        loginView.createWindow(this);
        loginView.showWindow();
    }

    /**
     * Logs in a user with the username/password
     */
    public void login() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        User currentUser = new User(username, password);
        
        // Debugging statements
        System.out.println("Attempting login with username: " + username + " and password: " + password);

        // Simulated user validation logic
        if (userList.contains(currentUser)) {
            loginView.setMessage("Login successful");
            System.out.println("Login successful");

            // Delay hiding the login window and showing the planner window
            javax.swing.Timer timer = new javax.swing.Timer(2000, (ActionEvent e) -> {
                loginView.hideWindow();
                plannerView.createWindow(currentUser);
                plannerView.showWindow();
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            loginView.setMessage("Login failed");
            System.out.println("Login failed");
        }
    }

    /**
     * Registers a new user with username and password
     *
     */
     public void register() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                loginView.setMessage("Registration failed: Username already exists.");
                System.out.println("Registration failed: Username already exists.");
                return;
            }
        }
        
        User newUser = new User(username, password);
        userList.add(newUser);
        loginView.setMessage("Registration successful. You can now log in.");
        System.out.println("Registration successful. You can now log in.");
     }

    /**
     * Logs out the currently logged in user
     */
    public void logout() {
        if (loggedInUser != null) {
            System.out.println("Logout successful, goodbye " + loggedInUser.getUsername() + ".");
            loggedInUser = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }
}
