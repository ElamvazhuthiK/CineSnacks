package com.cinesnacks.photo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cinesnacks.photo.models.Post;
import com.example.elamvazhuthik.cinesnacks.R;

import java.util.List;

/**
 * Created by ElamvazhuthiK on 4/24/15.
 */
public class GalleryViewPager extends Fragment {
    View rootView;
    int currentPosition;
    public List<Post> photosPostList;
    public void setArguments(List<Post> photosPostList, int position) {
        currentPosition = position;
        this.photosPostList = photosPostList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.photogalleryviewpager_layout, container, false);
        FragmentPagerAdapter adapter = new PhotosPagerAdapter(getActivity().getSupportFragmentManager());
        ViewPager pager = (ViewPager)rootView.findViewById(R.id.galleryPager);
        pager.setAdapter(adapter);
        pager.setCurrentItem(currentPosition, true);
        return rootView;
    }

    class PhotosPagerAdapter extends FragmentPagerAdapter {
        public PhotosPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Post post = photosPostList.get(position);
            GalleryFragment frg = new GalleryFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("postID", post.getId().intValue());
            frg.setArguments(bundle);
            return frg;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Post post = photosPostList.get(position);
            return post.getTitle();
        }

        @Override
        public int getCount() {
            return photosPostList.size();
        }
    }

}
