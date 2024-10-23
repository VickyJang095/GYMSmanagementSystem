/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.pnk.gymsmanagementsystem.User;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 * @author Administrator
 */
@XmlRootElement(name = "users")
public class UserListWrapper {
    
    private List<User> users;
    
    @XmlElement(name = "user")
    public List<User> getUsers(){
        return users;
    }
    
    public void setUsers(List<User> users){
        this.users = users;
    }
}
