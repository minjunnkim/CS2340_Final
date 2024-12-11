package scenario_1;

import java.util.List;

import scenario_3.PaymentStrategy;

public abstract class Listing {
    private String title;
    private String listingID;
    private double price; 
    private boolean beenSold;
    private List<PaymentStrategy> paymentMethods;
    private PaymentStrategy currentPaymentMethod;

    public String category;

    public Listing(String title, String listingID, double price, String category, List<PaymentStrategy> paymentMethods) {
        this.title = title;
        this.listingID = listingID;
        this.price = price;
        this.category = category;
        this.paymentMethods = paymentMethods;
        this.beenSold = false;
        this.currentPaymentMethod = null;
    }

    public abstract void displayInfo();

    public boolean isAffordable(double budget) {
        return price <= budget;
    }

    public boolean isAffordable(boolean discountAvailable) {
        return discountAvailable; 
    }

    public boolean isAvailable() {
        return !beenSold;
    }

    public Double getPrice() {
        return price;
    }

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

    public boolean pay(User buyer, User seller) {
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

