package com.company;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 * Created by tntan on 3/14/2017.
 */
public class BestForNSU extends CompositeDiscount {

    @Override
    public int getTotal(Registration registration) {
        //TODO implements best strategy for North South University

        /**
         * TODO may have to implement the whole getTotal Function here
         */
        int bestForNsu = Integer.MIN_VALUE;
        for (IDiscountStrategy iDS : super.iDiscountStrategies) {
            if (bestForNsu < iDS.getTotal(registration))
                bestForNsu = iDS.getTotal(registration);
        }

        return bestForNsu;
    }
}
