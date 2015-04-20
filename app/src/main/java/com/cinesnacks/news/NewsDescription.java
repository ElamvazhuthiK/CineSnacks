package com.cinesnacks.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elamvazhuthik.cinesnacks.R;


/**
 * Created by ElamvazhuthiK on 17/04/15.
 */
public final class NewsDescription extends Fragment {
    View rootView;
    String strNewsDesc;
//    NewsDescription(NewsModel.NewsItem newsItem)
//    {
//        strNewsDesc = newsItem.strDescription;
//    }
    public void setArguments(NewsModel.NewsItem newsItem) {
        strNewsDesc = newsItem.strDescription;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.newsdesc_layout, container, false);
        TextView newsDesc = (TextView)rootView.findViewById(R.id.textViewNewsDesc);
        newsDesc.setText(strNewsDesc);
        return rootView;
    }
}
