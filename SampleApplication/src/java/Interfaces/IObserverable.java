/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


/**
 *
 * @author Md. Alim Ul Karim
 * Aka Subscriber or PropertyListener as slide
 * Only displays things or reads nothing else.
 * 
 */
public interface IObserverable {

    /**
     * This is similar to the onPropertyEvent Method in the slide.
     * Which updates the given property based on given inputs.
     * @param source : Which observer it is coming from.
     * @param propertyName : Which property to update
     * @param value : What is the value of that property.
     */
    public void update(IObserverable source, String propertyName, int value);

}
