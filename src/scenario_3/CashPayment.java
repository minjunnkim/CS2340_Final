package scenario_3;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, String buyer, String seller) {
        System.out.println("Processing cash payment of $" + amount + " from " + buyer + " to " + seller);
        return true; // Simulate successful payment
    }
}

