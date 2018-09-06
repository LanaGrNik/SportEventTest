package com.example.afrodita.sportsnewstest.mvp.event;

import com.example.afrodita.sportsnewstest.mvp.event.model.ArticleModel;

public interface EventContract {

    interface View{

        void onLoadedArticle(ArticleModel articleModel);
    }

    interface Presenter{

        void onAttach(View view);

        void getArticle(String article);
    }

}
