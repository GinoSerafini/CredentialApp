
package credentialapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Michael Cavallaro
 */
public class ProfileController {
    private ProfileModel model;
    private ProfileView view; 
    
    public ProfileController(ProfileModel model, ProfileView view) {
        this.model = model;
        this.view = view;
        loadCredentials();
        view.getAddCredentialButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewCredentialModel newCredentialModel = new NewCredentialModel(model); //model for the new user
                NewCredentialView newCredentialView = new NewCredentialView(newCredentialModel); //view for the new suer
                NewCredentialController newUserController = new NewCredentialController(newCredentialModel, newCredentialView, (MainView)view.getParent()); //controller for the new user
                view.getParent().getParent().add(newCredentialView);//add the new user view to parent frame
                SwingUtilities.getWindowAncestor(view).setSize(320,415);//reset the frame size
                view.getParent().setVisible(false); //set the login panel to hidden
            }
        });
    }
    
    protected Connection establishConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connection = DriverManager.getConnection(DatabaseConstants.SERVER+";user="+DatabaseConstants.DB_USERNAME+";password="+DatabaseConstants.DB_PASSWORD);
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM ACCOUNT WHERE username='"+model.getUsername()+"'");
            while(rs.next()) {
                model.setFirstName(rs.getString("FIRST_NAME"));
                model.setLastName(rs.getString("LAST_NAME"));
                model.setEmail(rs.getString("EMAIL"));
            }
            view.getNameLabel().setText(model.getFirstName()+" "+model.getLastName());
            view.getEmailLabel().setText(model.getEmail());
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
   
    
    private void loadCredentials() {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connection = DriverManager.getConnection(DatabaseConstants.SERVER+";user="+DatabaseConstants.DB_USERNAME+";password="+DatabaseConstants.DB_PASSWORD);
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM CREDENTIAL WHERE CREDENTIAL.ACCOUNT_ID=(SELECT ACCOUNT.ID FROM ACCOUNT WHERE ACCOUNT.USERNAME='"+model.getUsername()+"')");
            
            while(rs.next()) {
                Credential c = new Credential(rs.getString("ID"),rs.getString("TITLE"),rs.getString("DESCRIPTION"),rs.getString("WEBSITE"),rs.getString("EMAIL"),rs.getString("USERNAME"),rs.getString("PASSWORD"),rs.getString("SECURITY_QUESTION_1"),rs.getString("SECURITY_QUESTION_2"),rs.getString("SECURITY_QUESTION_3"),rs.getString("SECURITY_ANSWER_1"),rs.getString("SECURITY_ANSWER_2"),rs.getString("SECURITY_ANSWER_3"));
                model.getCredentialList().add(c);
               
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) { 
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
