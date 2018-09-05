package com.example.afrodita.sportsnewstest;

import android.app.Application;
import com.example.afrodita.sportsnewstest.dagger.ApplicationComponent;
import com.example.afrodita.sportsnewstest.dagger.ApplicationModule;
import com.example.afrodita.sportsnewstest.dagger.DaggerApplicationComponent;

public class EventApplication extends Application {

    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
