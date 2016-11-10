
package credentialapp;

/**
 *
 * @author Michael Cavallaro
 */
public class CredentialController {
    private CredentialModel model;
    private CredentialView view;
    
    public CredentialController(CredentialModel model, CredentialView view) {
        this.model=model;
        this.view =view;
    }
}
