
package credentialapp;

import java.util.ArrayList;

/**
 *
 * @author Michael Cavallaro
 */
public class EditCredentialModel {
    private Credential credential;
    
    public EditCredentialModel(Credential c) {
       credential = c;
       
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
    
    
    
}
