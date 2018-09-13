package com.reodeveloper.common.repository;

import java.util.List;

public class Repository<T> {
    private final DataSource<T> datasource;

    public Repository(DataSource<T> datasource) {
        this.datasource = datasource;
    }

    public List<T> getAll(){
        return datasource.getAll();
    }

    public List<T> queryList(Specification specification){
        return datasource.queryList(specification);
    }

    public T queryItem(Specification specification){
        return datasource.queryItem(specification);
    }
}
