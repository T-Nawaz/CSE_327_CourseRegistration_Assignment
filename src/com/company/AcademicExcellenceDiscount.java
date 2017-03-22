package com.company;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class AcademicExcellenceDiscount implements IDiscountStrategy {
    @Override
    public int getTotal(Registration registration) {
        /**
         * TODO may have to implement the whole getTotal Function here
         */
        return (int) (registration.getTotal()*.5);
    }
}
