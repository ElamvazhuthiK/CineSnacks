package com.cinesnacks.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.elamvazhuthik.cinesnacks.R;

/**
 * Created by ElamvazhuthiK on 15/04/15.
 */
public class NewsFragment extends Fragment {
    View rootView;
    NewsModel newsModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.news_layout, container, false);
        ListView listView = (ListView)rootView.findViewById(R.id.listView);
        newsModel = new NewsModel();
        ListAdapter newsAdapter = new NewsAdapter(getActivity().getBaseContext(), newsModel.newsAryList);
        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        NewsDescPager newsDescPager = new NewsDescPager();
                        newsDescPager.setArguments(newsModel.newsAryList);
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, newsDescPager)
                                .commit();
                    }
                }
        );
        return rootView;
    }
}
