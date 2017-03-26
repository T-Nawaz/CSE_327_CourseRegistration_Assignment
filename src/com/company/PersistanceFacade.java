package com.company;

import java.util.HashMap;

/**
 * Created by Abid Hasan on 3/24/2017.
 */
public class PersistanceFacade {

    /**
     * TODO mappers K,V is assumed not sure what will be <IMappers> is the only field given in diagram but it will need another parameter
     * TODO Don't Understand what this is for
     * TODO what should be the and value of mappers
     */
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

        /**
         * TODO it may be a class of RDBMappper+{@link CourseDescriptionRDBMapper} which to select or Course+{@link Course} class
         */


        return iMapper.get(oid);
    }

    public void put(Course course){

        /**
         * TODO don't understand what to do here
         * TODO may be need new classes to mappers according to Diagram
         */
        if(iMapper==null) {iMapper=new CourseDescriptionRDBMapper();}
        iMapper.put(course);
    }
}
