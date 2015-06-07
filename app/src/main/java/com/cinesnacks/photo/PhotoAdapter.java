package com.cinesnacks.photo;

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
import com.cinesnacks.photo.models.Post;
import com.example.elamvazhuthik.cinesnacks.R;

import java.util.List;

/**
 * Created by ElamvazhuthiK on 4/24/15.
 */
public class PhotoAdapter extends ArrayAdapter<Post> {
    public PhotoAdapter(Context context, List<Post> items) {
        super(context, R.layout.newsrow_layout, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theRow = theInflater.inflate(R.layout.newsrow_layout, parent, false);
        Post post = getItem(position);
        TextView title = (TextView)theRow.findViewById(R.id.textViewTitle);
        ImageView icon = (ImageView)theRow.findViewById (R.id.image);

        new DownloadImage(icon, new DownloadImageListener() {
            @Override
            public void gotImage(Bitmap bitmap) {
            }
            @Override
            public void gotError() {
            }
        } ).execute(post.getThumbnail());
//        Bitmap bitmap = post.getBitmapThumbnail();
//        if(bitmap != null) {
//            icon.setImageBitmap(bitmap);
//        }else {
//            new DownloadImage(icon, new DownloadImageListener() {
//                @Override
//                public void gotImage(Bitmap bitmap) {
//                    icon.setImageBitmap(bitmap);
//                }
//                @Override
//                public void gotError() {
//
//                }
//            } ).execute(post.getThumbnail());
//        }
//        TextView description = (TextView)theRow.findViewById(R.id.textView2);google
        title.setText(post.getTitle());
        return theRow;
    }
}
