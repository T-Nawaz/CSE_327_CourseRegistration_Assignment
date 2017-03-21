package com.company;

import java.util.LinkedList;

/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class Registration {
    LinkedList<Course> courseList = new LinkedList<>();
    int total = 0;

    public LinkedList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(LinkedList<Course> courseList) {
        this.courseList = courseList;
    }


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


}
