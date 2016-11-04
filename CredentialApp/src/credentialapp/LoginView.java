/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialapp;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Group 5
 */
public class LoginView extends JPanel {
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel outputLabel;
    private JButton loginButton;
    private JButton signupButton;
    
    public LoginView(LoginModel model){
       
       super();
       
       setBackground(Color.lightGray);// Colors
       
       usernameLabel = new JLabel("Username:"); // Labels
       passwordLabel = new JLabel("Password:");
       outputLabel = new JLabel();
       outputLabel.setForeground(Color.red);
       
       usernameField = new JTextField(12); // Textfields 
       passwordField = new JPasswordField(12);
       
       loginButton = new JButton("Login"); // Buttons
       signupButton = new JButton("Sign Up!");
       
       add(usernameLabel); //adding items to panel
       add(usernameField);
       add(passwordLabel);
       add(passwordField);
       add(loginButton);
       add(signupButton);
       add(outputLabel);
       
    }

    /**
     * Get the Username Field Object
     * @return 
     */
    public JTextField getUsernameField() {
        return usernameField;
    }

    /**
     * Get the Password Field Object
     * @return 
     */
    public JTextField getPasswordField() {
        return passwordField;
    }

    /**
     * Get the login button object
     * @return 
     */
    public JButton getLoginButton() {
        return loginButton;
    }

    /**
     * Get the signup button object
     * @return 
     */
    public JButton getSignupButton() {
        return signupButton;
    }

    /**
     * Get the outputlabel object
     * @return 
     */
    public JLabel getOutputLabel() {
        return outputLabel;
    }
   
            
}
