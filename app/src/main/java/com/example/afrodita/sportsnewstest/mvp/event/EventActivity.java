package com.example.afrodita.sportsnewstest.mvp.event;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.TextView;

import com.example.afrodita.sportsnewstest.ArticleModel;
import com.example.afrodita.sportsnewstest.EventApplication;
import com.example.afrodita.sportsnewstest.R;
import com.example.afrodita.sportsnewstest.SimpleArticleModel;
import com.example.afrodita.sportsnewstest.SimpleListAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

public class EventActivity extends Activity implements EventContract.View {
    @Inject
    EventPresenter presenter;
    TextView team1;
    TextView team2;
    TextView time;
    TextView tournament;
    ListView listView;
    TextView prediction;
    ArrayList<SimpleArticleModel> list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ((EventApplication) getApplication()).getComponent().inject(this);

        team1 = findViewById(R.id.tvTeam1);
        team2 = findViewById(R.id.tvTeam2);
        time = findViewById(R.id.tvTime);
        tournament = findViewById(R.id.tvTournament);
        listView = findViewById(R.id.list);
        prediction = findViewById(R.id.tvPrediction);

        presenter.onAttach(this);
        presenter.getArticle();



        }

    @Override
    public void onLoadedArticle(ArticleModel articleModel) {
        team1.setText(articleModel.getTeam1());
        team2.setText(articleModel.getTeam2());
        time.setText(articleModel.getTime());
        time.setText(articleModel.getTournament());
        SimpleListAdapter adapter = new SimpleListAdapter(this,articleModel.getArticle());
        listView.setAdapter(adapter);
        prediction.setText(articleModel.getPrediction());



    }
}