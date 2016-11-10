
package credentialapp;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

        for(int i=0; i<model.getCredentialList().size();i++) {
            JPanel p = createCredentialPanel(i);
            view.add(p);
        }
    }
    
    private JPanel createCredentialPanel(int i) {
        JPanel p = new JPanel();
        JLabel titleLabel = new JLabel(model.getCredentialList().get(i).getTitle());
        JLabel descLabel = new JLabel(model.getCredentialList().get(i).getDescription());
        JLabel websiteLabel = new JLabel(model.getCredentialList().get(i).getWebsite());
        JLabel emailLabel = new JLabel(model.getCredentialList().get(i).getEmail());
        JLabel usernameLabel = new JLabel(model.getCredentialList().get(i).getUsername());
        JLabel passwordLabel = new JLabel(model.getCredentialList().get(i).getUsername());
        
	p.setLayout(new GridBagLayout());
	((GridBagLayout)p.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
	((GridBagLayout)p.getLayout()).rowHeights = new int[] {0, 0, 0};
	((GridBagLayout)p.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
	((GridBagLayout)p.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

        titleLabel.setFont(new Font("ARIAL", Font.BOLD, 32));
	p.add(titleLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 5), 0, 0));

        descLabel.setFont(new Font("ARIAL", Font.PLAIN,26));
        p.add(descLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 5), 0, 0));
        
        websiteLabel.setFont(new Font("ARIAL", Font.PLAIN,24));
	p.add(websiteLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 0), 0, 0));
        
        
	p.add(usernameLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        p.add(passwordLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        p.add(emailLabel, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        
        return p;
    }
}
