package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

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


        ResultSet resultSet =(ResultSet) DBconnector.getData(query);
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

    @Override
    public void put(Object object) {
        Course course = (Course) object;
        String query="INSERT INTO courses (course_id,course_name,course_credit,credit_tution) VALUES ('"+course.getId().trim().toUpperCase()+"','"+course.getTitle().trim()+"',"+course.getCredit()+","+course.getTuitionPerCredit()+")";
        DBconnector.addData(query);
    }
}
