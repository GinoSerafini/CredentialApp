
package credentialapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

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

        if(!model.getCredentialList().isEmpty()) {
            JPanel mainPanel = new JPanel(new FlowLayout());
            for(int i=0; i<model.getCredentialList().size();i++) {
                JPanel p = createCredentialPanel(i);
                p.setName(""+i);
                p.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Component panel = (Component)e.getSource();
                        EditCredentialModel ecModel = new EditCredentialModel(model.getCredentialList().get(Integer.parseInt(panel.getName())));
                        EditCredentialView ecView = new EditCredentialView(ecModel);
                        EditCredentialController ecCont = new EditCredentialController(ecModel, ecView);
                        JOptionPane.showConfirmDialog(null,ecView,"View Credential",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }

                });
                p.setBorder(BorderFactory.createLineBorder(Color.black));
                p.setPreferredSize(new Dimension(220,110));
                p.setVisible(true);
                mainPanel.add(p);
            }
            view.setViewportView(mainPanel);
        } else {
            JLabel noCredentialsLabel = new JLabel("No credentials found.");
            view.setViewportView(noCredentialsLabel);
        }
    }
    
    public JPanel createCredentialPanel(int i) {
        JPanel p = new JPanel();
        JLabel titleLabel = new JLabel(model.getCredentialList().get(i).getTitle());
        JLabel descLabel = new JLabel(model.getCredentialList().get(i).getDescription());
        JLabel websiteLabel = new JLabel(model.getCredentialList().get(i).getWebsite());
        JLabel emailLabel;
        JLabel usernameLabel;
        if(!model.getCredentialList().get(i).getEmail().equals(""))
            emailLabel = new JLabel("Email: "+model.getCredentialList().get(i).getEmail());
        else
            emailLabel = new JLabel("");
        if(!model.getCredentialList().get(i).getUsername().equals(""))
            usernameLabel = new JLabel("Username: "+model.getCredentialList().get(i).getUsername());
        else
            usernameLabel = new JLabel("");
        JLabel passwordLabel = new JLabel("Password: ******");
        
	p.setLayout(new GridBagLayout());
	((GridBagLayout)p.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
	((GridBagLayout)p.getLayout()).rowHeights = new int[] {0, 0, 0};
	((GridBagLayout)p.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
	((GridBagLayout)p.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

        titleLabel.setFont(new Font("ARIAL", Font.BOLD, 24));
	p.add(titleLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 5), 0, 0));
        descLabel.setFont(new Font("ARIAL", Font.PLAIN,18));
        p.add(descLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 0, 5), 0, 0));
        
        websiteLabel.setFont(new Font("ARIAL", Font.PLAIN,16));
	p.add(websiteLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH,
		new Insets(0, 0, 5, 0), 0, 0));
        
        
	p.add(usernameLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        p.add(passwordLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        p.add(emailLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        
        return p;
    }
}
