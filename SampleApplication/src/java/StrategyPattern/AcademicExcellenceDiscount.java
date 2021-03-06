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
public class AcademicExcellenceDiscount implements IDiscountStrategy {

    @Override
    public int getTotal(Registration registration) {
        float discount = (float) registration.getGrandTotal() * (float) 0.5; // 50% discount.
        return (int) discount;
    }

}
