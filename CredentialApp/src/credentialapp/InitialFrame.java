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
 * @author ggs5053
 */
public class InitialFrame extends JFrame {
    LoginView loginView;
    LoginController loginCont;
    LoginModel loginModel;
    
    public InitialFrame() throws SQLException {
        super("Credential Application");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (200, 200);
        
        
        loginModel = new LoginModel();
        loginView = new LoginView(loginModel);
        loginCont = new LoginController(loginModel, loginView);
        
        add(loginView);
    }
}
