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

import com.cinesnacks.news.models.Post;
import com.example.elamvazhuthik.cinesnacks.R;

import java.util.List;

/**
 * Created by ElamvazhuthiK on 18/04/15.
 */
public class NewsDescPager extends Fragment {
    View rootView;
    public List<Post> newsPostList;
    public void setArguments(List<Post> newsPostList) {
        this.newsPostList = newsPostList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.newsdescviewpager_layout, container, false);
        FragmentPagerAdapter adapter = new NewsPagerAdapter(getActivity().getSupportFragmentManager());
        ViewPager pager = (ViewPager)rootView.findViewById(R.id.newsPager);
        pager.setAdapter(adapter);
        return rootView;
    }

    class NewsPagerAdapter extends FragmentPagerAdapter {
        public NewsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Post post = newsPostList.get(position);
            NewsDescription frg = new NewsDescription();
            Bundle bundle = new Bundle();
            bundle.putInt("postID", post.getId().intValue());
            frg.setArguments(bundle);
            return frg;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Post post = newsPostList.get(position);
            return post.getTitle();
        }

        @Override
        public int getCount() {
            return newsPostList.size();
        }
    }
}
