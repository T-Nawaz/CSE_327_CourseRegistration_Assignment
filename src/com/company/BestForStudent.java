package com.company;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class BestForStudent extends CompositeDiscount {
    @Override
    public int getTotal(Registration registration) {
        //TODO implements best strategy for Students

        /**
         * TODO may have to implement the whole getTotal Function here
         */
        System.out.print("LL: "+iDiscountStrategies.size());
        int bestForStudent = Integer.MAX_VALUE;
        for (IDiscountStrategy iDS : super.iDiscountStrategies) {
            System.out.println(String.valueOf("IDS: "+iDS));
            if (bestForStudent > iDS.getTotal(registration))
                bestForStudent = iDS.getTotal(registration);
        }
        return bestForStudent;
    }
}
