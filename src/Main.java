
import scenario_1.*;
import scenario_3.*;

public class Main {
    public static void main(String[] args) {
        // Create factory
        ListingFactory factory = new ConcreteListingFactory();

        // Create listings
        Listing textbookListing = factory.createListing("textbook", "Calculus 101", 40.0, "Textbook");
        Listing dormSuppliesListing = factory.createListing("dormsupplies", "Mini Fridge", 120.0, "Dorm Supplies");
        Listing tutoringListing = factory.createListing("tutoring", "Math Tutoring", 30.0, "Tutoring Service");

        // Display listing details
        System.out.println("=== Listings ===");
        textbookListing.displayInfo();
        System.out.println("Available Payment Methods: " + getPaymentMethodNames(textbookListing));

        dormSuppliesListing.displayInfo();
        System.out.println("Available Payment Methods: " + getPaymentMethodNames(dormSuppliesListing));

        tutoringListing.displayInfo();
        System.out.println("Available Payment Methods: " + getPaymentMethodNames(tutoringListing));

        User Alice = new User("Alice");
        User Bob = new User("Bob");
        User Charlie = new User("Charlie");
        User David = new User("David");
        User Eve = new User("Eve");
        User John = new User("John Doe");

        // Process payment for textbook
        System.out.println("\nProcessing Payment for Textbook:");
        textbookListing.setPaymentMethod(textbookListing.getPaymentMethods().get(0)); // CreditCardPayment
        textbookListing.pay(Alice, Bob);

        // Process payment for dorm supplies
        System.out.println("\nProcessing Payment for Dorm Supplies:");
        dormSuppliesListing.setPaymentMethod(dormSuppliesListing.getPaymentMethods().get(1)); // VenmoPayment
        dormSuppliesListing.pay(Charlie, David);

        // Process payment for tutoring
        System.out.println("\nProcessing Payment for Tutoring Service:");
        tutoringListing.setPaymentMethod(tutoringListing.getPaymentMethods().get(1)); // CashPayment
        tutoringListing.pay(Eve, John);
    }

    private static String getPaymentMethodNames(Listing listing) {
        StringBuilder paymentMethods = new StringBuilder();
        for (PaymentStrategy method : listing.getPaymentMethods()) {
            paymentMethods.append(method.getClass().getSimpleName()).append(", ");
        }
        return paymentMethods.toString().replaceAll(", $", "");
    }
}
