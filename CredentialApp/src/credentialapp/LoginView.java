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
import javax.swing.JTextField;

/**
 *
 * @author ggs5053
 */
public class LoginView extends JPanel {
    
    JTextField usernameTF;
    JTextField passwordTF;
    JLabel usernameJL;
    JLabel passwordJL;
    JButton loginButton;
    JButton signupButton;
    
    public LoginView(){
       
       super();
       
       setBackground(Color.lightGray);// Colors
       
       usernameJL = new JLabel("Username: "); // Labels
       passwordJL = new JLabel("Password: ");
       
       usernameTF = new JTextField(" Enter your username! "); // Textfields 
       passwordTF = new JTextField(" Enter your password! ");
       
       loginButton = new JButton("Login"); // Buttons
       signupButton = new JButton("Sign Up!");
       
       add(usernameJL); //adding items to panel
       add(usernameTF);
       add(passwordJL);
       add(passwordTF);
       add(loginButton);
       add(signupButton);
       
    }
    
}
