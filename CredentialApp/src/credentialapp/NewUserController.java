
package credentialapp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Group 5
 */
public class NewUserController {
    private final String SERVER="jdbc:derby://localhost:1527/IST311";
    private final String DB_USERNAME="ist311";
    private final String DB_PASSWORD="ist311";
    
    private NewUserModel model;
    private NewUserView view;
    private LoginView loginView;
    public NewUserController(NewUserModel model, NewUserView view, LoginView loginView) {
        this.model = model;
        this.view = view;
        this.loginView = loginView;
        
        view.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==view.getRegisterButton()) {
                    registerUser();
                }
            }
        });
        
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==view.getBackButton()) {
                    view.setVisible(false);
                    loginView.setVisible(true);
                    SwingUtilities.getWindowAncestor(view).setSize(200,200);
                }
            
            }
        });
    }
    
    private void registerUser() {
        view.getFirstNameLabel().setForeground(Color.black);
        view.getLastNameLabel().setForeground(Color.black);
        view.getEmailLabel().setForeground(Color.black);
        view.getUsernameLabel().setForeground(Color.black);
        view.getPasswordLabel().setForeground(Color.black);
        view.getSecurityAnswerLabel().setForeground(Color.black);
        view.getSecurityAnswerLabel().setForeground(Color.black);
        model.setFirstName(view.getFirstNameField().getText());
        model.setLastName(view.getLastNameField().getText());
        model.setEmail(view.getEmailField().getText());
        model.setUsername(view.getUsernameField().getText());
        model.setPassword(new String(view.getPasswordField().getPassword()));
        model.setConfirmPassword(new String(view.getConfirmField().getPassword()));
        model.setSecurityQuestion((String) view.getSecurityQuestionBox().getSelectedItem());
        model.setSecurityAnswer(view.getSecurityAnswerField().getText());
        
        if(model.getFirstName().equals("")|| model.getLastName().equals("") || model.getEmail().equals("") || model.getSecurityQuestion().equals("") || model.getSecurityAnswer().equals("") || model.getPassword().equals("") || model.getUsername().equals("") ) {
            JOptionPane.showMessageDialog(view, "You are missing one or more required fields.", "Missing Fields", JOptionPane.ERROR_MESSAGE);
            if(model.getFirstName().equals("")) {
                view.getFirstNameLabel().setForeground(Color.red);
            }
            if(model.getLastName().equals("")) {
                view.getLastNameLabel().setForeground(Color.red);
            }
            if(model.getEmail().equals("")) {
                view.getEmailLabel().setForeground(Color.red);
            }
            if(model.getUsername().equals("")) {
                view.getUsernameLabel().setForeground(Color.red);
            }
            if(model.getPassword().equals("")) {
                view.getPasswordLabel().setForeground(Color.red);
            }
            if(model.getConfirmPassword().equals("")) {
                view.getConfirmLabel().setForeground(Color.red);
            }
            if(model.getSecurityQuestion().equals("")) {
                view.getSecurityAnswerLabel().setForeground(Color.red);
            }
            if(model.getSecurityAnswer().equals("")) {
                view.getSecurityAnswerLabel().setForeground(Color.red);
            }
            //view.repaint();
            
        } else if(!checkUsernameAvailability()) {
            JOptionPane.showMessageDialog(view, "Username has already been taken. Please choose another.", "Username Unavailable", JOptionPane.ERROR_MESSAGE);
            view.getUsernameField().setText("");
        } else if(!model.getConfirmPassword().equals(model.getPassword())) {
            JOptionPane.showMessageDialog(view, "Passwords do not match. Please re-enter your password", "Unmatching Passwords", JOptionPane.ERROR_MESSAGE);
            view.getPasswordField().setText("");
            view.getConfirmField().setText("");
        } else {
            insertUser();
        }
        
        
    }
    
    private void insertUser() {
        try {
            Connection conn = establishConnection();
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int rs = stmnt.executeUpdate("INSERT INTO ACCOUNT (FIRST_NAME,LAST_NAME,EMAIL,USERNAME,PASSWORD,SECURITY_QUESTION,SECURITY_ANSWER) VALUES ('"+
                    model.getFirstName()+"','"+
                    model.getLastName()+"','"+
                    model.getEmail()+"','"+
                    model.getUsername()+"','"+
                    model.getPassword()+"','"+
                    model.getSecurityQuestion()+"','"+
                    model.getSecurityAnswer()+"')");
            view.getOutputLabel().setForeground(Color.green.darker());
            view.getOutputLabel().setText("  Your account has been created! You may now login!");
        } catch (SQLException ex) {
            Logger.getLogger(NewUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean checkUsernameAvailability() {
        try {
            Connection conn = establishConnection();
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmnt.executeQuery("SELECT * FROM ACCOUNT WHERE username='"+model.getUsername()+"'");
            if(!rs.isBeforeFirst()) {
                conn.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    protected Connection establishConnection() throws SQLException {
        Connection connection = null;
        try {//https://my.up.ist.psu.edu/phpmyadmin/db_structure.php?server=1&db=mvc5715&token=61224445d3a074ffa05be37fbe7b46b6
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
