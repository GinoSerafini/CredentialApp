/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialapp;

import javax.swing.JFrame;

/**
 *
 * @author ggs5053
 */
public class InitialFrame extends JFrame {
    LoginView loginScreen;
    
    public InitialFrame(){
        super("Credential Application");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize (800, 280);
        loginScreen = new LoginView();
        add(loginScreen);
    
    }
}
