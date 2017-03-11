/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Md. Alim Ul Karim
 */
public interface IExtraFeeCalculator {
    /**
     * 
     * @param courseTotal
     * @return Add extra percentage and returns the value
     */
    public int getExtraAmount(int courseTotal);
}
