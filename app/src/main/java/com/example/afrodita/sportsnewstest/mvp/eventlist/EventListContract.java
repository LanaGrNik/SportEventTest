package com.example.afrodita.sportsnewstest.mvp.eventlist;

import com.example.afrodita.sportsnewstest.mvp.eventlist.model.EventCategoryModel;

import java.util.ArrayList;

public interface EventListContract {

    interface View {
        void onLoadedEventList(ArrayList<EventCategoryModel> eventList);

        void onError();
    }

    interface Presenter {
        void onAttach(View view);

        void loadEventList(SportType type);
    }
}
