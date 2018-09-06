package com.example.afrodita.sportsnewstest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SimpleListAdapter extends BaseAdapter {


    Context context;
    LayoutInflater lInflater;
    ArrayList<SimpleArticleModel> simpleList = new ArrayList<>();

    public SimpleListAdapter(Context context, ArrayList<SimpleArticleModel>simpleList) {
        this.context = context;
        this.simpleList.addAll(simpleList);
        lInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return simpleList.size();
    }

    @Override
    public SimpleArticleModel getItem(int position) {
        return simpleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        SimpleArticleModel simpleArticleModel = getItem(i);
        view = lInflater.inflate(R.layout.list_simple,parent,false);
        TextView title = view.findViewById(R.id.tvHeader);
        title.setText(simpleArticleModel.header);
        TextView coefficient = view.findViewById(R.id.tvText);
        coefficient.setText(simpleArticleModel.text);

        return view;
    }
}
