package com.company;

/**
 * Created by Abid Hasan on 3/24/2017.
 */
public class CourseDescriptionRDBMapper implements IMapper {

    private DatabaseConnector DBconnector;

    public CourseDescriptionRDBMapper() {
        DBconnector=new DatabaseConnector();
    }

    @Override
    public Object get(String oid) {

        String query="SELECT * FROM courses WHERE course_id='"+oid.trim().toUpperCase()+"'";
        Course ResultCourse =(Course) DBconnector.getData(query);


        return ResultCourse;
    }

    @Override
    public void put(Course course) {

        /**
         * TODO need to implement database connection and Query to Put Data from database using "oid" as the key
         * TODO returns nothing
         */

        String query="INSERT INTO courses (course_id,course_name,course_credit,credit_tution) VALUES ('"+course.getId().trim().toUpperCase()+"','"+course.getTitle().trim()+"',"+course.getCredit()+","+course.getTuitionPerCredit()+")";

        DBconnector.addData(query);



    }
}
