package com.company;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class AboriginalORMinorityGroupDiscount implements IDiscountStrategy{

    @Override
    public int getTotal(Registration registration) {
        return (int) (registration.getTotal()*0.4);
    }
}
