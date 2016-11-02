
package credentialapp;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                model.setIncludeCharacters(view.getCharBox().isSelected());
                generatePassword();
            }
        });
        
        view.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //nothing yet
                //will return to main menu
            }
        });
        
    }
    
    private void generatePassword() {
        preparePasswordLength();
        model.setGenPassword("");
        int numCaps = getRandomNumber(1,model.getGenPasswordLength());
        int numNums = getRandomNumber(1,model.getGenPasswordLength()-numCaps);
        int numChars = getRandomNumber(1,model.getGenPasswordLength()-(numCaps+numNums));
        
        char[] capLoc = new char[model.getGenPasswordLength()];
        char[] numLoc = new char[model.getGenPasswordLength()];
        char[] charLoc = new char[model.getGenPasswordLength()];
        
        if(model.isIncludeCapitalLetter()) {
            for(int i=0; i<numCaps; i++) {
                int loc = getRandomNumber(0,model.getGenPasswordLength());
                capLoc[loc] = model.getCapAlpha().charAt(getRandomNumber(0,model.getCapAlpha().length()));
            }
        }
        System.out.println(capLoc);
        if(model.isIncludeNumber()) {
            for(int i=0; i<numNums; i++) {
                int loc = getRandomNumber(0,model.getGenPasswordLength());
                if(!compareLocations(capLoc, loc)) {
                    numLoc[loc] = model.getNumAlpha().charAt(getRandomNumber(0,model.getNumAlpha().length()));
                } else {
                    if(i!=0)
                        i--;
                }
            }
        }
        System.out.println(numLoc);
        if(model.isIncludeCharacters()) {
            for(int i=0; i<numChars; i++) {
                int loc = getRandomNumber(0,model.getGenPasswordLength());
                if(!compareLocations(capLoc,loc) && !compareLocations(numLoc,loc)) {
                    charLoc[loc] = model.getCharAlpha().charAt(getRandomNumber(0,model.getCharAlpha().length()));
                } else {
                    if(i!=0)
                        i--;
                }
            }
        }
        System.out.println(charLoc);
        for(int i=0; i<model.getGenPasswordLength();i++) {
            if(!compareLocations(capLoc, i)) {
                model.setGenPassword(model.getGenPassword()+capLoc[i]);
            } else if(!compareLocations(numLoc, i)) {
                model.setGenPassword(model.getGenPassword()+numLoc[i]);
            } else if(!compareLocations(charLoc, i)) {
                model.setGenPassword(model.getGenPassword()+charLoc[i]);
            } else {
                model.setGenPassword(model.getGenPassword()+model.getALPHA().charAt(getRandomNumber(0,model.getALPHA().length())));
            }
        }
        
        view.setForeground(Color.red);
        view.getPasswordLabel().setText(model.getGenPassword());
        view.repaint();
        StringSelection str = new StringSelection(model.getGenPassword());
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        c.setContents(str, null);

    }
    
    private void preparePasswordLength() {
        if(model.isEightCharacterMinimum()) {
            model.setGenPasswordLength(getRandomNumber(8,25));
        } else {
            model.setGenPasswordLength(getRandomNumber(4,25));
        }
    }
    
    private boolean compareLocations(char[] arr1, int loc) {
        if(arr1[loc] == 0) {
            return false;
        }else {
            return true;
        }
        
    }
    
    private int getRandomNumber(int min, int max) {
        return min + (int)(Math.random() * max); 
    }
    
}
