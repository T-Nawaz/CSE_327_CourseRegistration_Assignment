package com.company;

/**
 * Created by Abid Hasan on 4/17/2017.
 */
public abstract class PersistanceMapper implements IMapper {

    @Override
    public Object get(String oid) {
        return getObjectFromStorage(oid);
    }

    protected abstract Object getObjectFromStorage(String oid);
}
