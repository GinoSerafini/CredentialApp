
package credentialapp;

/**
 *
 * @author Michael Cavallaro
 */
public class MainModel {
    private boolean eightCharacterMinimum;
    private boolean includeCapitalLetter;
    private boolean includeNumber;
    private int genPasswordLength;
    private String genPassword;
    private final String ANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\\\|;:\\'\\\",<.>/?\n";
    public MainModel() {
        eightCharacterMinimum = false;
        includeCapitalLetter= false;
        includeNumber = false;
    }

    public int getGenPasswordLength() {
        return genPasswordLength;
    }

    public String getGenPassword() {
        return genPassword;
    }
    
    public boolean isEightCharacterMinimum() {
        return eightCharacterMinimum;
    }

    public boolean isIncludeCapitalLetter() {
        return includeCapitalLetter;
    }

    public boolean isIncludeNumber() {
        return includeNumber;
    }

    public void setEightCharacterMinimum(boolean eightCharacterMinimum) {
        this.eightCharacterMinimum = eightCharacterMinimum;
    }

    public void setIncludeCapitalLetter(boolean includeCapitalLetter) {
        this.includeCapitalLetter = includeCapitalLetter;
    }

    public void setIncludeNumber(boolean includeNumber) {
        this.includeNumber = includeNumber;
    }

    public void setGenPasswordLength(int genPasswordLength) {
        this.genPasswordLength = genPasswordLength;
    }

    public void setGenPassword(String genPassword) {
        this.genPassword = genPassword;
    }

    public String getANUM() {
        return ANUM;
    }
    
    
    
    
}
