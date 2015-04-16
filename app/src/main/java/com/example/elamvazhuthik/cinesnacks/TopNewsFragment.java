package com.example.elamvazhuthik.cinesnacks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by ElamvazhuthiK on 15/04/15.
 */
public class TopNewsFragment extends Fragment {
    View rootView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.news_layout, container, false);
        ListView listView = (ListView)rootView.findViewById(R.id.listView);
        NewsModel newsModel = new NewsModel();
        ListAdapter newsAdapter = new NewsAdapter(getActivity().getBaseContext(), newsModel.newsAryList);
        listView.setAdapter(newsAdapter);
        return rootView;
    }
}
