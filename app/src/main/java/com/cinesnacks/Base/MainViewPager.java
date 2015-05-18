package com.cinesnacks.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cinesnacks.news.NewsFragment;
import com.example.elamvazhuthik.cinesnacks.R;


/**
 * Created by ElamvazhuthiK on 16/04/15.
 */
public class MainViewPager extends Fragment {
    private static final String[] CONTENT = new String[] { "News", "Photos","videos" };
    private static final int NEWS_PAGE = 0;
    private static final int PHOTO_PAGE = 1;
    private static final int VIDEO_PAGE = 2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.mainviewpager_layout, container, false);
        FragmentPagerAdapter adapter = new MainPagerAdapter(getActivity().getSupportFragmentManager());

        ViewPager pager = (ViewPager)rootView.findViewById(R.id.pager);
        pager.setAdapter(adapter);



        return rootView;
    }

    class MainPagerAdapter extends FragmentPagerAdapter {
        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case NEWS_PAGE:
                    return new NewsFragment();
                case PHOTO_PAGE:
                    return new NewsFragment();
                case VIDEO_PAGE:
                    return new NewsFragment();
            }
            return new NewsFragment();
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return CONTENT[position];
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }
}
