package vn.pnk.gymsmanagementsystem.User;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserXMLHandler {
    private static final String FILE_PATH = "Users.xml";
    
    public static void registerUser(String username, String password, String lastname, String firstname) throws JAXBException {
        try {
            Users users = loadUserFromFile();
            List<User> userList = users.getUserList();

            if (userList == null) {
                userList = new ArrayList<>();
            }

            if (isUsernameTaken(username)) {
                throw new IllegalArgumentException("Username already exists.");
            }

            int newId = generateUserId(userList);            
            
            User newUser = new User(userList.size() + 1, username, password, lastname, firstname, newId);
            userList.add(newUser);
            users.setUserList(userList);

            saveUsersToFile(users);
        } catch (Exception e) {
            System.err.println("Error during registration: " + e.getMessage());
            throw e; 
        }
    }

    private static int generateUserId(List<User> userList){
        return userList.size() + 1;
    }
    
    public static boolean isUsernameTaken(String username) throws JAXBException {
        Users users = loadUserFromFile();
        List<User> loadedUserList = users.getUserList(); 
        if (loadedUserList != null) {
            for (User user : loadedUserList) {
                if (user.getUsername().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Users loadUserFromFile() throws JAXBException {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                Users users = new Users();
                users.setUserList(new ArrayList<>()); 
                saveUsersToFile(users); 
                return users;
            }

            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(file);

            if (users.getUserList() == null) {
                users.setUserList(new ArrayList<>());
            }

            return users;
        } catch (JAXBException e) {
            System.err.println("Error loading users from XML: " + e.getMessage());
            throw e;
        }
    }

    public static void saveUsersToFile(Users users) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, new File(FILE_PATH));
        } catch (JAXBException e) {
            System.err.println("Error saving users to file: " + e.getMessage());
            throw e;
        }
    }

    public static boolean validateLogin(String username, String password) throws JAXBException {
        try {
            Users users = loadUserFromFile();
            List<User> loadedUserList = users.getUserList(); 

            for (User user : loadedUserList) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (JAXBException e) {
            System.err.println("Error during login validation: " + e.getMessage());
            throw e;
        }
        return false;
    }
}
