package scenario_4;

import java.util.LinkedList;
import java.util.Queue;

public class AuthProxy implements AuthSystem {
    private final GTAuthSystem authSystem;
    private final int MAX_REQUESTS;
    private int currentRequests;
    private final Queue<Runnable> requestQueue;

    public AuthProxy(int maxRequests) {
        this.authSystem = new GTAuthSystem();
        this.MAX_REQUESTS = maxRequests;
        this.currentRequests = 0;
        this.requestQueue = new LinkedList<>();
    }

    @Override
    public synchronized boolean login(String username, String password) {
        Runnable loginTask = () -> {
            System.out.println("Processing login request for: " + username);
            boolean success = authSystem.login(username, password);
            System.out.println("Login result for " + username + ": " + success);
        };
        return handleRequest(loginTask, "Login request queued for: " + username);
    }

    @Override
    public synchronized boolean register(String username, String password, String role) {
        Runnable registerTask = () -> {
            System.out.println("Processing registration request for: " + username);
            boolean success = authSystem.register(username, password, role);
            System.out.println("Registration result for " + username + ": " + success);
        };
        return handleRequest(registerTask, "Registration request queued for: " + username);
    }

    private boolean handleRequest(Runnable task, String queueMessage) {
        if (canProcessRequest()) {
            processRequest(task);
            return true;
        } else {
            queueRequest(task, queueMessage);
            return false;
        }
    }

    private boolean canProcessRequest() {
        return currentRequests < MAX_REQUESTS;
    }

    private synchronized void processRequest(Runnable request) {
        startRequest();
        new Thread(() -> {
            try {
                request.run();
            } finally {
                finishRequest();
            }
        }).start();
    }

    private synchronized void startRequest() {
        currentRequests++;
    }

    private synchronized void finishRequest() {
        currentRequests--;
        processQueuedRequests();
    }

    private synchronized void queueRequest(Runnable request, String message) {
        if (!requestQueue.contains(request)) { // Ensure no duplicate tasks are added
            requestQueue.add(request);
            System.out.println(message);
        }
    }

    private synchronized void processQueuedRequests() {
        while (!requestQueue.isEmpty() && canProcessRequest()) {
            Runnable request = requestQueue.poll();
            processRequest(request);
        }
    }
}
