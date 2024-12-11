package scenario_2;

import scenario_1.Listing;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Listing listing);
}

