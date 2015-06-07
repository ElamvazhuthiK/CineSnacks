package com.cinesnacks.connections.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by ElamvazhuthiK on 5/17/15.
 */

public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView;
    DownloadImageListener imageListener;
    public DownloadImage(ImageView imageView, DownloadImageListener imageListener) {
        this.imageView = imageView;
        this.imageListener = imageListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected Bitmap doInBackground(String... urls) {
        String urlDisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urlDisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap image) {
        if(image != null) {
            this.imageView.setImageBitmap(image);
            this.imageListener.gotImage(image);
        }else{
            this.imageListener.gotError();
        }
    }
}

