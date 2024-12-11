package scenario_1;

import scenario_3.*;
import java.util.List;

public class TextbookListing extends Listing {
    private String isbn;

    public TextbookListing(String title, String listingID, double price, String category, String isbn, List<PaymentStrategy> paymentMethods) {
        super(title, listingID, price, category, paymentMethods);
        this.isbn = isbn;
    }

    @Override
    public void displayInfo() {
        System.out.println("Textbook Listing: " + getTitle() + " - $" + getPrice());
        System.out.println("ISBN: " + isbn);
    }
}
