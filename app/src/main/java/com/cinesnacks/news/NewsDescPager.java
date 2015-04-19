package com.cinesnacks.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elamvazhuthik.cinesnacks.R;

import java.util.ArrayList;

/**
 * Created by ElamvazhuthiK on 18/04/15.
 */
public class NewsDescPager extends Fragment {
    View rootView;
    public ArrayList<NewsModel.NewsItem> newsArrayList;
    public void setArguments(ArrayList<NewsModel.NewsItem> newsArrayList) {
        this.newsArrayList = newsArrayList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.newsdescviewpager_layout, container, false);

        FragmentPagerAdapter adapter = new NewsPagerAdapter(getActivity().getSupportFragmentManager());

        ViewPager pager = (ViewPager)rootView.findViewById(R.id.pager);
        pager.setAdapter(adapter);


        return rootView;
    }

    class NewsPagerAdapter extends FragmentPagerAdapter {
        public NewsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            NewsDescription frg = new NewsDescription();
            frg.setArguments(newsArrayList.get(position));
            return frg;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            NewsModel.NewsItem newsItem = newsArrayList.get(position);
            return newsItem.strTitle;
        }

        @Override
        public int getCount() {
            return newsArrayList.size();
        }
    }
}
