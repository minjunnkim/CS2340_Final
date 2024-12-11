package scenario_2;

import scenario_1.User;
import scenario_1.Listing;

public class NotificationPreference implements Observer {
    private String category;
    private double maxPrice;
    private User user;

    public NotificationPreference(String category, double maxPrice, User user) {
        this.category = category;
        this.maxPrice = maxPrice;
        this.user = user;
    }

    @Override
    public void update(Listing listing) {
        if (listing.category.equals(category) && listing.isAffordable(maxPrice)) {
            System.out.println("Notification for " + user.getName() + ": A new " + category + " listing is available for $" + listing.getPrice());
        }
    }
}

