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

import com.cinesnacks.photo.galleryModels.Attachment;
import com.example.elamvazhuthik.cinesnacks.R;

import java.util.List;

/**
 * Created by ElamvazhuthiK on 6/11/15.
 */
public class ShowPhotoPager extends Fragment {
    View rootView;
    public List<Attachment> photosAttachmentList;
    public void setArguments(List<Attachment> photosAttachmentList) {
        this.photosAttachmentList = photosAttachmentList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.showphotoviewpager_layout, container, false);
        FragmentPagerAdapter adapter = new ShowPhotoPagerAdapter(getActivity().getSupportFragmentManager());
        ViewPager pager = (ViewPager)rootView.findViewById(R.id.showPhotoPager);
        pager.setAdapter(adapter);
        return rootView;
    }

    class ShowPhotoPagerAdapter extends FragmentPagerAdapter {
        public ShowPhotoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Attachment attachment = photosAttachmentList.get(position);
            ShowPhotoFragment frg = new ShowPhotoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("imageURL", attachment.getImages().getLarge().getUrl());
            frg.setArguments(bundle);
            return frg;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Attachment attachment = photosAttachmentList.get(position);
            return attachment.getTitle();
        }

        @Override
        public int getCount() {
            return photosAttachmentList.size();
        }
    }
}
