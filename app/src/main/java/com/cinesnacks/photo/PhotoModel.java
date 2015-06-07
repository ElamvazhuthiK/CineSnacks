package com.cinesnacks.photo;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.VolleyError;
import com.cinesnacks.base.BaseModel;
import com.cinesnacks.base.BaseModelListener;
import com.cinesnacks.connections.http.HTTPConnection;
import com.cinesnacks.connections.http.HTTPConnectionSettings;
import com.cinesnacks.connections.http.HTTPResponseListener;
//import com.cinesnacks.photo.descModels.NewsDescResponse;
import com.cinesnacks.photo.models.Post;
import com.cinesnacks.photo.models.PhotosEventsResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ElamvazhuthiK on 4/24/15.
 */

interface PhotoModelListener extends BaseModelListener
{

}
public class PhotoModel extends BaseModel {
    private PhotosEventsResponse photoResponse;
//    private NewsDescResponse newsDescResponse;
    private ArrayList<Bitmap> listThumbnail = new ArrayList<Bitmap>();
    PhotoModel ()
    {
        con = new HTTPConnection();
        conSettings = new HTTPConnectionSettings();
    }
    //sendGetRequest(Context context, HTTPConnectionSettings connectionSettings, HTTPResponseListener listener)
    public void sendPhotoRequest(Context context, String url, final PhotoModelListener listener)
    {
        conSettings.setUrl(url);
        HTTPConnection.sendGetRequest(context, conSettings, new HTTPResponseListener() {
            @Override
            public void handleResponse(String response) {
                if (listener != null) {
                    Gson gson = new Gson();
                    photoResponse = gson.fromJson(response, PhotosEventsResponse.class);
                    listener.response(response);
                }
            }
            @Override
            public void handleError(VolleyError error) {
                if (listener != null) {
                    listener.error(error.getMessage());
                }
                System.out.println("Photo fragment handle Error");
            }
        });
    }
    public List<Post> getPosts()
    {
        return photoResponse.getPosts();
    }
}
