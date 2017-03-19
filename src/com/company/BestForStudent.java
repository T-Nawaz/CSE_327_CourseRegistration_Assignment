package com.company;

/**
 * Created by tntan on 3/14/2017.
 */
public class BestForStudent extends CompositeDiscount {
    @Override
    public int getTotal(Registration registration) {
        return registration.getTotal();
    }
}
