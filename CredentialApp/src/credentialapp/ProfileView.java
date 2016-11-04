
package credentialapp;

import javax.swing.*;

/**
 *
 * @author Michael Cavallaro
 */
public class ProfileView extends JPanel {
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JButton addCredentialButton;
    private ProfileModel model;
    
    public ProfileView(ProfileModel model) {
        this.model = model;
        nameLabel = new JLabel();
        emailLabel = new JLabel();
        
        addCredentialButton = new JButton("Add Credential");
        add(nameLabel);
        add(emailLabel);
        add(addCredentialButton); 
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JButton getAddCredentialButton() {
        return addCredentialButton;
    }
    
    
}
