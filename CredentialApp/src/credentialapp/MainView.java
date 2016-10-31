
package credentialapp;

import javax.swing.*;

/**
 *
 * @author Michael Cavallaro
 */
public class MainView extends JPanel {
    private MainModel model;
    private JCheckBox eightBox;
    private JCheckBox capitalBox;
    private JCheckBox numberBox;
    private JButton generatePasswordButton;
    private JLabel passwordLabel;
    
    public MainView(MainModel model) {
        super();
        this.model = model;
        
        eightBox = new JCheckBox("Eight Character Minimum");
        capitalBox = new JCheckBox("Must Include Capital Letters");
        numberBox = new JCheckBox("Must Include Numbers");
        
        passwordLabel = new JLabel("");
        
        generatePasswordButton = new JButton("Generate Password");
        
        add(eightBox);
        add(capitalBox);
        add(numberBox);
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

    
}
