/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
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

    /**
     * Constructs a new LoginController with an empty user list
     */
    public LoginController() {
        userList = new ArrayList<>();
        loggedInUser = null;
    }

    /**
     * Logs in a user with the username/password
     *
     * @param username the username of the user attempting to log in
     * @param password the password of the user attempting to log in
     */
    public void login(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful!! Welcome " + username + ".");
                return;
            }
        }
        System.out.println("Login failed!! Invalid username or password.");
    }

    /**
     * Registers a new user with username and password
     *
     * @param username the desired username for the new user
     * @param password the desired password for the new user
     */
    public void registerUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                System.out.println("Registration failed!! Username already exists.");
                return;
            }
        }
        User newUser = new User(username, password);
        userList.add(newUser);
        System.out.println("Registration successful!! You can now log in.");
    }

    /**
     * Logs out the currently loggedin user
     */
    public void logout() {
        if (loggedInUser != null) {
            System.out.println("Logout successful, goodbye " + loggedInUser.getUsername() + ".");
            loggedInUser = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    /**
     * Main method demonstrates the functionality of the LoginController class
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        LoginController controller = new LoginController();

        // Test cases
        controller.registerUser("user1", "password01");
        controller.login("user1", "password01");
        controller.logout();
        controller.login("user1", "badpassword");
        controller.registerUser("user1", "password02");
    }
}
