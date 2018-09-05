package com.example.afrodita.sportsnewstest.mvp.eventlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.afrodita.sportsnewstest.EventAdapter;
import com.example.afrodita.sportsnewstest.EventApplication;
import com.example.afrodita.sportsnewstest.EventCategoryModel;
import com.example.afrodita.sportsnewstest.R;
import com.example.afrodita.sportsnewstest.mvp.SportType;

import java.util.ArrayList;

import javax.inject.Inject;

public class EventListFragment extends Fragment implements EventListContract.View {

    @Inject
    EventListPresenter presenter;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_list, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((EventApplication) getActivity().getApplication()).getComponent().inject(this);

        Bundle bundle = getArguments();

        if (bundle != null) {
            Integer position = bundle.getInt("position");
            presenter.onAttach(this);
            listView = (ListView) view.findViewById(R.id.listView);
            presenter.loadEventList(SportType.values()[position]);
        }


    }


    @Override
    public void onLoadedEventList(ArrayList<EventCategoryModel> eventList) {

        EventAdapter adapter = new EventAdapter(getContext(),eventList);
        listView.setAdapter(adapter);
    }
}
