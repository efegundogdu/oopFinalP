package oopFinalP;

import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> users = new ArrayList<>();

    public UserManager() {
        // user admin
        users.add(new User("admin", "1234"));
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.login(username, password)) {
                return true;
            }
        }
        return false;
    }
}