package com.ibm.websphere.svt.gs.gsjsfweb.snowday;

import java.util.ArrayList;
import java.util.List;

public class SnowDayEvent {

    private String currentWeather;
    private Integer id = 0;
    private List<String> eventsSequence = new ArrayList<>();

    public SnowDayEvent(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public void addEvent(String eventTitle){
        eventsSequence.add(++id + ":" +eventTitle);
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public List<String> getEventsSequence() {
        return eventsSequence;
    }
}