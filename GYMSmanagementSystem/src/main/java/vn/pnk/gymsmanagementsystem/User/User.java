package vn.pnk.gymsmanagementsystem.User;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    
    public User(){
        
    }

    public User (int par, String username, String password, String lastname, String firstname, int id) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    @XmlElement
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @XmlElement
    public String getLastname(){
        return this.lastname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    @XmlElement
    public String getFirstname(){
        return this.firstname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    @XmlElement
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
}
