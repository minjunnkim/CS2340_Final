package scenario_1;

import scenario_3.*;
import java.util.List;

public class DormSuppliesListing extends Listing {
    private String brand;

    public DormSuppliesListing(String title, String listingID, double price, String category, String brand, List<PaymentStrategy> paymentMethods) {
        super(title, listingID, price, category, paymentMethods);
        this.brand = brand;
    }

    @Override
    public void displayInfo() {
        System.out.println("Dorm Supplies Listing: " + getTitle() + " - $" + getPrice());
        System.out.println("Brand: " + brand);
    }
}
