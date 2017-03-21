package com.company;

/**
 * Created by tntan on 3/14/2017.
 */
public class AcademicExecellenceDiscount implements IDiscountStrategy {
    @Override
    public int getTotal(Registration registration) {
        /**
         * TODO may have to implement the whole getTotal Function here
         */
        return (int) (registration.getTotal()*.5);
    }
}
