package com.example.afrodita.sportsnewstest.mvp.event;

import com.example.afrodita.sportsnewstest.ArticleModel;

public class EventContract {

    interface View{

        void onLoadedArticle(ArticleModel articleModel);
    }

    interface Presenter{

        void onAttach(View view);

        void getArticle();
    }

}
