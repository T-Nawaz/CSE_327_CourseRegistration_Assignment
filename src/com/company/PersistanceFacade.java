<<<<<<< HEAD
package com.company;

import java.util.HashMap;

/**
 * Created by Abid Hasan on 3/24/2017.
 */
public class PersistanceFacade {

    private static PersistanceFacade instance;
    private HashMap mappers = new HashMap();
    private static Class Course;
    private static Class Registration;

    public PersistanceFacade() {

        try {
            Course=Class.forName("com.company.Course");
            Registration=Class.forName("com.company.Registration");

            mappers.put(Course,new CourseDescriptionRDBMapper());
            mappers.put(Registration,new RegistrationRDBMapper());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized PersistanceFacade getInstance(){
        if (instance==null){
            instance=new PersistanceFacade();
            /**
             * Created new Instance for each Registration for Courses
             */
        }
        return instance;
    }

    public Object get(String oid,Object object){

        IMapper mapper = (IMapper) mappers.get(object.getClass());
        Object result = null;
        if (mapper != null) {
            result = mapper.get(oid);
        }
        return result;
    }

    public void put(Object object){
        IMapper mapper =(IMapper) mappers.get(object.getClass());
        mapper.put(object);
    }


}
=======
package com.company;

import java.util.HashMap;

/**
 * Created by Abid Hasan on 3/24/2017.
 */
public class PersistanceFacade {

    private static PersistanceFacade instance;
    private HashMap mappers = new HashMap();
    private static Class Course;
    private static Class Registration;

    public PersistanceFacade() {

        try {
            Course=Class.forName("com.company.Course");
            Registration=Class.forName("com.company.Registration");

            mappers.put(Course,new CourseDescriptionRDBMapper());
            mappers.put(Registration,new RegistrationRDBMapper());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized PersistanceFacade getInstance(){
        if (instance==null){
            instance=new PersistanceFacade();
            /**
             * Created new Instance for each Registration for Courses
             */
        }
        return instance;
    }

    public Object get(String oid,Object object){

        IMapper mapper = (IMapper) mappers.get(object.getClass());
        Object result = null;
        if (mapper != null) {
            result = mapper.get(oid);
        }
        return result;
    }

    public void put(Object object){
        IMapper mapper =(IMapper) mappers.get(object.getClass());
        mapper.put(object);
    }


}
>>>>>>> origin/master
