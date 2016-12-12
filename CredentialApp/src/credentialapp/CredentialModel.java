
package credentialapp;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Michael Cavallaro
 */
public class CredentialModel {
    private ProfileModel profileModel;
    private ArrayList<Credential> credentialList;
    private ArrayList<JPanel> credentialPanelList;
    
    public CredentialModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
        credentialList = profileModel.getCredentialList();
        credentialPanelList = new ArrayList();
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public ArrayList<Credential> getCredentialList() {
        return credentialList;
    }

    public ArrayList<JPanel> getCredentialPanelList() {
        return credentialPanelList;
    }
    
}
