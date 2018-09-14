package com.reodeveloper.ghibli_locations.data;

import com.reodeveloper.common.repository.DataSource;
import com.reodeveloper.common.repository.Repository;
import com.reodeveloper.common.repository.Specification;
import com.reodeveloper.ghibli_locations.domain.model.Location;

import java.util.List;

public class LocationRepository extends Repository<Location> {
    private DataSource<Location> cache;

    public LocationRepository(DataSource<Location> datasource) {
        super(datasource);
    }

    public void addDatasource(DataSource<Location> dataSource){
        cache = dataSource;
    }

    @Override
    public List<Location> getAll() {
        // First we check if we have caché
        if(cache != null){
            List<Location> result = cache.getAll();
            // If it was nor previously cached, we store it
            if(result.size() == 0){
                result = super.getAll();
                cache.store(result);
            }
            return result;
        }
        return super.getAll();
    }

    @Override
    public List<Location> queryList(Specification specification) {
        return super.queryList(specification);
    }

    @Override
    public Location queryItem(Specification specification) {
        return super.queryItem(specification);
    }
}
