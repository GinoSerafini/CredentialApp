
package credentialapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Michael Cavallaro
 */
public class NewCredentialController {
    private NewCredentialModel model;
    private NewCredentialView view;
    public NewCredentialController(NewCredentialModel model, NewCredentialView view, MainView mainView) {
        this.model = model;
        this.view = view;
        view.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setTitle(view.getTitleField().getText());
                model.setDescription(view.getDescriptionField().getText());
                model.setEmail(view.getEmailField().getText());
                model.setWebsite(view.getWebsiteField().getText());
                model.setUsername(view.getUsernameField().getText());
                model.setPassword(new String(view.getPasswordField().getPassword()));
                model.setConfirmPassword(new String(view.getConfirmField().getPassword()));
            
            }   
        });
        
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==view.getBackButton()) {
                    view.setVisible(false);
                    mainView.setVisible(true);
                    SwingUtilities.getWindowAncestor(view).setSize(250,300);
                }
            
            }
        });
        
    }
    
    
}
