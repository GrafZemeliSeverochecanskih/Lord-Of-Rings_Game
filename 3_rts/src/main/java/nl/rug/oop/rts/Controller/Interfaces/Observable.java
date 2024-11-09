package main.java.nl.rug.oop.rts.Controller.Interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Function that implements the Observable logic.
 * Classes with this interface will update the listeners when the change to the observer is made.
 */
public interface Observable {

    /**
     * List of observers for the observable object.
     */
    List<Observer> OBSERVERS = new ArrayList<>();

    /**
     * Adds the observer to the list.
     * @param  observer to add to the observable object.
     */
    default void addObserver(Observer observer) {
        this.OBSERVERS.add(observer);
    }

    /**
     * Notifies the observers of the change.
     */
    default void notifyAllObservers() {
        for (Observer observer : OBSERVERS) {
            observer.triggerUpdate();
        }
    }
}
