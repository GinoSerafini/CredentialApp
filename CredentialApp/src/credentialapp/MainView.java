
package credentialapp;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author Group 5
 */
public class MainView extends JTabbedPane {
    private MainModel model;
    private ProfileView profileView;
    private ProfileModel profileModel;
    private ProfileController profileController;
    private CredentialModel credModel;
    private CredentialView credView;
    private CredentialController credController;
    private PasswordGeneratorView passwordGeneratorView;
    private PasswordGeneratorModel passwordGeneratorModel;
    private PasswordGeneratorController passwordGeneratorController;
    private JTextField searchField;
    private JLabel searchLabel;
    public MainView(MainModel model) {
        super();
        this.model = model;
        
        searchField = new JTextField(10);
        searchField.setHorizontalAlignment(JTextField.LEFT);
        searchLabel = new JLabel("Search:");
        
        profileModel = new ProfileModel(model.getUsername());
        profileView = new ProfileView(profileModel);
        profileController = new ProfileController(profileModel, profileView);
        
        passwordGeneratorModel = new PasswordGeneratorModel();
        passwordGeneratorView = new PasswordGeneratorView(passwordGeneratorModel);
        passwordGeneratorController = new PasswordGeneratorController(passwordGeneratorModel, passwordGeneratorView);
       
        credModel = new CredentialModel(profileModel);
        credView = new CredentialView(credModel);
        credController = new CredentialController(credModel, credView,this);
        
        this.addTab("Generate Password", passwordGeneratorView);
        this.addTab("Profile", profileView);
        this.addTab("Credentials", credView);
        this.setSelectedIndex(1);
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }
    
    public ProfileController getProfileController() {
        return profileController;
    }
    
    public CredentialController getCredentialController() {
        return credController;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public CredentialView getCredentialView() {
        return credView;
    }
    
}
