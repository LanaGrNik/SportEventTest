package com.example.afrodita.sportsnewstest.mvp.event;

import com.example.afrodita.sportsnewstest.mvp.event.model.ArticleModel;
import com.example.afrodita.sportsnewstest.api.EventApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventPresenter implements EventContract.Presenter {

    EventContract.View view;
    EventApi eventApi;

    @Inject
    EventPresenter(EventApi eventApi){
        this.eventApi = eventApi;
    }

    @Override
    public void onAttach(EventContract.View view) {
        this.view = view;
    }

    @Override
    public void getArticle(String article) {

        Call<ArticleModel> getArticle = eventApi.getArticle(article);


        getArticle.enqueue(new Callback<ArticleModel>() {
            @Override
            public void onResponse(Call<ArticleModel> call, Response<ArticleModel> response) {
                ArticleModel articleModel = response.body();
                view.onLoadedArticle(articleModel);
            }

            @Override
            public void onFailure(Call<ArticleModel> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
