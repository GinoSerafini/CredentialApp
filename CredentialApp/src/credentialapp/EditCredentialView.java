
package credentialapp;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Michael Cavallaro
 */
public class EditCredentialView extends JPanel {
    private JLabel titleLabel,descriptionLabel,websiteLabel,passwordLabel,confirmLabel,sqa1Label,sqa2Label,sqa3Label,outputLabel;
    private JCheckBox emailBox,usernameBox,sq1Box,sq2Box,sq3Box;
    private JTextField titleField,descriptionField,websiteField,emailField,usernameField,sq1Field,sq2Field,sq3Field,sqa1Field,sqa2Field,sqa3Field;
    private JPasswordField passwordField, confirmField;
    private JButton cancelButton, saveButton;
    
    JButton showPasswordButton;
    public EditCredentialView(EditCredentialModel model) {
        super();
        this.setVisible(true);
        
        Credential c = model.getCredential();
    
        setLayout(new GridBagLayout());
        
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
	((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0};
	((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
	((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

        cancelButton = new JButton("Cancel");
        saveButton = new JButton("Save");
        outputLabel = new JLabel("");
        
        titleLabel = new JLabel("Title:");
        descriptionLabel = new JLabel("Description:");
        websiteLabel = new JLabel("Website:");
        passwordLabel = new JLabel("Password:");
        confirmLabel = new JLabel("Confirm:");
        outputLabel = new JLabel("");
        titleField = new JTextField(c.getTitle());
        descriptionField = new JTextField(c.getDescription());
        websiteField = new JTextField(c.getWebsite());
        emailField = new JTextField(c.getEmail());
        usernameField = new JTextField(c.getUsername());
        passwordField = new JPasswordField();
        confirmField = new JPasswordField();
        
        emailBox = new JCheckBox("Email:");
        usernameBox = new JCheckBox("Username:");
        sq1Box = new JCheckBox("Security Question 1:");
        sq2Box = new JCheckBox("Security Question 2:");
        sq3Box = new JCheckBox("Security Question 3:");
        usernameBox.setHorizontalTextPosition(SwingConstants.LEFT);
        emailBox.setHorizontalTextPosition(SwingConstants.LEFT);
        sq1Box.setHorizontalTextPosition(SwingConstants.LEFT);
        sq2Box.setHorizontalTextPosition(SwingConstants.LEFT);
        sq3Box.setHorizontalTextPosition(SwingConstants.LEFT);
        
        if(!c.getUsername().isEmpty()) {
            usernameField = new JTextField(c.getUsername());
            usernameBox.setSelected(true);
        } else {
            usernameField = new JTextField(12);
            usernameField.setEnabled(false);
            usernameField.setBackground(Color.GRAY);
            usernameBox.setSelected(false);
        }
        
        if(!c.getEmail().isEmpty()) {
            emailField = new JTextField(c.getEmail());
            emailBox.setSelected(true);
        } else {
            emailField = new JTextField(12);
            emailField.setEnabled(false);
            emailField.setBackground(Color.GRAY);
            emailBox.setSelected(false);
        }
         
        if(!c.getSecurityQuestion1().isEmpty()) {
            sq1Field = new JTextField(c.getSecurityQuestion1());
            sqa1Field = new JTextField(c.getSecurityAnswer1());
            sq1Box.setSelected(true);
        }else {
            sq1Field = new JTextField(12);
            sq1Field.setEnabled(false);
            sq1Field.setBackground(Color.GRAY);
            sqa1Field = new JTextField(12);
            sqa1Field.setEnabled(false);
            sqa1Field.setBackground(Color.GRAY);
            sq1Box.setSelected(false);
        }
        
        if(!c.getSecurityQuestion3().isEmpty()) {
            sq3Field = new JTextField(c.getSecurityQuestion3());
            sqa3Field = new JTextField(c.getSecurityAnswer3());
            sq3Box.setSelected(true);
        }else {
            sq3Box.setSelected(true);
            sq3Field = new JTextField(12);
            sq3Field.setEnabled(false);
            sq3Field.setBackground(Color.GRAY);
            sqa3Field = new JTextField(12);
            sqa3Field.setEnabled(false);
            sqa3Field.setBackground(Color.GRAY);
            sq3Box.setSelected(false);
        }
        
        if(!c.getSecurityQuestion2().isEmpty()) {
            sq2Field = new JTextField(c.getSecurityQuestion2());
            sqa2Field = new JTextField(c.getSecurityAnswer2());
            sq2Box.setSelected(true);
        }else {
            sq2Field = new JTextField(12);
            sq2Field.setEnabled(false);
            sq2Field.setBackground(Color.GRAY);
            sqa2Field = new JTextField(12);
            sqa2Field.setEnabled(false);
            sqa2Field.setBackground(Color.GRAY);
            sq2Box.setSelected(false);
        }
        if(c.getEmail().isEmpty())
            emailBox.setSelected(false);

        if(c.getUsername().isEmpty())
            usernameBox.setSelected(false);
        
        sqa1Label = new JLabel("Security Answer 1:");
        sqa2Label = new JLabel("Security Answer 2:");
        sqa3Label = new JLabel("Security Answer 3:");
      
        
	add(titleLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 5, 5), 0, 0));
	add(titleField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 0), 0, 0));

	add(descriptionLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 5), 0, 0));
	add(descriptionField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(websiteLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 5), 0, 0));
	add(websiteField, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(emailBox, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 5), 0, 0));
	add(emailField, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(usernameBox, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 5), 0, 0));
	add(usernameField, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(passwordLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 5), 0, 0));
	add(passwordField, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(confirmLabel, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 5), 0, 0));
	add(confirmField, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(sq1Box, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 0), 0, 0));
        add(sq1Field, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(sqa1Label, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 0), 0, 0));
        add(sqa1Field, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(sq2Box, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 0), 0, 0));
        add(sq2Field, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(sqa2Label, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 0), 0, 0));
        add(sqa2Field, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(sq3Box, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 0), 0, 0));
        add(sq3Field, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        
        add(sqa3Label, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 0), 0, 0));
        add(sqa3Field, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        add(cancelButton, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0,
		GridBagConstraints.EAST, GridBagConstraints.EAST,
		new Insets(0, 0, 0, 0), 0, 0));
        add(saveButton, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 0), 0, 0));
        add(outputLabel, new GridBagConstraints(0, 14, 2, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.CENTER,
		new Insets(0, 0, 0, 0), 0, 0));
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public JLabel getWebsiteLabel() {
        return websiteLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JLabel getConfirmLabel() {
        return confirmLabel;
    }

    public JLabel getSqa1Label() {
        return sqa1Label;
    }

    public JLabel getSqa2Label() {
        return sqa2Label;
    }

    public JLabel getSqa3Label() {
        return sqa3Label;
    }

    public JCheckBox getEmailBox() {
        return emailBox;
    }

    public JCheckBox getUsernameBox() {
        return usernameBox;
    }

    public JCheckBox getSq1Box() {
        return sq1Box;
    }

    public JCheckBox getSq2Box() {
        return sq2Box;
    }

    public JCheckBox getSq3Box() {
        return sq3Box;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getDescriptionField() {
        return descriptionField;
    }

    public JTextField getWebsiteField() {
        return websiteField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getSq1Field() {
        return sq1Field;
    }

    public JTextField getSq2Field() {
        return sq2Field;
    }

    public JTextField getSq3Field() {
        return sq3Field;
    }

    public JTextField getSqa1Field() {
        return sqa1Field;
    }

    public JTextField getSqa2Field() {
        return sqa2Field;
    }

    public JTextField getSqa3Field() {
        return sqa3Field;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getConfirmField() {
        return confirmField;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JLabel getOutputLabel() {
        return outputLabel;
    }
    
    
    
}
    
