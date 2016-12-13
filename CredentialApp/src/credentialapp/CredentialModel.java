
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
    private ArrayList<Credential> searchCredentialList;
    
    public CredentialModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
        credentialList = profileModel.getCredentialList();
        searchCredentialList = new ArrayList();
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public ArrayList<Credential> getCredentialList() {
        return credentialList;
    }

    public ArrayList<Credential> getSearchCredentialList() {
        return searchCredentialList;
    }
    
}
