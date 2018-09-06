package com.example.afrodita.sportsnewstest.mvp.event.model;

import java.util.ArrayList;

public class ArticleModel {

    String team1;
    String team2;
    String time;
    String tournament;
    String place;
    ArrayList<SimpleArticleModel> article;
    String prediction;

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ArrayList<SimpleArticleModel>  getArticle() {
        return article;
    }

    public void setArticle(ArrayList<SimpleArticleModel>  article) {
        this.article = article;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}

