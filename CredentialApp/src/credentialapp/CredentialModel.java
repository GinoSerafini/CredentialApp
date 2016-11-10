
package credentialapp;

import java.util.ArrayList;

/**
 *
 * @author Michael Cavallaro
 */
public class CredentialModel {
    private ProfileModel profileModel;
    private ArrayList<Credential> credentialList;
    
    public CredentialModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
        credentialList = profileModel.getCredentialList();
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public ArrayList<Credential> getCredentialList() {
        return credentialList;
    }
    
    
}
