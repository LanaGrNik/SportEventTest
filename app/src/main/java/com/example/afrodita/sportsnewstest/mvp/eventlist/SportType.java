package com.example.afrodita.sportsnewstest.mvp.eventlist;

public enum SportType {

    FOOTBALL("football"),
    HOCKEY("hockey"),
    TENNIS("tennis"),
    BASKETBALL("basketball"),
    VOLLEYBALL("volleyball"),
    CYBERSPORT("cybersport");

    String type;

    SportType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

