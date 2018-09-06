package com.example.afrodita.sportsnewstest.dagger;

import android.content.Context;

import com.example.afrodita.sportsnewstest.EventApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    Context context;

    public ApplicationModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }
    @Provides
    public EventApi provideEventApi(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mikonatoruri.win/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EventApi.class);

    }

}
