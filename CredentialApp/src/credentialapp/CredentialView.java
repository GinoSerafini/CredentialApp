
package credentialapp;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Michael Cavallaro
 */
public class CredentialView extends JScrollPane {
    private CredentialModel model;
    
    public CredentialView(CredentialModel model) {
        this.setLayout(new ScrollPaneLayout());
        this.model = model;
        
    }
    public ProfileModel getProfileModel() {
        return model.getProfileModel();
    }
}
