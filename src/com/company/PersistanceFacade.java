package com.company;

import java.util.HashMap;

/**
 * Created by Abid Hasan on 3/24/2017.
 */
public class PersistanceFacade {

    private IMapper iMapper; //May not need it here
    private HashMap<Course,CourseDescriptionRDBMapper> mappers=new HashMap<>();
    /**
     * TODO mappers K,V is assumed not sure what will be <IMappers> is the only field given in diagram but it will need another parameter
     * TODO Don't Understand what this is for
     * TODO what should be the and value of mappers
     */
    private static PersistanceFacade instance;

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
       IMapper iMapper=mappers.get(persistanceClasss);
        /**
         * TODO it may be a class of RDBMappper+{@link CourseDescriptionRDBMapper} which to select or Course+{@link Course} class
         */


        return iMapper.get(oid);
    }

    public void put(String oid,Object object){

        /**
         * TODO don't understand what to do here
         * TODO may be need new classes to mappers according to Diagram
         */
        iMapper.put(oid,object); //Confused This may not be right the implementation
    }
}
