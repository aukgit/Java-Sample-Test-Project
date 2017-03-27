/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObserverPattern;

import Interfaces.IObserver;
import Interfaces.ISubject;
import java.util.LinkedList;

/**
 *
 * @author Md. Alim Ul Karim
 * Subject is the publisher.
 * Keeps track of every observer or subscribers and  updates those as per necessary.
 */
public class TotalPublisher implements ISubject{
    
    private LinkedList<IObserver> observers = new LinkedList<>();
    
    /**
     *
     * @param newObserver
     * Register or add new observer to the observer list.
     */
    @Override
    public void register(IObserver newObserver) {
        observers.add(newObserver);
    }
    
    /**
     *
     * @param registeredObserver
     * Removes the listener from the list.
     */
    @Override
    public void unregister(IObserver registeredObserver) {
        observers.remove(registeredObserver);
    }        

    
    /**
     * On any change update all the observers about the update to display.
     * Observer or subscribers are like readers who read things.
     * 
     * Aka. this method is also known as publish method.
     * 
     * Note : that readers will always read the same data not different data.
     * This method always contains same arguments as IObserver.Update except for the first argument.
     * 
     * @param propertyName
     * @param value
     */
    @Override
    public void notifyObserver(String propertyName, int value) {
        for (IObserver observer : observers) {
            // same value is going to be published to all the observer
            observer.update(observer, propertyName, value);
        }
    }
    
}
