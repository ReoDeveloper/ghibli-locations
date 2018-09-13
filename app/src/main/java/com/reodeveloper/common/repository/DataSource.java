package com.reodeveloper.common.repository;

import java.util.List;

public interface DataSource<T> {
    List<T> getAll();
    List<T> queryList(Specification specification);
    T queryItem(Specification specification);
}
