package com.company;

public class DevelopmentFeeCalculator implements IExtraFreeCalculator {
    public int getExtraAmount(int courseTotal) {
        return (int) Math.ceil(courseTotal * 0.1);
    }
}
