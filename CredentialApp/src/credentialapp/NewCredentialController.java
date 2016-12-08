
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
import javax.swing.SwingUtilities;

/**
 *
 * @author Michael Cavallaro
 */
public class NewCredentialController {
    private NewCredentialModel model;
    private NewCredentialView view;
    private MainView mainView;
    public NewCredentialController(NewCredentialModel model, NewCredentialView view, MainView mainView) {
        this.model = model;
        this.view = view;
        this.mainView=mainView;
        view.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCredential();
                mainView.getCredentialController().createCredentialPanel(mainView.getProfileModel().getCredentialList().size()-1);
            }   
        });
        
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==view.getBackButton()) {
                    view.setVisible(false);
                    mainView.setVisible(true);
                    SwingUtilities.getWindowAncestor(view).setSize(250,300);
                }
            
            }
        });
        
        view.getEmailBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getEmailBox().isSelected()) {
                    view.getEmailField().setEnabled(true);
                    view.getEmailField().setBackground(Color.WHITE);
                }else {
                    view.getEmailField().setEnabled(false);
                    view.getEmailField().setBackground(Color.GRAY);
                }
            }
        });
        
        view.getUsernameBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getUsernameBox().isSelected()) {
                    view.getUsernameField().setEnabled(true);
                    view.getUsernameField().setBackground(Color.WHITE);
                }else {
                    view.getUsernameField().setEnabled(false);
                    view.getUsernameField().setBackground(Color.GRAY);
                }
            }
        });
        view.getSq1Box().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getSq1Box().isSelected()) {
                    view.getSq1Field().setEnabled(true);
                    view.getSq1Field().setBackground(Color.WHITE);
                    view.getSqa1Field().setBackground(Color.WHITE);
                    view.getSqa1Field().setEnabled(true);
                }else {
                    view.getSq1Field().setEnabled(false);
                    view.getSqa1Field().setEnabled(false);
                    view.getSqa1Field().setBackground(Color.GRAY);
                    view.getSq1Field().setBackground(Color.GRAY);
                }
            }
        });
        view.getSq2Box().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getSq2Box().isSelected()) {
                    view.getSq2Field().setEnabled(true);
                    view.getSqa2Field().setEnabled(true);
                    view.getSqa2Field().setBackground(Color.WHITE);
                    view.getSq2Field().setBackground(Color.WHITE);
                }else {
                    view.getSq2Field().setEnabled(false);
                    view.getSqa2Field().setEnabled(false);
                    view.getSq2Field().setBackground(Color.GRAY);
                    view.getSqa2Field().setBackground(Color.GRAY);
                }
            }
        });
        view.getSq3Box().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getSq3Box().isSelected()) {
                    view.getSq3Field().setEnabled(true);
                    view.getSqa3Field().setEnabled(true);
                    view.getSqa3Field().setBackground(Color.WHITE);
                    view.getSq3Field().setBackground(Color.WHITE);
                }else {
                    view.getSq3Field().setEnabled(false);
                    view.getSqa3Field().setEnabled(false);
                    view.getSq3Field().setBackground(Color.GRAY);
                    view.getSqa3Field().setBackground(Color.GRAY);
                }
            }
        });
        
        
    }
    
    private void addCredential() {
        model.setTitle(view.getTitleField().getText());
        model.setDescription(view.getDescriptionField().getText());
        model.setEmail(view.getEmailField().getText());
        model.setWebsite(view.getWebsiteField().getText());
        model.setUsername(view.getUsernameField().getText());
        model.setPassword(new String(view.getPasswordField().getPassword()));
        model.setConfirmPassword(new String(view.getConfirmField().getPassword()));
        
        if(model.getTitle().equals("") || model.getDescription().equals("") || 
                (model.getEmail().equals("")&&view.getEmailBox().isSelected()) || 
                (model.getUsername().equals("")&&view.getUsernameBox().isSelected()) || 
                (model.getSecurityQuestion1().equals("") && view.getSq1Box().isSelected()) || 
                (model.getSecurityQuestion2().equals("") && view.getSq2Box().isSelected())||
                (model.getSecurityQuestion3().equals("") && view.getSq3Box().isSelected()) ||
                (model.getPassword().equals("")) || model.getConfirmPassword().equals("")) {
            
            view.getOutputLabel().setForeground(Color.red);
            view.getOutputLabel().setText("Missing Required Fields");
            
        } else {
            try {
                Connection conn = establishConnection();
                Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                int rs = stmnt.executeUpdate("INSERT INTO CREDENTIAL (ACCOUNT_ID,TITLE,DESCRIPTION,WEBSITE,EMAIL,USERNAME,PASSWORD,SECURITY_QUESTION_1,SECURITY_QUESTION_2,SECURITY_QUESTION_3,SECURITY_ANSWER_1,SECURITY_ANSWER_2,SECURITY_ANSWER_3) VALUES ("
                        +"(SELECT ACCOUNT.ID FROM ACCOUNT WHERE ACCOUNT.username='"+model.getProfileModel().getUsername()+"'),'"+
                        model.getTitle()+"','"+
                        model.getDescription()+"','"+
                        model.getWebsite()+"','"+
                        model.getEmail()+"','"+
                        model.getUsername()+"','"+
                        model.getPassword()+"','"+
                        model.getSecurityQuestion1()+"','"+
                        model.getSecurityQuestion2()+"','"+
                        model.getSecurityQuestion3()+"','"+
                        model.getSecurityAnswer1()+"','"+
                        model.getSecurityAnswer2()+"','"+
                        model.getSecurityAnswer3()+"')");
                conn.close();
                mainView.setVisible(true);
                SwingUtilities.getWindowAncestor(view).setSize(250,300);
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(NewCredentialController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Credential c = new Credential(model.getTitle(),model.getDescription(),model.getWebsite(),model.getEmail(),model.getUsername(),model.getPassword(),model.getSecurityQuestion1(),model.getSecurityQuestion2(),model.getSecurityQuestion3(),model.getSecurityAnswer1(),model.getSecurityAnswer2(),model.getSecurityAnswer3());
            model.getProfileModel().getCredentialList().add(c);
        }
    }
    
    protected Connection establishConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
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

        
        return connection;
    }
    
}
