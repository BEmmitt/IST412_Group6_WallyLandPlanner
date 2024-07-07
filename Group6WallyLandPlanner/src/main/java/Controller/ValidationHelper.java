/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author bemmi
 */
public class ValidationHelper {
    
    public static boolean isValidUsername(String username) {
        return !username.equals("");
    }

    public static boolean isValidPassword(String password) {
        return !password.equals("");
    }
    
}
