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
 * @author ggs5053
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

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getSignupButton() {
        return signupButton;
    }

    public void setSignupButton(JButton signupButton) {
        this.signupButton = signupButton;
    }
    
    public JLabel getOutputLabel() {
        return outputLabel;
    }
    
    public void setOutputLabel(JLabel outputLabel) {
        this.outputLabel = outputLabel;
    }
            
}
