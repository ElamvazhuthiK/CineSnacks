package com.cinesnacks.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        WebView webView = (WebView)theRow.findViewById (R.id.webViewVideoDesc);
        title.setText(post.getTitle());
        webView.loadData(post.getContent(), "text/html; charset=utf-8", null);


//        new DownloadImage(icon, new DownloadImageListener() {
//            @Override
//            public void gotImage(Bitmap bitmap) {
//            }
//            @Override
//            public void gotError() {
//            }
//        } ).execute(post.getThumbnail());
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
        return theRow;
    }
}