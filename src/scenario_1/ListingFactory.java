package scenario_1;

public interface ListingFactory {
    Listing createListing(String type, String title, double price, String location);
}
