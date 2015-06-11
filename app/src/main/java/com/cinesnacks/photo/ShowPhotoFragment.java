package com.cinesnacks.photo;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cinesnacks.connections.http.DownloadImage;
import com.cinesnacks.connections.http.DownloadImageListener;
import com.example.elamvazhuthik.cinesnacks.R;

/**
 * Created by ElamvazhuthiK on 6/11/15.
 */
public class ShowPhotoFragment extends Fragment {
    View rootView;
    String imageURL;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        this.imageURL = args.getString("imageURL");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.showphoto_layout, container, false);
        ImageView icon = (ImageView)rootView.findViewById (R.id.showImage);
        new DownloadImage(icon, new DownloadImageListener() {
            @Override
            public void gotImage(Bitmap bitmap) {
            }
            @Override
            public void gotError() {
            }
        } ).execute(this.imageURL);
        return rootView;
    }
}


