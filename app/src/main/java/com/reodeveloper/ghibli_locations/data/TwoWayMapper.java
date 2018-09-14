package com.reodeveloper.ghibli_locations.data;

import java.util.ArrayList;
import java.util.List;

public abstract class TwoWayMapper<I, O> extends Mapper<I, O> {
    public abstract I reverseMap(O item);

    public List<I> reverseMap(List<O> list) {
        List<I> result = new ArrayList<I>();
        for (O item : list) {
            result.add(reverseMap(item));
        }
        return result;
    }
}
