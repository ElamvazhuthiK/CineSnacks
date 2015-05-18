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
    ImageView bmImage;
//    ProgressDialog pDialog;

    public DownloadImage(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        pDialog = new ProgressDialog(bmImage.getContext());
//        pDialog.show();

    }

    protected Bitmap doInBackground(String... urls) {
        String urlDisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urlDisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
//            Log.e("Error", e.getMessage());
            e.printStackTrace();
//            pDialog.dismiss();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap image) {

        if(image != null){
            bmImage.setImageBitmap(image);
//            pDialog.dismiss();
//        }else{
//            pDialog.dismiss();
        }
    }
}

