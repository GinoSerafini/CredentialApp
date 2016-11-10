
package credentialapp;

/**
 *
 * @author Group 5
 */
public class Credential {
    private String title, description, website, email, username, password, securityQuestion1, securityQuestion2,securityQuestion3,securityAnswer1,securityAnswer2,securityAnswer3;

    public Credential(String title, String description, String website, String email, String username, String password, String securityQuestion1, String securityQuestion2, String securityQuestion3, String securityAnswer1, String securityAnswer2, String securityAnswer3) {
        this.title = title;
        this.description = description;
        this.website = website;
        this.email = email;
        this.username = username;
        this.password = password;
        this.securityQuestion1 = securityQuestion1;
        this.securityQuestion2 = securityQuestion2;
        this.securityQuestion3 = securityQuestion3;
        this.securityAnswer1 = securityAnswer1;
        this.securityAnswer2 = securityAnswer2;
        this.securityAnswer3 = securityAnswer3;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public String getSecurityQuestion3() {
        return securityQuestion3;
    }

    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    public String getSecurityAnswer2() {
        return securityAnswer2;
    }

    public String getSecurityAnswer3() {
        return securityAnswer3;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public void setSecurityQuestion3(String securityQuestion3) {
        this.securityQuestion3 = securityQuestion3;
    }

    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }

    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }

    public void setSecurityAnswer3(String securityAnswer3) {
        this.securityAnswer3 = securityAnswer3;
    }
    
    
}
