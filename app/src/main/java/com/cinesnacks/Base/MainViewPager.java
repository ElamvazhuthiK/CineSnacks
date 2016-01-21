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
import com.cinesnacks.photo.PhotoFragment;
import com.cinesnacks.video.VideoFragment;
import com.example.elamvazhuthik.cinesnacks.R;


/**
 * Created by ElamvazhuthiK on 16/04/15.
 */
public class MainViewPager extends Fragment {
    private static final String[] CONTENT = new String[] { "News", "Photos","videos" };
    private static final int NEWS_PAGE = 0;
    private static final int PHOTO_PAGE = 1;
    private static final int VIDEO_PAGE = 2;
    MainPagerAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.mainviewpager_layout, container, false);
        adapter = new MainPagerAdapter(getActivity().getSupportFragmentManager());
        ViewPager pager = (ViewPager)rootView.findViewById(R.id.mainPager);
        pager.setAdapter(adapter);
        return rootView;
    }

    private class MainPagerAdapter extends FragmentPagerAdapter {
//        private long baseId = 0;

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case NEWS_PAGE:
                    return new NewsFragment();
                case PHOTO_PAGE:
                    return new PhotoFragment();
                case VIDEO_PAGE:
                    return new VideoFragment();
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

//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            BaseFragment fragment = (BaseFragment)super.instantiateItem(container, position);
//            fragment.loadData(container);
//            return fragment;
//        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
