/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapters;

import Global.AppConfig;
import Interfaces.IExtraFeeCalculator;
import ThirdParty.BDTAXCalculator;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class BDTaxAdapter implements IExtraFeeCalculator {

    private BDTAXCalculator thirdPartyBDTaxCalculator = new BDTAXCalculator();

    @Override
    public int getExtraAmount(int courseTotal) {
        return (int) Math.ceil(thirdPartyBDTaxCalculator.calculateVATAmount(courseTotal));
    }

}
