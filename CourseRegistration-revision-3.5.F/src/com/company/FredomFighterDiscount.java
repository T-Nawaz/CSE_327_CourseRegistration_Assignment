package com.company;

/**
 * Created by tntan on 3/14/2017.
 */
public class FredomFighterDiscount implements IDiscountStrategy {
    @Override
    public int getTotal(Registration registration) {

        /**
         * TODO may have to implement the whole getTotal Function here
         */
        return (registration.getTotal()-20000);
    }
}
