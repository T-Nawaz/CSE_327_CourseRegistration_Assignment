package com.company;

/**
 * Created by Abid Hasan on 3/8/2017.
 */
public class BDTaxAdapter implements IExtraFreeCalculator {
    public int getExtraAmount(int courseTotal) {
        BDTAXCalculator bdtaxCalculator = new BDTAXCalculator();
        return (int) Math.ceil(bdtaxCalculator.calculateVATAmount(courseTotal));
    }
}
