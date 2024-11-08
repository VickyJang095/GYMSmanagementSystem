package vn.pnk.gymsmanagementsystem.User;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
public class Users {
    private List<User> userList;

    @XmlElement(name = "user")
    public List<User> getUserList() {
        if (userList == null) {
            userList = new ArrayList<>(); 
        }
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        if (userList == null) {
            userList = new ArrayList<>();
        }
        userList.add(user);
    }
}


