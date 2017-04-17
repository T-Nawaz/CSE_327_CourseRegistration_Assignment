package com.company;

import javafx.beans.binding.ObjectExpression;

/**
 * Created by Abid Hasan on 4/17/2017.
 */
public abstract class RDBMapper extends PersistanceMapper {
    private static String TABLE_NAME=null;
    public RDBMapper(String TABLE_NAME) {
        this.TABLE_NAME=TABLE_NAME;
    }

    protected abstract Object getObjectFromRecord(String oid, Object dbRecord);
    @Override
    protected Object getObjectFromStorage(String oid) {

        Object dbRecord=getDBRecord(oid);

        return getObjectFromRecord(oid,dbRecord);
    }

    private Object getDBRecord(String oid){

        String query="SELECT * FROM "+TABLE_NAME+" WHERE course_id='"+oid.trim().toUpperCase()+"'";
        DatabaseConnector DB=new DatabaseConnector();
        Object record= DB.getData(query);

        return record;
    }


}
