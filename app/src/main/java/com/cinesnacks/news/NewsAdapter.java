package com.cinesnacks.news;

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
import com.cinesnacks.news.models.Post;
import com.example.elamvazhuthik.cinesnacks.R;

import java.util.List;

/**
 * Created by ElamvazhuthiK on 16/04/15.
 */
public class NewsAdapter extends ArrayAdapter<Post> {
    public NewsAdapter(Context context, List<Post> items) {
        super(context, R.layout.newsrow_layout, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theRow = theInflater.inflate(R.layout.newsrow_layout, parent, false);
        Post post = getItem(position);
        TextView title = (TextView)theRow.findViewById(R.id.textViewCellNewsTitle);
        ImageView icon = (ImageView)theRow.findViewById (R.id.newsImage);
        String url = post.getThumbnail();
        new DownloadImage(icon, new DownloadImageListener() {
            @Override
            public void gotImage(Bitmap bitmap) {
            }
            @Override
            public void gotError() {
            }
        } ).execute(url);
        title.setText(post.getTitle());
        return theRow;
    }
}
