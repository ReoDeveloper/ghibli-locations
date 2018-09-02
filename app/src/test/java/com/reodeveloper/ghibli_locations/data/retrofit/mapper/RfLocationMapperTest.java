package com.reodeveloper.ghibli_locations.data.retrofit.mapper;

import com.reodeveloper.ghibli_locations.data.retrofit.model.RfLocation;
import com.reodeveloper.ghibli_locations.model.Location;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RfLocationMapperTest {

    private final String STRING_EMPTY = "";
    private final String STRING_ID = "Some-text-id";
    private final String STRING_NAME = "Name of a place";
    private final String STRING_CLIMATE = "Damn hot";
    private final String STRING_TERRAIN = "Damn high";
    private final String STRING_SURFACE_WATER = "1337m";
    private final String STRING_URL = "https://some/url/for/test";
    private final String STRING_TODO = "TODO";

    private final List<String> LIST_MULTIPLE_RESIDENTS = Arrays.asList(STRING_URL, STRING_URL, STRING_URL);
    private final List<String> LIST_SINGLE_RESIDENT = Arrays.asList(STRING_URL, STRING_URL, STRING_URL);
    private final List<String> LIST_NO_RESIDENTS = new ArrayList<>();
    private final List<String> LIST_TODO_RESIDENTS = Collections.singletonList(STRING_TODO);

    private final List<String> LIST_MULTIPLE_FILMS = Arrays.asList(STRING_URL, STRING_URL, STRING_URL);
    private final List<String> LIST_SINGLE_FILMS = Collections.singletonList(STRING_TODO);
    private final List<String> LIST_NO_FILMS = new ArrayList<>();

    private final List<String> LIST_URL = Collections.singletonList(STRING_URL);

    RfLocationMapper mapper = new RfLocationMapper();

    @Test public void shouldReturnLocationWithCorrectName(){
        RfLocation given = givenLocationWithName();

        Location test = mapper.map(given);

        assertEquals(test.getName(), STRING_NAME);
    }

    @Test public void shouldReturnLocationWithNoName(){
        RfLocation given = givenEmptyLocation();

        Location test = mapper.map(given);

        assertEquals(test.getName(), STRING_EMPTY);
    }

    private RfLocation givenEmptyLocation(){
        return new RfLocation();
    }

    private RfLocation givenLocationWithId(){
        RfLocation result = new RfLocation();
        result.setId(STRING_ID);
        return result;
    }

    private RfLocation givenLocationWithName(){
        RfLocation result = new RfLocation();
        result.setName(STRING_NAME);
        return result;
    }

    private RfLocation givenLocationWithClimate(){
        RfLocation result = new RfLocation();
        result.setClimate(STRING_CLIMATE);
        return result;
    }

    private RfLocation givenLocationWithTerrain(){
        RfLocation result = new RfLocation();
        result.setTerrain(STRING_TERRAIN);
        return result;
    }

    private RfLocation givenLocationWithMultipleResidents(){
        RfLocation result = new RfLocation();
        result.setResidents(LIST_MULTIPLE_RESIDENTS);
        return result;
    }

    private RfLocation givenLocationWithOneResident(){
        RfLocation result = new RfLocation();
        result.setResidents(LIST_SINGLE_RESIDENT);
        return result;
    }

    private RfLocation givenLocationWithNoResidents(){
        RfLocation result = new RfLocation();
        result.setResidents(LIST_NO_RESIDENTS);
        return result;
    }

    private RfLocation givenLocationWithTodoResidents(){
        RfLocation result = new RfLocation();
        result.setResidents(LIST_TODO_RESIDENTS);
        return result;
    }

    private RfLocation givenLocationWithSurfaceWater(){
        RfLocation result = new RfLocation();
        result.setSurface_water(STRING_SURFACE_WATER);
        return result;
    }

    private RfLocation givenLocationComplete(){
        RfLocation result = new RfLocation();
        result.setId(STRING_ID);
        result.setName(STRING_NAME);
        result.setClimate(STRING_CLIMATE);
        result.setTerrain(STRING_TERRAIN);
        result.setSurface_water(STRING_SURFACE_WATER);
        result.setResidents(LIST_MULTIPLE_RESIDENTS);
        result.setFilms(LIST_SINGLE_FILMS);
        result.setUrl(LIST_URL);
        return result;
    }
}