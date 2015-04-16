package com.example.elamvazhuthik.cinesnacks;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by ElamvazhuthiK on 16/04/15.
 */
public class ViewPager extends Fragment {
    private static final String[] CONTENT = new String[] { "Recent", "Artists", "Albums", "Songs", "Playlists", "Genres" };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.viewpager_layout);
//
//        FragmentPagerAdapter adapter = new GoogleMusicAdapter(getSupportFragmentManager());
//
//        android.support.v4.view.ViewPager pager = (android.support.v4.view.ViewPager)findViewById(R.id.pager);
//        pager.setAdapter(adapter);
//
//        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
//        indicator.setViewPager(pager);
    }

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.viewpager_layout, container, false);
        rootView.setBackgroundColor(5);
//        FragmentPagerAdapter adapter = new GoogleMusicAdapter(getActivity().getSupportFragmentManager());

//        android.support.v4.view.ViewPager pager = (android.support.v4.view.ViewPager)rootView.findViewById(R.id.pager);
//        pager.setAdapter(adapter);

//        TabPageIndicator indicator = (TabPageIndicator)rootView.findViewById(R.id.indicator);
//        indicator.setViewPager(pager);
//        ListView listView = (ListView)rootView.findViewById(R.id.listView);
//        NewsModel newsModel = new NewsModel();
//        ListAdapter newsAdapter = new NewsAdapter(getActivity().getBaseContext(), newsModel.newsAryList);
//        listView.setAdapter(newsAdapter);
        return rootView;
    }

//    class GoogleMusicAdapter extends FragmentPagerAdapter {
//        public GoogleMusicAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return CONTENT[position % CONTENT.length].toUpperCase();
//        }
//
//        @Override
//        public int getCount() {
//            return CONTENT.length;
//        }
//    }
}
