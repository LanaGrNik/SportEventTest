package com.example.afrodita.sportsnewstest.mvp.eventlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.afrodita.sportsnewstest.mvp.event.EventActivity;
import com.example.afrodita.sportsnewstest.EventApplication;
import com.example.afrodita.sportsnewstest.mvp.eventlist.model.EventCategoryModel;
import com.example.afrodita.sportsnewstest.R;

import java.util.ArrayList;

import javax.inject.Inject;

public class EventListFragment extends Fragment implements EventListContract.View {

    @Inject
    EventListPresenter presenter;
    ListView listView;
    ProgressBar progressBar;
    EventAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_list, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((EventApplication) getActivity().getApplication()).getComponent().inject(this);

        progressBar = view.findViewById(R.id.progressBar);

        Bundle bundle = getArguments();

        if (bundle != null) {
            Integer position = bundle.getInt("position");
            presenter.onAttach(this);
            listView = view.findViewById(R.id.listView);
            presenter.loadEventList(SportType.values()[position]);
            progressBar.setVisibility(View.VISIBLE);
        }

        initClickListener();
}


    @Override
    public void onLoadedEventList(ArrayList<EventCategoryModel> eventList) {
        adapter = new EventAdapter(getContext(),eventList);
        listView.setAdapter(adapter);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError() {
        progressBar.setVisibility(View.GONE);
        String message = "Не удалось загрузить данные";
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

   public  void initClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventCategoryModel categoryModel = adapter.getItem(position);
                Intent intent = new Intent(getActivity(), EventActivity.class);
                intent.putExtra("article", categoryModel.getArticle());
                startActivity(intent);
            }
        });
    }

}
