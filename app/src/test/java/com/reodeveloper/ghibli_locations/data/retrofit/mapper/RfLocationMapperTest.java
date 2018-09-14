package com.reodeveloper.ghibli_locations.data.retrofit.mapper;

import com.reodeveloper.ghibli_locations.data.retrofit.model.RfLocation;
import com.reodeveloper.ghibli_locations.domain.model.Location;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RfLocationMapperTest {

    private final int INT_ZERO = 0;
    private final String STRING_EMPTY = "";
    private final String STRING_UNKNOWN = "Unknown";
    private final String STRING_ID = "Some-text-id";
    private final String STRING_NAME = "Name of a place";
    private final String STRING_CLIMATE = "Damn hot";
    private final String STRING_TERRAIN = "Damn high";
    private final String STRING_URL = "https://some/url/for/test";
    private final String STRING_TODO = "TODO";

    private final List<String> LIST_MULTIPLE_RESIDENTS = Arrays.asList(STRING_URL, STRING_URL, STRING_URL);
    private final List<String> LIST_SINGLE_RESIDENT = Arrays.asList(STRING_URL, STRING_URL, STRING_URL);
    private final List<String> LIST_NO_RESIDENTS = new ArrayList<>();
    private final List<String> LIST_TODO_RESIDENTS = Collections.singletonList(STRING_TODO);

    private final List<String> LIST_SINGLE_FILMS = Collections.singletonList(STRING_TODO);

    private final List<String> LIST_URL = Collections.singletonList(STRING_URL);

    RfLocationMapper mapper = new RfLocationMapper();

    @Test public void shouldReturnCompleteLocation(){
        RfLocation given = givenLocationComplete();

        Location test = mapper.map(given);

        assertEquals(STRING_ID, test.getId());
        assertEquals(STRING_NAME, test.getName());
        assertEquals(STRING_CLIMATE, test.getClimate());
        assertEquals(LIST_MULTIPLE_RESIDENTS.size(), test.getPopulation());
        assertEquals(STRING_TERRAIN, test.getGeography());
    }

    @Test public void shouldReturnLocationWithId(){
        RfLocation given = givenLocationWithId();

        Location test = mapper.map(given);

        assertEquals(STRING_ID, test.getId());
    }

    @Test public void shouldReturnLocationWithNoId(){
        RfLocation given = givenEmptyLocation();

        Location test = mapper.map(given);

        assertEquals(STRING_UNKNOWN, test.getId());
    }


    @Test public void shouldReturnLocationWithCorrectName(){
        RfLocation given = givenLocationWithName();

        Location test = mapper.map(given);

        assertEquals(STRING_NAME, test.getName());
    }

    @Test public void shouldReturnLocationWithNoName(){
        RfLocation given = givenEmptyLocation();

        Location test = mapper.map(given);

        assertEquals(STRING_EMPTY, test.getName());
    }

    @Test public void shouldReturnLocationWithClimate(){
        RfLocation given = givenLocationWithClimate();

        Location test = mapper.map(given);

        assertEquals(STRING_CLIMATE, test.getClimate());
    }

    @Test public void shouldReturnLocationWithNoClimate(){
        RfLocation given = givenEmptyLocation();

        Location test = mapper.map(given);

        assertEquals(STRING_EMPTY, test.getClimate());
    }


    @Test public void shouldReturnLocationWithMultipleResidents(){
        RfLocation given = givenLocationWithMultipleResidents();

        Location test = mapper.map(given);

        assertEquals(LIST_MULTIPLE_RESIDENTS.size(), test.getPopulation());
    }

    @Test public void shouldReturnLocationWithSingleResident(){
        RfLocation given = givenLocationWithOneResident();

        Location test = mapper.map(given);

        assertEquals(LIST_SINGLE_RESIDENT.size(), test.getPopulation());
    }

    @Test public void shouldReturnLocationWithNoResidents(){
        RfLocation given = givenLocationWithNoResidents();

        Location test = mapper.map(given);

        assertEquals(INT_ZERO, test.getPopulation());
    }

    @Test public void shouldReturnLocationWithNoResidentsBecauseTodo(){
        RfLocation given = givenLocationWithTodoResidents();

        Location test = mapper.map(given);

        assertEquals(INT_ZERO, test.getPopulation());
    }

    @Test public void shouldReturnLocationWithGeography(){
        RfLocation given = givenLocationWithTerrain();

        Location test = mapper.map(given);

        assertEquals(STRING_TERRAIN, test.getGeography());
    }

    @Test public void shouldReturnLocationWithNoGeography(){
        RfLocation given = givenEmptyLocation();

        Location test = mapper.map(given);

        assertEquals(STRING_UNKNOWN, test.getGeography());
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

    private RfLocation givenLocationWithTerrain(){
        RfLocation result = new RfLocation();
        result.setTerrain(STRING_TERRAIN);
        return result;
    }

    private RfLocation givenLocationComplete(){
        RfLocation result = new RfLocation();
        result.setId(STRING_ID);
        result.setName(STRING_NAME);
        result.setClimate(STRING_CLIMATE);
        result.setTerrain(STRING_TERRAIN);
        result.setResidents(LIST_MULTIPLE_RESIDENTS);
        result.setFilms(LIST_SINGLE_FILMS);
        result.setUrl(LIST_URL);
        return result;
    }
}