
package credentialapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Cavallaro
 */
public class ProfileController {
    private ProfileModel model;
    private ProfileView view; 
    private final String SERVER="jdbc:derby://localhost:1527/IST311";
    private final String DB_USERNAME="ist311";
    private final String DB_PASSWORD="ist311";
    
    public ProfileController(ProfileModel model, ProfileView view) {
        this.model = model;
        this.view = view;
        
        view.getAddCredentialButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
    protected Connection establishConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connection = DriverManager.getConnection(SERVER+";user="+DB_USERNAME+";password="+DB_PASSWORD);
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM ACCOUNT WHERE username="+model.getUsername());
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
   
}
