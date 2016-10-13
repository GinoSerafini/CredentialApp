/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ggs5053
 */
public class LoginController implements ActionListener {
    private final String SERVER_NAME="mysql.up.ist.psu.edu";
    private final int PORT_NUM=3306;
    private final String DBMS="mysql";
    private final String DB_USERNAME="mvc5715";
    private final String DB_PASSWORD="ist311";
    
    private String username;
    private String password;
    
    private LoginModel model;
    private LoginView view;
    
    public LoginController(LoginModel model, LoginView view) throws SQLException {
        view.getLoginButton().addActionListener(this);
        view.getSignupButton().addActionListener(this);
    }
    
    
    protected void newUser() {
        
    }
    
    
    
    protected void authenticateLogin() throws SQLException {
        Connection connection = establishConnection();
        PreparedStatement stmnt = connection.prepareStatement("SELECT * FROM account WHERE username="+this.username+"AND password="+this.password+";");
        ResultSet rs = stmnt.executeQuery();
        
        System.out.println(rs.getString(1));
    }
    
    protected Connection establishConnection() throws SQLException {
        Connection connection = null;
        Properties connProps = new Properties();
        connProps.put("user", "mvc5715");
        connProps.put("password","ist311");
        connection = DriverManager.getConnection("jdbc:" + DBMS + "://" +SERVER_NAME +":" + PORT_NUM + "/", connProps);

        
        return connection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(view.loginButton);
        if(true) {
            System.out.println("IN");
            this.username = view.getUsernameTF().getText();
            this.password = view.getPasswordTF().getText();
            try {
                authenticateLogin();
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(e.getSource()==view.getSignupButton()) {
            ;
        }
    }
    
   
    
}
