package scenario_3;

public interface PaymentStrategy {
    boolean processPayment(double amount, String buyer, String seller);
}
