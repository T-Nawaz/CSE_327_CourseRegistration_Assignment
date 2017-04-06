package com.company;

import java.util.LinkedList;


/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class Registration {
    private LinkedList<Course> courseList = new LinkedList<>();
    private int total = 0;
    private int registrationId;

    public Registration(int registrationId) {
        this.registrationId = registrationId;
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public int getTotal() {
        total=0;
        for (int i = 0; i < courseList.size(); i++) {
            total += (courseList.get(i)).getSubTotal();
        }
        return total;
    }


    public int getGrandTotal() {
        return (this.getTotal() + this.getExtraFeeAmount());
    }

    public int getExtraFeeAmount() {

        IExtraFreeCalculator iefc = CourseFactory.getInstance().getExtraFreeCalculator();
        return iefc.getExtraAmount(this.getTotal());
    }
    public int getDiscountAmount(){
        IDiscountStrategy discountStrategy=CourseFactory.getInstance().getDiscountStrategy();
        return discountStrategy.getTotal(this);
    }
    public LinkedList getCourseList(){
        return courseList;
    }
    public int getRegistrationId(){
        return registrationId;
    }


}
