package com.example.afrodita.sportsnewstest.mvp.eventlist;

import com.example.afrodita.sportsnewstest.EventApi;
import com.example.afrodita.sportsnewstest.EventArrayModel;
import com.example.afrodita.sportsnewstest.EventCategoryModel;
import com.example.afrodita.sportsnewstest.mvp.SportType;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventListPresenter implements EventListContract.Presenter {

    EventListContract.View view;


    @Inject
    public EventListPresenter(){};

    @Override
    public void onAttach(EventListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadEventList(SportType type) {

                Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mikonatoruri.win/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EventApi eventApi = retrofit.create(EventApi.class);
        final Call<EventArrayModel> listCategory = eventApi.listCategory(type.getType());

        listCategory.enqueue(new Callback<EventArrayModel>() {
            @Override
            public void onResponse(Call<EventArrayModel> call, Response<EventArrayModel> response) {

                ArrayList<EventCategoryModel> listCategory = (ArrayList)response.body().getEvents();
                view.onLoadedEventList(listCategory);
            }

            @Override
            public void onFailure(Call<EventArrayModel> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
