package scenario_4;

public interface AuthSystem {
    boolean login(String username, String password);
    boolean register(String username, String password, String role);
}

