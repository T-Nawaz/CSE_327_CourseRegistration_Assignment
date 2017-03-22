package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class CourseFactory {

    private static CourseFactory instance;
    private IExtraFreeCalculator efCalculator;
    private IDiscountStrategy discountStrategy;
    private Course course = new Course();
    private LinkedList<Course> cList = new LinkedList<>();

    public CourseFactory() {
        course = new Course();
        course.setId("CSE 327");
        course.setTitle("Software Engineering");
        course.setCredit(3);
        course.setTuitionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 338");
        course.setTitle("Data Communication & network");
        course.setCredit(3);
        course.setTuitionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 338L");
        course.setTitle("Data Communication & network Lab");
        course.setCredit(1);
        course.setTuitionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("PHY 108");
        course.setTitle("Physics II");
        course.setCredit(3);
        course.setTuitionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 323");
        course.setTitle("Operating System Design");
        course.setCredit(3);
        course.setTuitionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("MAT 350");
        course.setTitle(" Engineering Mathematics   ");
        course.setCredit(3);
        course.setTuitionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 231");
        course.setTitle("Digital Logic design");
        course.setCredit(3);
        course.setTuitionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("PHY 107");
        course.setTitle("Physics I");
        course.setCredit(3);
        course.setTuitionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 332");
        course.setTitle("Computer Organization and Architecture");
        course.setCredit(3);
        course.setTuitionPerCredit(5500);
        cList.add(course);

        Configuration("extraFeeCalculator.config");
    }

    public static synchronized CourseFactory getInstance() {

            instance = new CourseFactory();
        return instance;
    }

    public Course getCourse(String id) {
        Course courseS = new Course();
        courseS.setId("Course Not Found");
        courseS.setTitle("Course Not Found");
        courseS.setCredit(0);
        courseS.setTuitionPerCredit(0);

        for (int i = 0; i < cList.size(); i++) {
            course = cList.get(i);
            if (course.getId() == id)
                courseS = course;
        }


        return courseS;
    }

    public IExtraFreeCalculator getExtraFreeCalculator() {
        if (efCalculator == null) {
            String className = this.getClass().getPackage().getName() + "." + System.getProperty("IExtraFeeCalculator.class.name"); // confused don't have extraFeeCalculator class so usedIExtraFreeCalculator
           // System.out.println(className);
            try {
                efCalculator = (IExtraFreeCalculator) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return efCalculator;  //confused dont have vatCalculator so returned efCalculator
    }

    public IDiscountStrategy getDiscountStrategy(){
        Configuration("IDiscountStrategy.config");
        if (discountStrategy == null) {
            String className = this.getClass().getPackage().getName() + "." + System.getProperty("IDiscountStrategy.class.name"); // confused don't have extraFeeCalculator class so usedIExtraFreeCalculator
            System.out.println(className);
            try {
                if (className.contains("CompositeDiscount")){
                    discountStrategy = (IDiscountStrategy) Class.forName(className).newInstance();
                }else {
                    discountStrategy = (IDiscountStrategy) Class.forName(className).newInstance();
                }

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return discountStrategy;
    }


    public void Configuration(String confiFile) {
        try{
            FileInputStream configurationFile = new FileInputStream("config/"+confiFile);
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
