
package credentialapp;

import javax.swing.*;

/**
 *
 * @author Michael Cavallaro
 */
public class MainView extends JTabbedPane {
    private MainModel model;
    private ProfileView profileView;
    private ProfileModel profileModel;
    private ProfileController profileController;
    private PasswordGeneratorView passwordGeneratorView;
    private PasswordGeneratorModel passwordGeneratorModel;
    private PasswordGeneratorController passwordGeneratorController;
    
    public MainView(MainModel model) {
        super();
        this.model = model;
        
        profileModel = new ProfileModel(model.getUsername());
        profileView = new ProfileView(profileModel);
        profileController = new ProfileController(profileModel, profileView);
        
        passwordGeneratorModel = new PasswordGeneratorModel();
        passwordGeneratorView = new PasswordGeneratorView(passwordGeneratorModel);
        passwordGeneratorController = new PasswordGeneratorController(passwordGeneratorModel, passwordGeneratorView);
       
        this.addTab("Profile", profileView);
        this.addTab("Generate Password", passwordGeneratorView);
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }
    
    public ProfileController getProfileController() {
        return profileController;
    }
}
