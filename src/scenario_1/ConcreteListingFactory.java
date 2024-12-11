package scenario_1;

import java.util.Arrays;
import scenario_3.*;

public class ConcreteListingFactory implements ListingFactory {
    private final PaymentStrategy creditCard = new CreditCardPayment();
    private final PaymentStrategy venmo = new VenmoPayment();
    private final PaymentStrategy cash = new CashPayment();

    @Override
    public Listing createListing(String type, String title, double price, String category) {
        switch (type.toLowerCase()) {
            case "textbook":
                return new TextbookListing(
                    title,
                    "001",
                    price,
                    category,
                    "978-3-16-148410-0",
                    Arrays.asList(creditCard, venmo)
                );
            case "dormsupplies":
                return new DormSuppliesListing(
                    title,
                    "002",
                    price,
                    category,
                    "Ikea",
                    Arrays.asList(cash, venmo)
                );
            case "tutoring":
                return new TutoringServiceListing(
                    title,
                    "003",
                    price,
                    category,
                    "1-hour tutoring session",
                    new User("John Doe"),
                    Arrays.asList(creditCard, cash)
                );
            default:
                throw new IllegalArgumentException("Unknown listing type: " + type);
        }
    }
}

