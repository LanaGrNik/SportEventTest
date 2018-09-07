package com.example.afrodita.sportsnewstest.mvp.event;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.afrodita.sportsnewstest.EventApplication;
import com.example.afrodita.sportsnewstest.R;
import com.example.afrodita.sportsnewstest.mvp.event.model.ArticleModel;
import com.example.afrodita.sportsnewstest.mvp.event.model.ArticleView;
import com.example.afrodita.sportsnewstest.mvp.event.model.SimpleArticleModel;

import javax.inject.Inject;

public class EventActivity extends Activity implements EventContract.View {
    @Inject
    EventPresenter presenter;
    TextView team1;
    TextView team2;
    TextView time;
    TextView tournament;
    LinearLayout articleGroup;
    TextView prediction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ((EventApplication) getApplication()).getComponent().inject(this);
        String article = getIntent().getStringExtra("article");

        team1 = findViewById(R.id.tvTeam1);
        team2 = findViewById(R.id.tvTeam2);
        time = findViewById(R.id.tvTime);
        tournament = findViewById(R.id.tvTournament);
        articleGroup = findViewById(R.id.llArticleGroup);
        prediction = findViewById(R.id.tvPrediction);
        presenter.onAttach(this);
        presenter.getArticle(article);
    }

    @Override
    public void onLoadedArticle(ArticleModel articleModel) {
        team1.setText(articleModel.getTeam1());
        team2.setText(articleModel.getTeam2());
        time.setText(articleModel.getTime());
        time.setText(articleModel.getTournament());

        for (SimpleArticleModel simpleArticle : articleModel.getArticle()){
            ArticleView articleVew = new ArticleView(this);
            articleVew.setHeader(simpleArticle.getHeader());
            articleVew.setHeader(simpleArticle.getText());
            articleGroup.addView(articleVew);
        }
        prediction.setText(articleModel.getPrediction());
    }
}