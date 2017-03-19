package com.company;

import java.util.LinkedList;

/**
 * Created by tntan on 3/14/2017.
 */
public class CompositeDiscount implements IDiscountStrategy {
    LinkedList<IDiscountStrategy> iDiscountStrategies=new LinkedList<>();
    @Override
    public int getTotal(Registration registration) {
        return 0;
    }
    public void add(IDiscountStrategy iDiscountStrategy){
        this.iDiscountStrategies.add(iDiscountStrategy);
    }
}
