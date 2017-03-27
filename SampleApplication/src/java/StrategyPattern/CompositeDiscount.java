/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StrategyPattern;

import BusinessLogic.Registration;
import Interfaces.IDiscountStrategy;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class CompositeDiscount implements IDiscountStrategy {

    /**
     * @return the discountsList
     */
    protected LinkedList<IDiscountStrategy> getDiscountsList() {
        return discountsList;
    }

    private LinkedList<IDiscountStrategy> discountsList;

    public CompositeDiscount() {
        discountsList = new LinkedList<IDiscountStrategy>();
        System.gc(); // removes dangling pointers
    }

    public void add(IDiscountStrategy discountLogic) {
        getDiscountsList().add(discountLogic);
    }

    public void add(List<String> discountStrategies) {
        /**
         * Academic Excellence,Freedom Fighter, Aboriginal / Minority Group Best,
         * for NSU Best for Student
         */
        for (String discountStrategy : discountStrategies) {
            switch (discountStrategy) {
                case "Academic Excellence":
                    add(new AcademicExcellenceDiscount());
                    break;
                case "Freedom Fighter":
                    add(new FreedomFigtherDiscount());
                    break;
                case "Aboriginal / Minority Group":
                    add(new MinorityGroupDiscount());
                    break;
            }
            
        }
    }

    @Override
    public int getTotal(Registration registration) {
        int sum = 0;
        for (IDiscountStrategy iDiscountStrategy : getDiscountsList()) {
            sum += iDiscountStrategy.getTotal(registration);
        }

        return sum;
    }

}
