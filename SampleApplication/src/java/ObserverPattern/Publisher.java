package ObserverPattern;

import Interfaces.ISubject;
import java.util.LinkedList;
import Interfaces.IObserverable;

/**
 *
 * @author Md. Alim Ul Karim
 * Subject is the publisher.
 * Keeps track of every observer or subscribers and  updates those as per necessary.
 */
public class Publisher implements ISubject{
    
    /**
     * List of subscribers or observers which will listen or read
     */
    private LinkedList<IObserverable> observers = new LinkedList<>();
    
    /**
     *
     * @param newObserver
     * Register or add new observer to the observer list.
     */
    @Override
    public void register(IObserverable newObserver) {
        observers.add(newObserver);
    }
    
    /**
     *
     * @param registeredObserver
     * Removes the listener from the list.
     */
    @Override
    public void unregister(IObserverable registeredObserver) {
        observers.remove(registeredObserver);
    }        

    
    /**
     * On any change update all the observers about the update to display.
     * Observer or subscribers are like readers who read things.
 
 Aka. this method is also known as publish method.
 
 Note : that readers will always read the same data not different data.
 This method always contains same arguments as IObserverable.Update except for the first argument.
     * 
     * @param propertyName
     * @param value
     */
    @Override
    public void notifyObserver(String propertyName, int value) {
        for (IObserverable observer : observers) {
            // same value is going to be published to all the observer
            observer.update(observer, propertyName, value);
        }
    }
    
}
