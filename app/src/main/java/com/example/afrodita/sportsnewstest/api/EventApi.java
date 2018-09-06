package com.example.afrodita.sportsnewstest.api;

import com.example.afrodita.sportsnewstest.mvp.event.model.ArticleModel;
import com.example.afrodita.sportsnewstest.mvp.eventlist.model.EventArrayModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventApi {

    @GET("list.php")
    Call<EventArrayModel> listCategory(@Query("category") String category);

    @GET("post.php")
    Call<ArticleModel> getArticle(@Query("article") String article);

}
