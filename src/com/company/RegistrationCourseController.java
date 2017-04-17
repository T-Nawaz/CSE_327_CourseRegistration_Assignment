<<<<<<< HEAD
package com.company;

/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class RegistrationCourseController {

    private Registration reg;
    private int regId=0;
    CourseFactory courseFactory = new CourseFactory();

    public void makeNewRegistration() {
        if(reg!=null){
            PersistanceFacade.getInstance().put(reg);
        }
        reg = new Registration(regId);
        regId++;
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
=======
package com.company;

/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class RegistrationCourseController {

    private Registration reg;
    private int regId=0;
    CourseFactory courseFactory = new CourseFactory();

    public void makeNewRegistration() {
        if(reg!=null){
            PersistanceFacade.getInstance().put(reg);
        }
        reg = new Registration(regId);
        regId++;
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
>>>>>>> origin/master
