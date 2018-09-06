package com.example.afrodita.sportsnewstest.mvp.eventlist;

import com.example.afrodita.sportsnewstest.EventCategoryModel;
import com.example.afrodita.sportsnewstest.mvp.SportType;

import java.util.ArrayList;

import retrofit2.Retrofit;

public interface EventListContract {

    interface View{

        void onLoadedEventList(ArrayList<EventCategoryModel> eventList);

       void onError();
    }

    interface Presenter{

        void onAttach(View view);

        void loadEventList(SportType type);
    }
}
