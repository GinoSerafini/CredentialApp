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
 * @author Group 5
 */
public class LoginController  {
    private LoginModel model; //model for the lgin
    private LoginView view; //model for the view
    
    public LoginController(LoginModel model, LoginView view) throws SQLException {
        this.view = view;
        this.model = model;
        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                model.setUsername(view.getUsernameField().getText()); //get the username from the view
                model.setPassword(view.getPasswordField().getText()); //get the password from the view
                try {
                    if(authenticateLogin()) { //try authenticationg
                        MainFrame m = new MainFrame(model.getUsername()); //new frame for the main portion of the program
                        m.getMainView().getProfileController().establishConnection(); 
                        m.getMainView().getProfileModel().setUsername(model.getUsername());
                        m.setVisible(true);//set the new fram to visible
                        SwingUtilities.getWindowAncestor(view).dispose(); //get ride of the first frame
                                
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        view.getSignupButton().addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    newUser(); 
                }
        });
    }
    
    
    /**
     * Creates a new user panel
     */
    protected void newUser() {
        NewUserModel newUserModel= new NewUserModel(); //model for the new user
        NewUserView newUserView = new NewUserView(newUserModel); //view for the new suer
        NewUserController newUserController = new NewUserController(newUserModel, newUserView, view); //controller for the new user
        view.getParent().add(newUserView);//add the new user view to parent frame
        SwingUtilities.getWindowAncestor(view).setSize(390,330);//reset the frame size
        view.setVisible(false); //set the login panel to hidden
        newUserView.setVisible(true); //set the new user panel to visible
        view.getParent().repaint(); //repaint the frame
    }
    
    
    /**
     * Authenticate the user
     * @return true if the user has been
     * @throws SQLException 
     */
    protected boolean authenticateLogin() throws SQLException {
        Connection connection = establishConnection(); //establish connection
        //allow for data to be read from the result set
        Statement stmnt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //System.out.println(connection.isClosed());
        ResultSet rs = stmnt.executeQuery("SELECT * FROM ACCOUNT WHERE username='"+model.getUsername()+"' AND password='"+model.getPassword()+"'");
        if(!rs.isBeforeFirst()) { //if the username and password werent matched
            view.getOutputLabel().setText("Invalid Username/Password");
            return false; //return false authentication
        } else {
            System.out.println("User authenticated.");
            connection.close(); //close connection
            return true;
        }
    }
    
    /**
     * Establish a connection with DB
     * @return the valid connection
     * @throws SQLException 
     */
    protected Connection establishConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance(); //new client driver
            //connect to database
            connection = DriverManager.getConnection(DatabaseConstants.SERVER+";user="+DatabaseConstants.DB_USERNAME+";password="+DatabaseConstants.DB_PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) { 
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return connection; //return the valid connection
    }
   
}
