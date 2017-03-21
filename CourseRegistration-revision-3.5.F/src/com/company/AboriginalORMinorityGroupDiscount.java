package com.company;

/**
 * Created by tntan on 3/20/2017.
 */
public class AboriginalORMinorityGroupDiscount implements IDiscountStrategy{

    @Override
    public int getTotal(Registration registration) {
        return (int) (registration.getTotal()*0.4);
    }
}
