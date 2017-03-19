package com.company;

/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class RegistrationCourseController {

    Registration reg;
    CourseFactory courseFactory = new CourseFactory();

    public void makeNewRegistration() {
        reg = new Registration();
    }

    public void addCourse(String id) {
        reg.addCourse(courseFactory.getCourse(id));
    }

    public Registration getRegistration() {
        return reg;
    }

    public Course getCourse(String id) {
        return courseFactory.getCourse(id);
    }

}
