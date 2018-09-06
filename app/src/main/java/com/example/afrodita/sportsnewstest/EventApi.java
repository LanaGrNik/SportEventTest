package com.example.afrodita.sportsnewstest;

import android.database.Observable;

import com.example.afrodita.sportsnewstest.mvp.eventlist.EventRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EventApi {

        /**
         * @return list of news by section
         */
        @GET("list.php")
        Call<EventArrayModel> listCategory(@Query("category") String category);

        @GET("post.php")
        Call<ArticleModel> getArticle(@Query("article")String article);

}
