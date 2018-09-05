package com.example.afrodita.sportsnewstest.mvp.eventlist;

import com.example.afrodita.sportsnewstest.EventCategoryModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class EventRepository {

    @Inject
    public EventRepository(){}


    ArrayList<EventCategoryModel> eventList = new ArrayList<>();

    public ArrayList<EventCategoryModel> getEventList() {
        return eventList;
    }
}
