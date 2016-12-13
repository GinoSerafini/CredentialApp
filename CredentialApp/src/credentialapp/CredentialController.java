
package credentialapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.text.Document;

/**
 *
 * @author Michael Cavallaro
 */
public class CredentialController {
    private CredentialModel model;
    private CredentialView view;
    private MainView mainView;
    public CredentialController(CredentialModel model, CredentialView view,MainView mainView) {
        this.model=model;
        this.view =view;
        this.mainView=mainView;
        if(!model.getCredentialList().isEmpty()) {
            addCredentials(model.getCredentialList());
            
        } else {
            JLabel noCredentialsLabel = new JLabel("No credentials found.");
            view.setViewportView(noCredentialsLabel);
        }
    }
    
    public void addCredentials(ArrayList<Credential> credentialList) {
        JPanel mainPanel = new JPanel(new FlowLayout());
        for(int i=0; i<credentialList.size();i++) {
            JPanel p = createCredentialPanel(credentialList,i);
                
            p.setName(""+i);
            p.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Object[] buttons = {"Save", "Cancel"};
                    Component panel = (Component)e.getSource();
                    EditCredentialModel ecModel = new EditCredentialModel(credentialList.get(Integer.parseInt(panel.getName())));
                    EditCredentialView ecView = new EditCredentialView(ecModel);
                    EditCredentialController ecCont = new EditCredentialController(ecModel, ecView, mainView);
                    view.getParent().getParent().add(ecView);//add the new user view to parent frame
                    SwingUtilities.getWindowAncestor(view).setSize(320,415);//reset the frame size
                    view.getParent().setVisible(false); //set the login panel to hidden
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }

            });
            p.setBorder(BorderFactory.createLineBorder(Color.black));
            p.setPreferredSize(new Dimension(220,120));
            p.setVisible(true);
            mainPanel.add(p);
        }
        view.setViewportView(mainPanel);
    }
    
    private void deleteCredential(int i){
        Connection conn;
        try {
            conn = establishConnection();
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int rs = stmnt.executeUpdate("DELETE FROM CREDENTIAL WHERE ID="+model.getCredentialList().get(i).getID());
        } catch (SQLException ex) {
            Logger.getLogger(CredentialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.getCredentialList().remove(i);
        view.setVisible(false);
        mainView.setVisible(true);
        mainView.getCredentialView().revalidate();
        mainView.getCredentialView().repaint();
        addCredentials(model.getCredentialList());
        
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
    
    
    
    public JPanel createCredentialPanel(ArrayList<Credential> credentialList, int i) {
        JPanel p = new JPanel();
        JLabel titleLabel = new JLabel(credentialList.get(i).getTitle());
        JLabel descLabel = new JLabel(credentialList.get(i).getDescription());
        JLabel websiteLabel = new JLabel(credentialList.get(i).getWebsite());
        JLabel passwordLabel = new JLabel("Password: ******");
        JLabel emailLabel;
        JLabel usernameLabel;
        JLabel deleteLabel = new JLabel("X");
        deleteLabel.setName(""+i);
        JButton showPasswordButton = new JButton("Show");
        deleteLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(JOptionPane.showConfirmDialog(null,"Are you sure you would like to delete this credential?\nThis cannot be undone.","Delete Credential",JOptionPane.YES_NO_OPTION)==0) {
                    deleteCredential(Integer.parseInt(deleteLabel.getName()));
                } 
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
        showPasswordButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(showPasswordButton.getText().equals("Show")) {
                    showPasswordButton.setText("Hide");
                    passwordLabel.setText("Password:"+credentialList.get(i).getPassword());
                    
                }else {
                    showPasswordButton.setText("Show");
                    passwordLabel.setText("Password: ******");
                  
                }
            }
        });
        if(!credentialList.get(i).getEmail().equals(""))
            emailLabel = new JLabel("Email: "+credentialList.get(i).getEmail());
        else
            emailLabel = new JLabel("");
        if(!credentialList.get(i).getUsername().equals(""))
            usernameLabel = new JLabel("Username: "+credentialList.get(i).getUsername());
        else
            usernameLabel = new JLabel("");
        
	p.setLayout(new GridBagLayout());
	((GridBagLayout)p.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
	((GridBagLayout)p.getLayout()).rowHeights = new int[] {0, 0, 0};
	((GridBagLayout)p.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
	((GridBagLayout)p.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

        titleLabel.setFont(new Font("ARIAL", Font.BOLD, 24));
	p.add(titleLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 5), 0, 0));
        
        deleteLabel.setFont(new Font("ARIAL", Font.BOLD, 20));
        p.add(deleteLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.NORTHEAST, GridBagConstraints.NORTHEAST,
		new Insets(0, 0, 5, 5), 0, 0));
        
        descLabel.setFont(new Font("ARIAL", Font.PLAIN,18));
        p.add(descLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 5), 0, 0));
        
        websiteLabel.setFont(new Font("ARIAL", Font.PLAIN,16));
	p.add(websiteLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 0), 0, 0));
        
        
	p.add(usernameLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        p.add(passwordLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        
        p.add(showPasswordButton, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        
        p.add(emailLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        
        
        return p;
    }

    public void searchCredentials(String searchStr) {

        mainView.getCredentialView().revalidate();
        mainView.getCredentialView().repaint();
        model.getSearchCredentialList().clear();
        if(!searchStr.trim().isEmpty()) {
            for(int i=0; i<model.getCredentialList().size(); i++) {
                if(model.getCredentialList().get(i).getTitle().contains(searchStr) || model.getCredentialList().get(i).getDescription().contains(searchStr)) {
                    model.getSearchCredentialList().add(model.getCredentialList().get(i));
                    
                }
            }
            addCredentials(model.getSearchCredentialList());
            
        } else {
            addCredentials(model.getCredentialList());
        }
    }
}
