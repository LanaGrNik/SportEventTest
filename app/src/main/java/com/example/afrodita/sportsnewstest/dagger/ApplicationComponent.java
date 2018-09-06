package com.example.afrodita.sportsnewstest.dagger;

import com.example.afrodita.sportsnewstest.mvp.event.EventActivity;
import com.example.afrodita.sportsnewstest.mvp.eventlist.EventListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(EventListFragment eventListFragment);
    void inject(EventActivity eventActivity);
}
