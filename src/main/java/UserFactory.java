package main.java;

public class UserFactory {
    public static User createUser(String type) {
        if (type.equals("admin")) {
            // if type is "admin", instantiate Administrator
            return new Administrator();
        } else if (type.equals("director")) {
            // if type is "director", instantiate Directors
            return new Directors();
        } else {
            // instantiate Staff
            return new Staff();
        }
    }
}

