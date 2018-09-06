package com.example.afrodita.sportsnewstest.mvp.eventlist;

import com.example.afrodita.sportsnewstest.api.EventApi;
import com.example.afrodita.sportsnewstest.mvp.eventlist.model.EventArrayModel;
import com.example.afrodita.sportsnewstest.mvp.eventlist.model.EventCategoryModel;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventListPresenter implements EventListContract.Presenter {

    EventListContract.View view;
    EventApi eventApi;

    @Inject
    public EventListPresenter(EventApi eventApi) {
        this.eventApi = eventApi;
    }

    @Override
    public void onAttach(EventListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadEventList(SportType type) {
        final Call<EventArrayModel> listCategory = eventApi.listCategory(type.getType());

        listCategory.enqueue(new Callback<EventArrayModel>() {
            @Override
            public void onResponse(Call<EventArrayModel> call, Response<EventArrayModel> response) {
                ArrayList<EventCategoryModel> listCategory = (ArrayList) response.body().getEvents();
                view.onLoadedEventList(listCategory);
            }

            @Override
            public void onFailure(Call<EventArrayModel> call, Throwable t) {
                view.onError();
                t.printStackTrace();
            }
        });
    }
}
