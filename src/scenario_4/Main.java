package scenario_4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AuthProxy authProxy = new AuthProxy(2); // Max 2 concurrent requests

        // Simulate login and registration requests
        authProxy.login("student1", "valid_password"); // Immediate
        authProxy.login("student2", "invalid_password"); // Immediate
        authProxy.register("student3", "valid_password", "Student"); // Queued
        authProxy.login("student4", "valid_password"); // Queued

        Thread.sleep(5000);
        System.out.println("\nFinalizing all requests...");
    }
}




