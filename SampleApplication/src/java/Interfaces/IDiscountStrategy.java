/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BusinessLogic.Registration;

/**
 *
 * @author Md. Alim Ul Karim
 */
public interface IDiscountStrategy {
    
    public int getTotal(Registration registration);
}
