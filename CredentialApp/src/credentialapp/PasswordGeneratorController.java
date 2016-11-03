
package credentialapp;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Michael Cavallaro
 */
public class PasswordGeneratorController {
    private PasswordGeneratorModel model;
    private PasswordGeneratorView view;
    
    public PasswordGeneratorController(PasswordGeneratorModel model, PasswordGeneratorView view) {
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
        
        
    }
    
    private void generatePassword() {
        preparePasswordLength();
        model.setGenPassword("");
        
        int numCaps = 0; //number of capital letters that will be in the string
        int numNums = 0; // number of numbers that will be in the string
        int numChars = 0; //number of special characters that will be in the string
        int remLength = 0; //the remaining length that will be
        
        char[] capLoc = new char[model.getGenPasswordLength()]; //parallel array for the location of capital letters
        char[] numLoc = new char[model.getGenPasswordLength()];//parallel array for the location of numbers
        char[] charLoc = new char[model.getGenPasswordLength()];//parallel array for the location of special characters
        
        if(model.isIncludeCapitalLetter()) { // if the password must include a captial letter
            numCaps = calcRemainingRandChars(remLength); 
            remLength-=numCaps;
            for(int i=0; i<numCaps; i++) {
                int loc = getRandomNumber(0,model.getGenPasswordLength()-1);
                if(!compareLocations(numLoc, loc) && !compareLocations(charLoc, loc)) {
                    capLoc[loc] = model.getCapAlpha().charAt(getRandomNumber(0,model.getCapAlpha().length()-1));
                } else {
                    if(i!=0)
                        i--;
                }
            }
        }
        if(model.isIncludeNumber()) {// if the password must include a number
            numNums = calcRemainingRandChars(remLength);
            remLength +=numNums;
            for(int i=0; i<numNums; i++) {
                int loc = getRandomNumber(0,model.getGenPasswordLength()-1);
                if(!compareLocations(capLoc, loc) && !compareLocations(charLoc, loc)) {
                    numLoc[loc] = model.getNumAlpha().charAt(getRandomNumber(0,model.getNumAlpha().length()-1));
                } else {
                    if(i!=0)
                        i--;
                }
            }
        }
        if(model.isIncludeCharacters()) { // if the password must include a special character
            numChars = calcRemainingRandChars(remLength);
            remLength+=numChars;
            for(int i=0; i<numChars; i++) {
                int loc = getRandomNumber(0,model.getGenPasswordLength()-1);
                if(!compareLocations(capLoc,loc) && !compareLocations(numLoc,loc)) {
                    charLoc[loc] = model.getCharAlpha().charAt(getRandomNumber(0,model.getCharAlpha().length()-1));
                } else {
                    if(i!=0)
                        i--;
                }
            }
        }

        for(int i=0; i<model.getGenPasswordLength();i++) {
            if(compareLocations(capLoc, i)) {
                model.setGenPassword(model.getGenPassword()+capLoc[i]);
            } else if(compareLocations(numLoc, i)) {
                model.setGenPassword(model.getGenPassword()+numLoc[i]);
            } else if(compareLocations(charLoc, i)) {
                model.setGenPassword(model.getGenPassword()+charLoc[i]);
            } else {
                model.setGenPassword(model.getGenPassword()+model.getALPHA().charAt(getRandomNumber(0,model.getALPHA().length()-1)));
            }
        }
        
        System.out.println(model.getGenPassword());
        
        view.setForeground(Color.red);
        view.getPasswordLabel().setText(model.getGenPassword());
        view.repaint();
        StringSelection str = new StringSelection(model.getGenPassword());
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        c.setContents(str, null);

    }
    
    private int calcRemainingRandChars(int rem) {
        return getRandomNumber(1,(model.getGenPasswordLength()-rem)-1);
    }
    
    private void preparePasswordLength() {
        if(model.isEightCharacterMinimum()) {
            model.setGenPasswordLength(getRandomNumber(8,25));
            
        } else {
            model.setGenPasswordLength(getRandomNumber(4,25));
        }
    }
    
    private boolean compareLocations(char[] arr1, int loc) {
        return arr1[loc] != 0;
        
    }
    
    private int getRandomNumber(int min, int max) {
        return min+(int)(Math.random()*((max-min) + 1));
    }
    
}