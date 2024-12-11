package scenario_3;

public class VenmoPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, String buyer, String seller) {
        System.out.println("Processing Venmo payment of $" + amount + " from " + buyer + " to " + seller);
        return true; 
    }
}

