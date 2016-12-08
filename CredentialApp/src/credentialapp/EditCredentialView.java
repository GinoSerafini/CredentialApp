
package credentialapp;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Michael Cavallaro
 */
public class EditCredentialView extends JPanel {
    JLabel titleLabel;
    JLabel descLabel;
    JLabel websiteLabel;
    JLabel emailLabel;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JButton showPasswordButton;
    public EditCredentialView(EditCredentialModel model) {
        Credential c = model.getCredential();
        titleLabel = new JLabel(c.getTitle());
        descLabel = new JLabel(c.getDescription());
        websiteLabel = new JLabel(c.getWebsite());
        emailLabel =new JLabel(c.getEmail());
        usernameLabel = new JLabel(c.getUsername());
        passwordLabel = new JLabel("Password: ******");
        showPasswordButton = new JButton("Show");
        
	this.setLayout(new GridBagLayout());
	((GridBagLayout)this.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
	((GridBagLayout)this.getLayout()).rowHeights = new int[] {0, 0, 0};
	((GridBagLayout)this.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
	((GridBagLayout)this.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

        titleLabel.setFont(new Font("ARIAL", Font.BOLD, 24));
	this.add(titleLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 5), 0, 0));
        descLabel.setFont(new Font("ARIAL", Font.PLAIN,18));
        this.add(descLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 5), 0, 0));
        
        websiteLabel.setFont(new Font("ARIAL", Font.PLAIN,16));
	this.add(websiteLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 0), 0, 0));
        this.add(emailLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
	this.add(usernameLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        this.add(passwordLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        this.add(showPasswordButton, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
    }

    public JButton getShowPasswordButton() {
        return showPasswordButton;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    
    
    
}
