package com.company;

/**
 * Created by tntan on 3/14/2017.
 */
public class FredomFighterDiscount implements IDiscountStrategy {
    @Override
    public int getTotal(Registration registration) {
        return (registration.getTotal()-20000);
    }
}
