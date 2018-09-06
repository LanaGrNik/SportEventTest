package com.example.afrodita.sportsnewstest.mvp.event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.afrodita.sportsnewstest.R;
import com.example.afrodita.sportsnewstest.mvp.event.model.SimpleArticleModel;

import java.util.ArrayList;

public class SimpleListAdapter extends BaseAdapter {

    LayoutInflater lInflater;
    ArrayList<SimpleArticleModel> simpleList = new ArrayList<>();

    public SimpleListAdapter(Context context, ArrayList<SimpleArticleModel>simpleList) {
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
        title.setText(simpleArticleModel.getHeader());
        TextView coefficient = view.findViewById(R.id.tvText);
        coefficient.setText(simpleArticleModel.getText());

        return view;
    }
}
