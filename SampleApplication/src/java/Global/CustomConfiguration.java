/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

import Adapters.TypeAdapter;
import java.util.List;

/**
 *
 * @author Md. Alim Ul Karim
 */
public class CustomConfiguration {

    /**
     * @return the extraPaymentAdapterClassNames
     */
    public String[] getExtraPaymentAdapterClassNames() {
        return extraPaymentAdapterClassNames;
    }

    private int numberOfPayments;
    private int[] extraFeesPercentages;
    private String[] extraPaymentAdapterClassNames;
    private String[] extraPaymentsPercentagesList;

    CustomConfiguration(List<String> _configFileLines) {
        numberOfPayments = Integer.parseInt(_configFileLines.get(0));

        extraFeesPercentages = new int[numberOfPayments];

        if (numberOfPayments == 0) {
            return;
        }

        extraPaymentAdapterClassNames = _configFileLines.get(1).split(" ");
        extraPaymentsPercentagesList = _configFileLines.get(2).split(" ");

        extraFeesPercentages = TypeAdapter.convert(extraPaymentsPercentagesList);
    }

    /**
     * @return the numberOfPayments
     */
    public int getNumberOfPayments() {
        return numberOfPayments;
    }

    /**
     * @return the extraFeesPercentages
     */
    public int[] getExtraFeesPercentages() {
        return extraFeesPercentages;
    }

}
