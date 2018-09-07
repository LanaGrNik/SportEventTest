package com.example.afrodita.sportsnewstest.mvp.event.model;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.afrodita.sportsnewstest.R;

public class ArticleView extends LinearLayout {

    TextView tvHeader;
    TextView tvText;

    public ArticleView(Context context) {
        super(context);
        initComponent();
    }

    public ArticleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initComponent();
    }

    public ArticleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initComponent();
    }

    private void initComponent() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.article_view, this);
        tvHeader = findViewById(R.id.tvHeader);
        tvText = findViewById(R.id.tvText);
    }

    public void setHeader(String header) {
        tvHeader.setText(header);

    }

    public void setText(String text) {
        tvText.setText(text);

    }
}
