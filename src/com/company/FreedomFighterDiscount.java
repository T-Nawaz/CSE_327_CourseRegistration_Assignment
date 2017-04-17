package com.company;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class FreedomFighterDiscount implements IDiscountStrategy {
    @Override
    public int getTotal(Registration registration) {
        return (registration.getTotal()-20000);
    }
}
