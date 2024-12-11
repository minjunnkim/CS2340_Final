package scenario_2;

import scenario_1.Listing;
import java.util.ArrayList;
import java.util.List;

public class Marketplace implements Subject {
    private List<Observer> observers;
    private List<Listing> listings;

    public Marketplace() {
        this.observers = new ArrayList<>();
        this.listings = new ArrayList<>();
    }

    // Register an observer
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove an observer
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers of a new listing
    @Override
    public void notifyObservers(Listing listing) {
        for (Observer observer : observers) {
            observer.update(listing);
        }
    }

    // Add a new listing
    public void addListing(Listing listing) {
        listings.add(listing);
        notifyObservers(listing); // Notify all observers
    }
}
