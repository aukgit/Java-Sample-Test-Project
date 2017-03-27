/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StrategyPattern;

import BusinessLogic.Registration;
import Interfaces.IDiscountStrategy;
import java.util.LinkedList;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class CompositeDiscount implements IDiscountStrategy {

    private LinkedList<IDiscountStrategy> discountsList;

    public CompositeDiscount() {
        discountsList = new LinkedList<IDiscountStrategy>();
    }

    public void add(IDiscountStrategy discountLogic) {
        discountsList.add(discountLogic);
    }

    @Override
    public int getTotal(Registration registration) {
        int sum = 0;
        for (IDiscountStrategy iDiscountStrategy : discountsList) {
            sum +=iDiscountStrategy.getTotal(registration);
        }
        
        return sum;
    }

}
