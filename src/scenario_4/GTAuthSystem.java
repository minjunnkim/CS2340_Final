package scenario_4;

public class GTAuthSystem implements AuthSystem {
    @Override
    public boolean login(String username, String password) {
        System.out.println("Authenticating user: " + username);
        return "valid_password".equals(password);
    }

    @Override
    public boolean register(String username, String password, String role) {
        System.out.println("Registering user: " + username + " as " + role);
        return true;
    }
}

