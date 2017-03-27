/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObserverPattern;

import Interfaces.IObserverable;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class BeeperObserver implements IObserverable{

    @Override
    public void update(IObserverable source, String propertyName, int value) {
        if("beep".equals(propertyName) && value == 1){
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }
    
}
