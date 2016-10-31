
package credentialapp;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author Michael Cavallaro
 */
public class MainController {
    private MainModel model;
    private MainView view;
    
    public MainController(MainModel model, MainView view) {
        this.model = model;
        this.view = view;
        
        view.getGeneratePasswordButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setEightCharacterMinimum(view.getEightBox().isSelected());
                model.setIncludeCapitalLetter(view.getCapitalBox().isSelected());
                model.setIncludeNumber(view.getNumberBox().isSelected());
                generatePassword();
            }
        });
        
    }
    
    private void generatePassword() {
        preparePasswordLength();
        int numCaps = getRandomNumber(1,model.getGenPasswordLength());
        int[] capLoc = new int[numCaps];
        model.setGenPassword("");
        for(int i=0; i<model.getGenPasswordLength();i++) {
            model.setGenPassword(model.getGenPassword()+ model.getANUM().charAt(getRandomNumber(0,model.getANUM().length())));
        }
        view.setForeground(Color.red);
        view.getPasswordLabel().setText(model.getGenPassword());
        StringSelection str = new StringSelection(model.getGenPassword());
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        c.setContents(str, null);
    }
    
    private void preparePasswordLength() {
        Random r = new Random();
        if(model.isEightCharacterMinimum()) {
            model.setGenPasswordLength(getRandomNumber(8,25));
        } else {
            model.setGenPasswordLength(getRandomNumber(4,25));
        }
    }
    
    private int getRandomNumber(int min, int max) {
        Random r  = new Random();
        return r.nextInt(max)+min;
    }
    
}
