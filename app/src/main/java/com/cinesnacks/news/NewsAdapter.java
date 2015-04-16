package com.cinesnacks.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.elamvazhuthik.cinesnacks.R;

import java.util.ArrayList;

/**
 * Created by ElamvazhuthiK on 16/04/15.
 */
public class NewsAdapter extends ArrayAdapter<NewsModel.NewsItem> {
    public NewsAdapter(Context context, ArrayList<NewsModel.NewsItem> items) {
        super(context, R.layout.newsrow_layout, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theRow = theInflater.inflate(R.layout.newsrow_layout, parent, false);
        NewsModel.NewsItem newsItem = getItem(position);
        TextView title = (TextView)theRow.findViewById(R.id.textView1);
        TextView description = (TextView)theRow.findViewById(R.id.textView2);

        title.setText(newsItem.strTitle);
        description.setText(newsItem.strDescription);
        return theRow;
    }
}
