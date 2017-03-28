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
public class BestForStudent extends CompositeDiscount {

    /**
     * Returns the highest discount , which is good for student
     *
     * @param registration
     * @return
     */
    @Override
    public int getTotal(Registration registration) {
        int highest = Integer.MIN_VALUE;

        if (getDiscountsList().size() <= 1) {
            return 0;
        }

        for (IDiscountStrategy iDiscountStrategy : getDiscountsList()) {
            int currentDiscount = iDiscountStrategy.getTotal(registration);
            if (highest <= currentDiscount) {
                highest = currentDiscount;
            }
        }

        return highest;
    }
}
