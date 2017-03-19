package com.company;

import java.util.LinkedList;

/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class Registration {
    LinkedList<Course> courseList = new LinkedList<>();
    int total = 0;

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public int getTotal() {
        total = 0;

        for (int i = 0; i < courseList.size(); i++) {
            total += (courseList.get(i)).getSubTotal();
        }

        return total;
    }

    public int getGrandTotal() {
        return (this.getTotal() + this.getExtraFeeAmonunt());
    }

    public int getExtraFeeAmonunt() {
        IExtraFreeCalculator iefc = CourseFactory.getInstance().getExtraFreeCalculator();
        return iefc.getExtraAmount(this.getTotal());
    }


}
