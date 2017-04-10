package com.company;

import java.util.LinkedList;

/**
 * Created by Abid Hasan on 4/6/2017.
 */
public class RegistrationRDBMapper implements IMapper {
    private DatabaseConnector DBconnector;

    public RegistrationRDBMapper() {
        DBconnector=new DatabaseConnector();
    }

    @Override

    public Object get(String oid) {
        //TODO to be implemented in future
        return null;
    }

    @Override
    public void put(Object object) {
        Registration registration=(Registration)object;
        LinkedList<Course> courses=registration.getCourseList();
        int regId=registration.getRegistrationId();
        String query;
        for (Course course:courses) {
            query="INSERT INTO registrations (registration_id,course_id) VALUES ('"+regId+"','"+course.getId().trim().toUpperCase()+"')";
            DBconnector.addData(query);

        }
    }
}
