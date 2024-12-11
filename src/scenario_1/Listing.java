package scenario_1;

import java.util.List;

import scenario_3.PaymentStrategy;

public abstract class Listing {
    // Private and Protected Attributes
    private String title;
    private String listingID;
    private double price; // String to store price
    private boolean beenSold;
    private List<PaymentStrategy> paymentMethods;
    private PaymentStrategy currentPaymentMethod;

    // Public Attribute
    public String category;

    // Constructor
    public Listing(String title, String listingID, double price, String category, List<PaymentStrategy> paymentMethods) {
        this.title = title;
        this.listingID = listingID;
        this.price = price;
        this.category = category;
        this.paymentMethods = paymentMethods;
        this.beenSold = false;
        this.currentPaymentMethod = null;
    }

    // Abstract Method
    public abstract void displayInfo();

    // Public Method
    public boolean isAffordable(double budget) {
        return price <= budget;
    }

    // Overloaded Method
    public boolean isAffordable(boolean discountAvailable) {
        return discountAvailable; 
    }

    // Check Availability
    public boolean isAvailable() {
        return !beenSold;
    }

    // Get Price
    public Double getPrice() {
        return price;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getListingID() {
        return listingID;
    }

    public boolean isBeenSold() {
        return beenSold;
    }

    public void setBeenSold(boolean beenSold) {
        this.beenSold = beenSold;
    }

    public List<PaymentStrategy> getPaymentMethods() {
        return paymentMethods;
    }

     public void setPaymentMethod(PaymentStrategy paymentMethod) {
        if (paymentMethods.contains(paymentMethod)) {
            this.currentPaymentMethod = paymentMethod;
        } else {
            throw new IllegalArgumentException("Payment method not accepted for this listing.");
        }
    }

    public boolean pay(String buyer, String seller) {
        if (currentPaymentMethod == null) {
            System.out.println("No payment method selected.");
            return false;
        }
        boolean success = currentPaymentMethod.processPayment(price, buyer, seller);
        if (success) {
            setBeenSold(true);
            System.out.println("Listing has been marked as sold.");
        }
        return success;
    }
}

