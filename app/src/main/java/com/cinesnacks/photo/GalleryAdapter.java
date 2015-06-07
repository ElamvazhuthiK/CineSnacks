package com.cinesnacks.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.cinesnacks.connections.http.DownloadImage;
import com.cinesnacks.connections.http.DownloadImageListener;
import com.cinesnacks.photo.galleryModels.Attachment;
import com.example.elamvazhuthik.cinesnacks.R;

import java.util.List;

/**
 * Created by ElamvazhuthiK on 6/7/15.
 */
public class GalleryAdapter extends ArrayAdapter<Attachment> {

    public GalleryAdapter(Context context, List<Attachment> items) {
        super(context, R.layout.photogallery_gridcellview_layout, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theCell = theInflater.inflate(R.layout.photogallery_gridcellview_layout, parent, false);
        Attachment attachment = getItem(position);
        ImageView icon = (ImageView)theCell.findViewById (R.id.image);

        new DownloadImage(icon, new DownloadImageListener() {
            @Override
            public void gotImage(Bitmap bitmap) {
            }
            @Override
            public void gotError() {
            }
        } ).execute(attachment.getImages().getThumbnail().getUrl());
//        new DownloadImage(icon, new DownloadImageListener() {
//            @Override
//            public void gotImage(Bitmap bitmap) {
//            }
//            @Override
//            public void gotError() {
//            }
//        } ).execute(images.getThumbnail());
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
//        TextView description = (TextView)theCell.findViewById(R.id.textView2);google
//        title.setText(post.getTitle());
        return theCell;
    }
}
