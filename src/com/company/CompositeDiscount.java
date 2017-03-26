package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class CompositeDiscount implements IDiscountStrategy {
static LinkedList<IDiscountStrategy> iDiscountStrategies=new LinkedList<>();
    private  CompositeDiscount compositeDiscount;
    static IDiscountStrategy discountStrategy;

@Override
    public int getTotal(Registration registration) {

        Configuration();
        String names = System.getProperty("IDiscountStrategy.class.name.list");
        String[] name= names.split(",");

        for (String n:name) {
            n= this.getClass().getPackage().getName() + "." +n.trim()+"Discount";
            try {
                discountStrategy=(IDiscountStrategy) Class.forName(n).newInstance();
                add(discountStrategy);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("LLSIZE"+iDiscountStrategies.size());

        }


        System.out.println(names);
        if (compositeDiscount == null) {
            String className = this.getClass().getPackage().getName() + "." + System.getProperty("CompositeDiscount.class.name"); // confused don't have extraFeeCalculator class so usedIExtraFreeCalculator
            System.out.println(className);
            try {
                compositeDiscount = (CompositeDiscount) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return compositeDiscount.getTotal(registration);
    }

    public void add(IDiscountStrategy iDiscountStrategy){
        this.iDiscountStrategies.add(iDiscountStrategy);
    }
    public void Configuration() {
        try{
            FileInputStream configurationFile = new FileInputStream("config/CompositeDiscount.config");
            Properties properties = new Properties(System.getProperties());
            properties.load(configurationFile);
            System.setProperties(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
