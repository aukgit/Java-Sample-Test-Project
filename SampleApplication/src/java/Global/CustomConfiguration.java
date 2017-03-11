/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

import java.util.List;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class CustomConfiguration {
    private int numberOfPayments;
    private int[] extraFeesPercentages;
    
    CustomConfiguration(List<String> _configFileLines) {
        numberOfPayments = Integer.parseInt(_configFileLines.get(0));
        extraFeesPercentages = new int[numberOfPayments];
        String[] listOfPayments = _configFileLines.get(1).split(" ");
        
    }
    
    
    
}
