package com.company;

import java.util.Objects;

/**
 * Created by Abid Hasan on 3/24/2017.
 */
public interface IMapper {

    /**
     * TODO may need to change "String oid" to Different Class Object "OID oid" -> returns unique Object ID
     * @param oid
     * @return
     */
    public Object get(String oid);
    public void put(Course course);
}
