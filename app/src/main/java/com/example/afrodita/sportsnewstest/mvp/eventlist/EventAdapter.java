package com.example.afrodita.sportsnewstest.mvp.eventlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.afrodita.sportsnewstest.R;
import com.example.afrodita.sportsnewstest.mvp.eventlist.model.EventCategoryModel;

import java.util.ArrayList;

public class EventAdapter extends BaseAdapter{

    Context context;
    LayoutInflater lInflater;
    ArrayList<EventCategoryModel> listCategory = new ArrayList<>();


    public EventAdapter(Context context, ArrayList<EventCategoryModel> listCategory) {
        this.context = context;
        this.listCategory.addAll(listCategory);
        lInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return listCategory.size();
    }

    @Override
    public EventCategoryModel getItem(int position) {
        return listCategory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        EventCategoryModel categoryModel = getItem(i);
        view = lInflater.inflate(R.layout.list_event,parent,false);
        TextView title = view.findViewById(R.id.tTitle);
        title.setText(categoryModel.getTitle());
        TextView coefficient = view.findViewById(R.id.tCoefficient);
        coefficient.setText(categoryModel.getCoefficient());
        TextView time = view.findViewById(R.id.tTime);
        time.setText(categoryModel.getTime());
        TextView place = view.findViewById(R.id.tPlace);
        place.setText(categoryModel.getPlace());
        TextView preview = view.findViewById(R.id.tPreview);
        preview.setText(categoryModel.getPreview());
        TextView article = view.findViewById(R.id.tArticle);
        article.setText(categoryModel.getArticle());

        return view;

    }
    }

