/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credentialapp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author ggs5053
 */
public class LoginController  {
    private final String SERVER="jdbc:derby://localhost:1527/IST311";
    private final String DB_USERNAME="ist311";
    private final String DB_PASSWORD="ist311";
    
    private LoginModel model;
    private LoginView view;
    
    public LoginController(LoginModel model, LoginView view) throws SQLException {
        this.view = view;
        this.model = model;
        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == view.getLoginButton()) {
                        model.setUsername(view.getUsernameField().getText());
                        model.setPassword(view.getPasswordField().getText());
                        try {
                            if(authenticateLogin()) {

                                MainFrame m = new MainFrame();
                                m.setVisible(true);
                                SwingUtilities.getWindowAncestor(view).dispose();
                                
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
        });
        view.getSignupButton().addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == view.getSignupButton()) {
                        newUser();
             
                    }
                }
        });
    }
    
    
    protected void newUser() {
        NewUserModel newUserModel= new NewUserModel();
        NewUserView newUserView = new NewUserView(newUserModel);
        NewUserController newUserController = new NewUserController(newUserModel, newUserView);
        view.getParent().add(newUserView);
        SwingUtilities.getWindowAncestor(view).setSize(220,310);
        view.setVisible(false);
        newUserView.setVisible(true);
        view.getParent().repaint();
    }
    
    
    
    protected boolean authenticateLogin() throws SQLException {
        Connection connection = establishConnection();
        Statement stmnt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //System.out.println(connection.isClosed());
        ResultSet rs = stmnt.executeQuery("SELECT * FROM ACCOUNT WHERE username='"+model.getUsername()+"' AND password='"+model.getPassword()+"'");
        if(!rs.isBeforeFirst()) {
            view.getOutputLabel().setText("Invalid Username/Password");
            return false;
        } else {
            System.out.println("User authenticated.");
            connection.close();
            return true;
        }
    }
    
    protected Connection establishConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connection = DriverManager.getConnection(SERVER+";user="+DB_USERNAME+";password="+DB_PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) { 
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return connection;
    }
   
}
