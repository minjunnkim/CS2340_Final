package scenario_3;

import scenario_1.*;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, User buyer, User seller) {
        System.out.println("Processing cash payment of $" + amount + " from " + buyer.getName() + " to " + seller.getName());
        return true; 
    }
}

