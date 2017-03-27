/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StrategyPattern;

import BusinessLogic.Registration;
import Interfaces.IDiscountStrategy;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class MinorityGroupDiscount implements IDiscountStrategy{

    @Override
    public int getTotal(Registration registration) {
        return (int)(registration.getGrandTotal() * (0.6));
    }
    
}
