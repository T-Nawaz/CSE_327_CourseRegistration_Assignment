package com.company;

import java.util.LinkedList;

/**
 * Created by Abid Hasan on 2/28/2017.
 */
public class CourseFactory {
    LinkedList<Course> cList = new LinkedList<>();
    Course course = new Course();

    public CourseFactory() {
        course = new Course();
        course.setId("CSE 327");
        course.setTitle("Software Engineering");
        course.setCredit(3);
        course.setTutionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 338");
        course.setTitle("Data Communication & network");
        course.setCredit(3);
        course.setTutionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 338L");
        course.setTitle("Data Communication & network Lab");
        course.setCredit(1);
        course.setTutionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("PHY 108");
        course.setTitle("Physics II");
        course.setCredit(3);
        course.setTutionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 323");
        course.setTitle("Operating System Design");
        course.setCredit(3);
        course.setTutionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("MAT 350");
        course.setTitle(" Engineering Mathematics");
        course.setCredit(3);
        course.setTutionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 231");
        course.setTitle("Digital Logic design");
        course.setCredit(3);
        course.setTutionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("PHY 107");
        course.setTitle("Physics I");
        course.setCredit(3);
        course.setTutionPerCredit(5500);
        cList.add(course);

        course = new Course();
        course.setId("CSE 332");
        course.setTitle("Computer Organization and Architecture");
        course.setCredit(3);
        course.setTutionPerCredit(5500);
        cList.add(course);
    }

    public Course getCourse(String id) {
        Course courseS = new Course();
        courseS.setId("Course Not Found");
        courseS.setTitle("Course Not Found");
        courseS.setCredit(0);
        courseS.setTutionPerCredit(0);

        for (int i = 0; i < cList.size(); i++) {
            course = cList.get(i);
            if (course.getId() == id)
                courseS = course;
        }


        return courseS;
    }


}
