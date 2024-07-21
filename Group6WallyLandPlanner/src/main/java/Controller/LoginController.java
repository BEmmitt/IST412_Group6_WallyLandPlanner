/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import View.LoginView;
import View.PlannerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
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
    
    private static final String USER_DATA_FILE = "users.json";
    private List<User> userList;
    private User loggedInUser;
    private LoginView loginView;
    private PlannerView plannerView;
    private PlannerController plannerController;

    /**
     * Constructs a new LoginController with an empty user list
     * @param loginView
     * @param plannerView
     * @param userList
     */
    public LoginController(LoginView loginView, PlannerView plannerView, List<User> userList) {
        this.loginView = loginView;
        this.plannerView = plannerView;
        this.userList = loadUsers();
        this.plannerController = null;
    }
    
    /*
     * Method to start the login process
     */
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
            
            loggedInUser = currentUser;            
            plannerController = new PlannerController(loggedInUser);
            
            // Delay hiding the login window and showing the planner window
            javax.swing.Timer timer = new javax.swing.Timer(2000, (ActionEvent e) -> {
                loginView.hideWindow();
                plannerView.createWindow(currentUser, this);
                plannerView.showWindow();
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            loginView.setMessage("Login failed. Please try again or register a new account.");
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
        
        if (!ValidationHelper.isValidUsername(username)) {
            loginView.setMessage("Registration failed: Invalid username. Username cannot be blank.");
            System.out.println("Registration failed: Invalid username. Username cannot be blank.");
            return;
        }
        
        if (!ValidationHelper.isValidPassword(password)) {
            loginView.setMessage("Registration failed: Invalid password. Password cannot be blank.");
            System.out.println("Registration failed: Invalid password. Password cannot be blank.");
            return;
        }
        
    try {
        User newUser = new User(username, password);
        userList.add(newUser);
        saveUsers();
        loginView.setMessage("Registration successful. You can now log in.");
        System.out.println("Registration successful. You can now log in.");
    } catch (Exception e) {
        loginView.setMessage("Registration failed: An unexpected error occurred.");
        System.err.println("Registration failed: " + e.getMessage());
        e.printStackTrace();
    }
     }

    /**
     * Logs out the currently logged in user
     */
    public void logout() {
        System.out.println("Attempting to log out"); // Debug statement
        if (loggedInUser != null) {
            System.out.println("Logout successful, goodbye " + loggedInUser.getUsername() + ".");
            loggedInUser = null;
        } else {
            System.out.println("No user is currently logged in"); // Debug statement
        }
        plannerView.hideWindow();
        startLoginProcess();
    }
    
    private void saveUsers() {
        try (Writer writer = new FileWriter(USER_DATA_FILE)) {
            Gson gson = new Gson();
            gson.toJson(userList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> loadUsers() {
        try (Reader reader = new FileReader(USER_DATA_FILE)) {
            Gson gson = new Gson();
            java.lang.reflect.Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            return gson.fromJson(reader, userListType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Return an empty list if the file is not found
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
