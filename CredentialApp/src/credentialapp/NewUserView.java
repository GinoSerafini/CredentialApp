
package credentialapp;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

/**
 *
 * @author Group 5s
 */
public class NewUserView extends JPanel {
    private NewUserModel model;
    private JLabel newUserLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel confirmLabel;
    private JLabel securityAnswerLabel;
    private JLabel securityQuestionLabel;
    private JLabel outputLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField usernameField;
    private JTextField securityAnswerField;
    private JPasswordField passwordField;
    private JPasswordField confirmField;
    private JComboBox securityQuestionBox;
    private JButton registerButton;
    private JButton backButton;
    
    public NewUserView(NewUserModel model) {
        this.model = model;
        this.setVisible(true);
	setLayout(new GridBagLayout());
	((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
	((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, .0001};
	((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, .0001};
        
        newUserLabel = new JLabel("New User");
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        emailLabel = new JLabel("Email");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        confirmLabel = new JLabel("Confirm:");
        securityQuestionLabel = new JLabel("Security Question:");
        securityAnswerLabel = new JLabel("Security Answer:");
        outputLabel = new JLabel("");
        
        firstNameField = new JTextField(8);
        lastNameField = new JTextField(8);
        emailField = new JTextField(8);
        usernameField = new JTextField(8);
        passwordField = new JPasswordField(8);
        confirmField = new JPasswordField(8);
        securityAnswerField = new JTextField(8);
        String[] questionString = {"What is your pet’s name?","In what year was your father born?","What is your favorite food?"};
        securityQuestionBox = new JComboBox(questionString);
        registerButton = new JButton("Register");
        backButton = new JButton("<--");
        //Set up layout
	add(firstNameLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 5), 0, 0));
	add(firstNameField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 0), 0, 0));

	add(lastNameLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 5), 0, 0));
	add(lastNameField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 0), 0, 0));

        add(emailLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 5), 0, 0));
	add(emailField, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 0), 0, 0));

        add(usernameLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 5), 0, 0));
	add(usernameField, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 0), 0, 0));

        add(passwordLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 5), 0, 0));
	add(passwordField, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 0), 0, 0));

        add(confirmLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 5), 0, 0));
	add(confirmField, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 0), 0, 0));

        add(securityQuestionLabel, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 5), 0, 0));
	add(securityQuestionBox, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 0), 0, 0));

	add(securityAnswerLabel, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
	add(securityAnswerField, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 0), 0, 0));
        
        add(backButton, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
	add(registerButton, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,new Insets(0, 0, 5, 0), 0, 0));
        
        add(outputLabel, new GridBagConstraints(0, 9, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,5,5),0,0));
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getSecurityAnswerField() {
        return securityAnswerField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getConfirmField() {
        return confirmField;
    }

    public JComboBox getSecurityQuestionBox() {
        return securityQuestionBox;
    }
    
    public JButton getRegisterButton() {
        return registerButton;
    }
    
    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getFirstNameLabel() {
        return firstNameLabel;
    }

    public JLabel getLastNameLabel() {
        return lastNameLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JLabel getConfirmLabel() {
        return confirmLabel;
    }

    public JLabel getSecurityAnswerLabel() {
        return securityAnswerLabel;
    }

    public JLabel getSecurityQuestionLabel() {
        return securityQuestionLabel;
    }

    public JLabel getOutputLabel() {
        return outputLabel;
    }
    
    
    
}
