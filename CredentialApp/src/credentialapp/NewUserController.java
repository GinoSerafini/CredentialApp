
package credentialapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public NewUserController(NewUserModel model, NewUserView view) {
        this.model = model;
        this.view = view;
        
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
                    
                }
            
            }
        });
    }
    
    private void registerUser() {
        model.setFirstName(view.getFirstNameField().getText());
        model.setLastName(view.getLastNameField().getText());
        model.setEmail(view.getEmailField().getText());
        model.setUsername(view.getUsernameField().getText());
        model.setPassword(view.getPasswordField().getPassword());
        model.setConfirmPassword(view.getConfirmField().getPassword());
        model.setSecurityQuestion((String) view.getSecurityQuestionBox().getSelectedItem());
        model.setSecurityAnswer(view.getSecurityAnswerField().getText());
        
        if(model.getFirstName().isEmpty() || model.getLastName().isEmpty() || model.getEmail().isEmpty() || model.getSecurityQuestion().isEmpty() || model.getSecurityAnswer().isEmpty()) {
            //missing required fields
        } else if(!checkUsernameAvailability()) {
            //username not available
        } else if(model.getConfirmPassword() != model.getPassword()) {
            //passwords must match
        } else {
            insertUser();
        }
        
        
    }
    
    private void insertUser() {
        try {
            Connection conn = establishConnection();
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmnt.executeQuery("INSER INTO ACCOUNT (FIRST_NAME,LAST_NAME,EMAIL,USERNAME,PASSWORD,SECURITY_QUESTION,SECURITY_ANSWER) VALUES ("+
                    model.getFirstName()+","+
                    model.getLastName()+","+
                    model.getEmail()+","+
                    model.getUsername()+","+
                    model.getPassword()+","+
                    model.getSecurityQuestion()+","+
                    model.getSecurityAnswer()+");");
        } catch (SQLException ex) {
            Logger.getLogger(NewUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean checkUsernameAvailability() {
        try {
            Connection conn = establishConnection();
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmnt.executeQuery("SELECT * FROM ACCOUNT WHERE username='"+model.getUsername()+"';");
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
