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
    private float[] extraFeesPercentages;
    private String[] extraPaymentAdapterClassNames;
    private String[] extraPaymentsPercentagesList;

    CustomConfiguration(List<String> _configFileLines) {
        numberOfPayments = Integer.parseInt(_configFileLines.get(0));

        extraFeesPercentages = new float[numberOfPayments];

        if (numberOfPayments == 0) {
            return;
        }

        extraPaymentAdapterClassNames = _configFileLines.get(1).split(" ");
        extraPaymentsPercentagesList = _configFileLines.get(2).split(" ");

        extraFeesPercentages = TypeAdapter.convertToFloatList(extraPaymentsPercentagesList);
    }

    public float getExtraFeesPercentageForClass(Object o) {
        String name = o.getClass().getName();
        int i = 0;
        for (String extraPaymentAdapterClassName : extraPaymentAdapterClassNames) {
            if (extraPaymentAdapterClassName.equals(name)) {
                return extraFeesPercentages[i];

            }
            i++;
        }
        
        
        return 0;
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
    public float[] getExtraFeesPercentages() {
        return extraFeesPercentages;
    }

}
