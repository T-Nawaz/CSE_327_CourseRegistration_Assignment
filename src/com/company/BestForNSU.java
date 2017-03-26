package com.company;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class BestForNSU extends CompositeDiscount {

    @Override
    public int getTotal(Registration registration) {

        int bestForNsu = Integer.MIN_VALUE;
        for (IDiscountStrategy iDS : super.iDiscountStrategies) {
            if (bestForNsu < iDS.getTotal(registration))
                bestForNsu = iDS.getTotal(registration);
        }

        return bestForNsu;
    }
}
