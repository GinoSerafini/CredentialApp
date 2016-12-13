
package credentialapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import org.jdesktop.xswingx.PromptSupport;
import org.jdesktop.xswingx.PromptSupport.FocusBehavior;

/**
 *
 * @author Group 5
 */
public class MainView extends JPanel {
    private MainModel model;
    private ProfileView profileView;
    private ProfileModel profileModel;
    private ProfileController profileController;
    private CredentialModel credModel;
    private CredentialView credView;
    private CredentialController credController;
    private PasswordGeneratorView passwordGeneratorView;
    private PasswordGeneratorModel passwordGeneratorModel;
    private PasswordGeneratorController passwordGeneratorController;
    private JTextField searchField;
    private JLabel searchLabel, outputLabel;
    private JTabbedPane tabbedPanel;
    
    public MainView(MainModel model) {
        super();
        this.model = model;
        this.setLayout(new BorderLayout());
        tabbedPanel = new JTabbedPane();
        searchField = new JTextField(10);
        PromptSupport.setPrompt("Search", searchField);
        PromptSupport.setFocusBehavior(FocusBehavior.SHOW_PROMPT, searchField);
        
        
        outputLabel = new JLabel("");
        profileModel = new ProfileModel(model.getUsername());
        profileView = new ProfileView(profileModel);
        profileController = new ProfileController(profileModel, profileView);
        
        passwordGeneratorModel = new PasswordGeneratorModel();
        passwordGeneratorView = new PasswordGeneratorView(passwordGeneratorModel);
        passwordGeneratorController = new PasswordGeneratorController(passwordGeneratorModel, passwordGeneratorView, this);
       
        credModel = new CredentialModel(profileModel);
        credView = new CredentialView(credModel);
        credController = new CredentialController(credModel, credView,this);
        
        tabbedPanel.addTab("Generate Password", passwordGeneratorView);
        tabbedPanel.addTab("Profile", profileView);
        tabbedPanel.addTab("Credentials", credView);
        tabbedPanel.setSelectedIndex(1);
        
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                tabbedPanel.setSelectedIndex(2);
                credController.searchCredentials(searchField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tabbedPanel.setSelectedIndex(2);
                credController.searchCredentials(searchField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        
        });
        
        
        this.add(searchField,BorderLayout.NORTH);
        this.add(tabbedPanel,BorderLayout.CENTER);
        this.add(outputLabel,BorderLayout.SOUTH);
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }
    
    public ProfileController getProfileController() {
        return profileController;
    }
    
    public CredentialController getCredentialController() {
        return credController;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public CredentialView getCredentialView() {
        return credView;
    }

    public JLabel getOutputLabel() {
        return outputLabel;
    }

    public JTabbedPane getTabbedPanel() {
        return tabbedPanel;
    }
    
}
