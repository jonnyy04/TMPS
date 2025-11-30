package chainOfResponsibility;

import java.util.HashMap;
import java.util.Map;

public class TutoringDatabase {
    private Map<String, String> users = new HashMap<>();
    private Map<String, String> roles = new HashMap<>();

    public TutoringDatabase() {
        users.put("student1", "pass123");
        users.put("tutorA", "teachme");
        users.put("admin", "root");

        roles.put("student1", "STUDENT");
        roles.put("tutorA", "TUTOR");
        roles.put("admin", "ADMIN");
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public boolean isPasswordValid(String username, String password) {
        return users.get(username).equals(password);
    }

    public String getRole(String username) {
        return roles.get(username);
    }
}
