package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Abid Hasan on 3/24/2017.
 */
public class CourseDescriptionRDBMapper extends RDBMapper {

    private DatabaseConnector DBconnector;

    public CourseDescriptionRDBMapper() {
        super("courses");
        DBconnector=new DatabaseConnector();
    }

    @Override

    public void put(Object object) {
        Course course = (Course) object;
        String query="INSERT INTO courses (course_id,course_name,course_credit,credit_tution) VALUES ('"+course.getId().trim().toUpperCase()+"','"+course.getTitle().trim()+"',"+course.getCredit()+","+course.getTuitionPerCredit()+")";
        DBconnector.addData(query);
    }

    @Override
    protected Object getObjectFromRecord(String oid, Object dbRecord) {


        ResultSet resultSet =(ResultSet) dbRecord;
        Course ResultCourse = new Course();
        try {
            while (resultSet.next()){
                ResultCourse.setId(resultSet.getString("course_id"));
                ResultCourse.setTitle(resultSet.getString("course_name"));
                ResultCourse.setCredit(resultSet.getInt("course_credit"));
                ResultCourse.setTuitionPerCredit(resultSet.getInt("credit_tution"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ResultCourse;
    }

}
