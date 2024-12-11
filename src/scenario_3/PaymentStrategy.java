package scenario_3;

import scenario_1.User;

public interface PaymentStrategy {
    boolean processPayment(double amount, User buyer, User seller);
}
