/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Md. Alim Ul Karim
 * Subject is the publisher.
 * Keeps track of every observer or subscribers and  updates those as per necessary.
 */
public interface ISubject {
    
    /**
     *
     * @param newObserver
     * Register or add new observer to the observer list.
     */
    public void register(IObserver newObserver);
    public void unregister(IObserver registeredObserver);
   
    /**
     * On any change update all the observers about the update to display.
     * Observer or subscribers are like readers who read things.
     * 
     * Note : that readers will always read the same data not different data.
     * This method always contains same arguments as IObserver.Update except for the first argument.
     * 
     * @param propertyName
     * @param value
     */
    public void notifyObserver(String propertyName, int value);
 
}
