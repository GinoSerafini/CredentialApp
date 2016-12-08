
package credentialapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Michael Cavallaro
 */
public class EditCredentialController {

    public EditCredentialController(EditCredentialModel model, EditCredentialView view) {
        view.getShowPasswordButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getShowPasswordButton().getText().equals("Show")){
                    view.getPasswordLabel().setText("Password: "+ new String(model.getCredential().getPassword()));
                    view.getShowPasswordButton().setText("Hide");
                } else {
                    view.getPasswordLabel().setText("Password: *****");
                    view.getShowPasswordButton().setText("Show");
                }
            }
        });
    }
    
    
}
