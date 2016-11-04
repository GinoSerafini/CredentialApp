
package credentialapp;

/**
 *
 * @author Group 5
 */
public class LoginModel {

    private String username;
    private String password;

    /**
     * Get the username used to authenticate
     * @return 
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password used to authenticate
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
