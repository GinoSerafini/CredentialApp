/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialapp;

import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Group 5
 */
public class InitialFrame extends JFrame {
    LoginView loginView; //view for the login
    LoginController loginCont; //controller for the login
    LoginModel loginModel;//model for the login
    
    /**
     * Constructs a new Initial Frame for the Credential Application
     * @throws SQLException 
     */
    public InitialFrame() throws SQLException {
        super("Credential Application"); //Call the super constructor for the frame
        setLocationRelativeTo(null); //Set the location relative to nothing so that it appears in the senter
        setDefaultCloseOperation(EXIT_ON_CLOSE); //allow the window to close by closing the frame
        setSize (200, 200); //set the size \
        setResizable(false);//dont allow resizeing
        
        
        loginModel = new LoginModel(); //new login model
        loginView = new LoginView(loginModel); //new loginview
        loginCont = new LoginController(loginModel, loginView); //new login controller
        
        add(loginView); //add the view to the frame
        
    }
}
