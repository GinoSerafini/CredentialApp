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
    
    private JTextField usernameTF;
    private JTextField passwordTF;
    private JLabel usernameJL;
    private JLabel passwordJL;
    private JButton loginButton;
    private JButton signupButton;
    
    public LoginView(LoginModel model){
       
       super();
       
       setBackground(Color.lightGray);// Colors
       
       usernameJL = new JLabel("Username: "); // Labels
       passwordJL = new JLabel("Password: ");
       
       usernameTF = new JTextField(12); // Textfields 
       passwordTF = new JTextField(12);
       
       loginButton = new JButton("Login"); // Buttons
       signupButton = new JButton("Sign Up!");
       
       add(usernameJL); //adding items to panel
       add(usernameTF);
       add(passwordJL);
       add(passwordTF);
       add(loginButton);
       add(signupButton);
       
    }

    public JTextField getUsernameTF() {
        return usernameTF;
    }

    public void setUsernameTF(JTextField usernameTF) {
        this.usernameTF = usernameTF;
    }

    public JTextField getPasswordTF() {
        return passwordTF;
    }

    public void setPasswordTF(JTextField passwordTF) {
        this.passwordTF = passwordTF;
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
    
}
