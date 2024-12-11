package scenario_3;

import scenario_1.User;

public class VenmoPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, User buyer, User seller) {
        System.out.println("Processing Venmo payment of $" + amount + " from " + buyer.getName() + " to " + seller.getName());
        return true; 
    }
}

