package com.company;

import java.util.HashMap;

/**
 * Created by Abid Hasan on 3/24/2017.
 */
public class PersistanceFacade {

    private static PersistanceFacade instance;
    private IMapper iMapper;

    public static synchronized PersistanceFacade getInstance(){
        if (instance==null){
            instance=new PersistanceFacade();
            /**
             * Created new Instance for each Registration for Courses
             */
        }
        return instance;
    }

    public Object get(String oid,Class persistanceClasss){

            if(persistanceClasss==Course.class && iMapper==null ){
            iMapper = new CourseDescriptionRDBMapper();
            }



        return iMapper.get(oid);
    }

    public void put(Course course){


        if(iMapper==null) {iMapper=new CourseDescriptionRDBMapper();}
        iMapper.put(course);
    }
}
