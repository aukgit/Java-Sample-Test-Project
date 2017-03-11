/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Global.AppConfig;
import Interfaces.IExtraFeeCalculator;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class DevelopmentFeeCalculatorAdapter implements IExtraFeeCalculator {

    @Override
    public int getExtraAmount(int courseTotal) {
        if(AppConfig.Configuration.getExtraFeesPercentages().length == 2){
            return (int) Math.ceil(courseTotal * AppConfig.Configuration.getExtraFeesPercentages()[1]);
        }
        
        return 0;
    }

}
