
package credentialapp;

/**
 *
 * @author Group 5
 */
public class NewUserModel {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private char[] password;
    private char[] confirmPassword;
    private String securityQuestion;
    private String securityAnswer;
    public NewUserModel() {
        firstName = "";
        lastName = "";
        email = "";
        username ="";
        securityQuestion="";
        securityAnswer="";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }
    public char[] getConfirmPassword() {
        return confirmPassword;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
    
    public void setConfirmPassword(char[] confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
    
    
    
}
