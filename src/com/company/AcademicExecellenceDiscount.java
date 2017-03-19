package com.company;

/**
 * Created by tntan on 3/14/2017.
 */
public class AcademicExecellenceDiscount implements IDiscountStrategy {
    @Override
    public int getTotal(Registration registration) {
        return (int) (registration.getTotal()*.5);
    }
}
