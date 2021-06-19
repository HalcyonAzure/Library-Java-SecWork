package top.halc.demo.booklib.Classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    User() {

    }

    User(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    private String name;
    private String password;

    private static String adminName = "admin";
    private static String adminPassword = "admin";

    public boolean checkAdmin() {
        if (this.getName().equals(adminName) && this.getPassword().equals(adminPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
