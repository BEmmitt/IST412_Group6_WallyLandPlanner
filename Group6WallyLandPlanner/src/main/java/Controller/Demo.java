/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import View.LoginView;
import View.PlannerView;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bemmi
 */
public class Demo {
    
   static LoginView loginView = new LoginView();
   static PlannerView plannerView = new PlannerView();
        
   // List of valid users for the example
   static List<User> userList = Arrays.asList(new User("testuser", "testpass"));
   
   static LoginController loginController = new LoginController(loginView, plannerView, userList);
    
    public static void run()
    {
        loginController.startLoginProcess();
    }
    
}
