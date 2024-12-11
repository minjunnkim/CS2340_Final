package scenario_1;

import java.util.List;
import scenario_3.PaymentStrategy;

public class TutoringServiceListing extends Listing {
    private String description;
    private User seller;

    public TutoringServiceListing(String title, String listingID, double price, String category, String description, User seller, List<PaymentStrategy> paymentMethods) {
        super(title, listingID, price, category, paymentMethods);
        this.description = description;
        this.seller = seller;
    }

    @Override
    public void displayInfo() {
        System.out.println("Tutoring Service Listing: " + getTitle() + " - $" + getPrice());
        System.out.println("Description: " + description);
        System.out.println("Seller: " + seller.getName());
    }
}
