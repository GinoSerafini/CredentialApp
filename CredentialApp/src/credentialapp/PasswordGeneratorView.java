
package credentialapp;

import javax.swing.*;

/**
 *
 * @author Michael Cavallaro
 */
public class PasswordGeneratorView extends JPanel {
    private MainModel model;
    private JCheckBox eightBox;
    private JCheckBox capitalBox;
    private JCheckBox numberBox;
    private JCheckBox charBox;
    private JButton generatePasswordButton;
    private JButton backButton;
    private JLabel passwordLabel;
    
    public PasswordGeneratorView(MainModel model) {
        super();
        this.model = model;
        
        eightBox = new JCheckBox("Eight Character Minimum");
        capitalBox = new JCheckBox("Must Include Capital Letters");
        numberBox = new JCheckBox("Must Include Numbers");
        charBox = new JCheckBox("Must Include Characters");
        
        passwordLabel = new JLabel("");
        
        generatePasswordButton = new JButton("Generate Password");
        backButton = new JButton("<--");
        
        add(eightBox);
        add(capitalBox);
        add(numberBox);
        add(charBox);
        add(backButton);
        add(generatePasswordButton);
        add(passwordLabel);
    }
    
    public JButton getGeneratePasswordButton() {
        return generatePasswordButton;
    }
    
    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JCheckBox getEightBox() {
        return eightBox;
    }

    public JCheckBox getCapitalBox() {
        return capitalBox;
    }

    public JCheckBox getNumberBox() {
        return numberBox;
    }

    public JCheckBox getCharBox() {
        return charBox;
    }
    
    public JButton getBackButton() {
        return backButton;
    }
}
