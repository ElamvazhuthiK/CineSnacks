package com.cinesnacks.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cinesnacks.connections.http.DownloadImage;
import com.cinesnacks.connections.http.DownloadImageListener;
import com.cinesnacks.video.models.Post;
import com.example.elamvazhuthik.cinesnacks.R;

import java.util.List;

/**
 * Created by ElamvazhuthiK on 6/9/15.
 */
public class VideoAdapter extends ArrayAdapter<Post> {
    public VideoAdapter(Context context, List<Post> items) {
        super(context, R.layout.videorow_layout, items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theRow = theInflater.inflate(R.layout.videorow_layout, parent, false);
        Post post = getItem(position);
        TextView title = (TextView)theRow.findViewById(R.id.textViewVideoTitle);
        title.setText(post.getTitle());
        ImageView icon = (ImageView)theRow.findViewById (R.id.videoImage);
        new DownloadImage(icon, new DownloadImageListener() {
            @Override
            public void gotImage(Bitmap bitmap) {
            }
            @Override
            public void gotError() {
            }
        } ).execute(post.getThumbnailImages().getTieSmall().getUrl());
        return theRow;
    }
}