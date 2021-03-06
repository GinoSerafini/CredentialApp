
package credentialapp;

import java.util.ArrayList;

/**
 *
 * @author Michael Cavallaro
 */
public class ProfileModel {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private ArrayList<Credential> credentialList;
    
    public ProfileModel(String username) {
        this.username=username;
        credentialList = new ArrayList<Credential>();
    }

    public ArrayList<Credential> getCredentialList() {
        return credentialList;
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
    
    
}
