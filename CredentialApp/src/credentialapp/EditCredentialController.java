
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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Michael Cavallaro
 */
public class EditCredentialController {
    private EditCredentialModel model;
    private EditCredentialView view;
    private MainView mainView;
    private CredentialController credCont;
    public EditCredentialController(EditCredentialModel model, EditCredentialView view, MainView mainView) {
        this.model= model;
        this.view = view;
        this.mainView = mainView;
        this.credCont=credCont;
        view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCredential();
              
            }
        });
        
        view.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                mainView.setVisible(true);
                SwingUtilities.getWindowAncestor(view).setSize(250,300);
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
    
    private void updateCredential() {
        view.getTitleLabel().setForeground(Color.black);
        view.getDescriptionLabel().setForeground(Color.black);
        view.getEmailBox().setForeground(Color.black);
        view.getUsernameBox().setForeground(Color.black);
        view.getWebsiteLabel().setForeground(Color.black);
        view.getPasswordLabel().setForeground(Color.black);
        view.getConfirmLabel().setForeground(Color.black);
        view.getSq1Box().setForeground(Color.black);
        view.getSqa1Label().setForeground(Color.black);
        view.getSq2Box().setForeground(Color.black);
        view.getSqa2Label().setForeground(Color.black);
        view.getSq3Box().setForeground(Color.black);
        view.getSqa3Label().setForeground(Color.black);
        model.getCredential().setTitle(view.getTitleField().getText());
        model.getCredential().setDescription(view.getDescriptionField().getText());
        model.getCredential().setEmail(view.getEmailField().getText());
        model.getCredential().setWebsite(view.getWebsiteField().getText());
        model.getCredential().setUsername(view.getUsernameField().getText());
        model.getCredential().setPassword(new String(view.getPasswordField().getPassword()));
        String confirm = new String(view.getConfirmField().getPassword());
        
        if(model.getCredential().getTitle().equals("") || model.getCredential().getDescription().equals("") || 
                model.getCredential().getWebsite().equals("") ||
                (model.getCredential().getEmail().equals("") && view.getEmailBox().isSelected()) || 
                (model.getCredential().getUsername().equals("")&&view.getUsernameBox().isSelected()) || 
                (model.getCredential().getSecurityQuestion1().equals("") && view.getSq1Box().isSelected()) || 
                (model.getCredential().getSecurityQuestion2().equals("") && view.getSq2Box().isSelected())||
                (model.getCredential().getSecurityQuestion3().equals("") && view.getSq3Box().isSelected()) ||
                (model.getCredential().getPassword().equals("")) || confirm.equals("")) {
            if(view.getTitleField().getText().equals("")) {
                view.getTitleLabel().setForeground(Color.red);
            } 
            if(view.getWebsiteField().getText().equals("")) {
                view.getWebsiteLabel().setForeground(Color.red);
                
            }
            if((view.getEmailField().getText().equals("")&&view.getEmailBox().isSelected())) {
                view.getEmailBox().setForeground(Color.red);
            } 
            if((view.getUsernameField().getText().equals("")&&view.getUsernameBox().isSelected())) {
                view.getUsernameBox().setForeground(Color.red);
            } 
            if(new String(view.getPasswordField().getPassword()).equals("") || new String(view.getConfirmField().getPassword()).equals("")) {
                view.getPasswordLabel().setForeground(Color.red);
                view.getConfirmLabel().setForeground(Color.red);
            }
            if(view.getSq1Field().getText().equals("") && view.getSq1Box().isSelected()) {
                view.getSq1Box().setForeground(Color.red);
                if(view.getSqa1Field().getText().equals("")) {
                    view.getSqa1Label().setForeground(Color.red);
                }
            } 
            if(view.getSq2Field().getText().equals("") && view.getSq2Box().isSelected()) {
                view.getSq1Box().setForeground(Color.red);
                if(view.getSqa2Field().getText().equals("")) {
                    view.getSqa2Label().setForeground(Color.red);
                }
            } 
            if(view.getSq3Field().getText().equals("") && view.getSq3Box().isSelected()) {
                view.getSq3Box().setForeground(Color.red);
                if(view.getSqa3Field().getText().equals("")) {
                    view.getSqa3Label().setForeground(Color.red);
                }
            } 
            view.getOutputLabel().setForeground(Color.red);
            view.getOutputLabel().setText("Missing Required Fields");
            
        } else {
            try {
                Connection conn = establishConnection();
                Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                int rs = stmnt.executeUpdate("UPDATE CREDENTIAL SET TITLE='"+model.getCredential().getTitle()+"',"+
                                                                    "DESCRIPTION='"+model.getCredential().getDescription()+"',"+
                                                                    "WEBSITE='"+model.getCredential().getWebsite()+"',"+
                                                                    "EMAIL='"+model.getCredential().getEmail()+"',"+
                                                                    "USERNAME='"+model.getCredential().getUsername()+"',"+
                                                                    "PASSWORD='"+model.getCredential().getPassword()+"',"+
                                                                    "SECURITY_QUESTION_1='"+model.getCredential().getSecurityQuestion1()+"',"+
                                                                    "SECURITY_QUESTION_2='"+model.getCredential().getSecurityQuestion2()+"',"+
                                                                    "SECURITY_QUESTION_3='"+model.getCredential().getSecurityQuestion3()+"',"+
                                                                    "SECURITY_ANSWER_1='"+model.getCredential().getSecurityAnswer1()+"',"+
                                                                    "SECURITY_ANSWER_2='"+model.getCredential().getSecurityAnswer2()+"',"+
                                                                    "SECURITY_ANSWER_3='"+model.getCredential().getSecurityAnswer3()+"'"+
                                                                     "WHERE ID ="+model.getCredential().getID());
                System.out.println(rs);
                view.setVisible(false);
                mainView.setVisible(true);
                mainView.getCredentialView().revalidate();
                mainView.getCredentialView().repaint();
                mainView.getCredentialController().addCredentials(mainView.getProfileModel().getCredentialList());
                SwingUtilities.getWindowAncestor(view).setSize(250,300); 
                conn.close();
                mainView.getOutputLabel().setForeground(Color.green.darker());
                mainView.getOutputLabel().setText("Changes were successfully made!");
            } catch (SQLException ex) {
                Logger.getLogger(NewCredentialController.class.getName()).log(Level.SEVERE, null, ex);
                mainView.getOutputLabel().setForeground(Color.red.darker());
                mainView.getOutputLabel().setText("An error occured when making changes!");
            }
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
