package com.cinesnacks.news;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.VolleyError;
import com.cinesnacks.base.BaseModel;
import com.cinesnacks.base.BaseModelListener;
import com.cinesnacks.connections.http.HTTPConnection;
import com.cinesnacks.connections.http.HTTPConnectionSettings;
import com.cinesnacks.connections.http.HTTPResponseListener;
import com.cinesnacks.news.descModels.NewsDescResponse;
import com.cinesnacks.news.models.NewsResponse;
import com.cinesnacks.news.models.Post;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ElamvazhuthiK on 15/04/15.
 */

interface NewsModelListener extends BaseModelListener
{

}
public class NewsModel extends BaseModel {
    private NewsResponse newsResponse;
    private NewsDescResponse newsDescResponse;
    private ArrayList<Bitmap> listThumbnail = new ArrayList<Bitmap>();
    NewsModel ()
    {
        con = new HTTPConnection();
        conSettings = new HTTPConnectionSettings();
    }
    //sendGetRequest(Context context, HTTPConnectionSettings connectionSettings, HTTPResponseListener listener)
    public void sendNewsRequest(Context context, String url, final NewsModelListener listener)
    {
        conSettings.setUrl(url);
        HTTPConnection.sendGetRequest(context, conSettings, new HTTPResponseListener() {
            @Override
            public void handleResponse(String response) {
                if (listener != null) {
                    Gson gson = new Gson();
                    newsResponse = gson.fromJson(response, NewsResponse.class);
                    listener.response(response);
                }
            }
            @Override
            public void handleError(VolleyError error) {
                if (listener != null) {
                    listener.error(error.getMessage());
                }
                System.out.println("News fragment handle Error");
            }
        });
    }
    public List<Post> getPosts()
    {
        return newsResponse.getPosts();
    }


    //News Description
    public void sendNewsDescRequest(Context context, String url, final NewsModelListener listener)
    {
        conSettings.setUrl(url);
        HTTPConnection.sendGetRequest(context, conSettings, new HTTPResponseListener() {
            @Override
            public void handleResponse(String response) {
                if (listener != null) {
                    Gson gson = new Gson();
                    newsDescResponse = gson.fromJson(response, NewsDescResponse.class);
                    listener.response(response);
                }
            }
            @Override
            public void handleError(VolleyError error) {
                if (listener != null) {
                    listener.error(error.getMessage());
                }
                System.out.println("News fragment handle Error");
            }
        });

    }
    public String getDescTitle()
    {
        return newsDescResponse.getPost().getTitle();
    }
    public String getDescContent()
    {
        return newsDescResponse.getPost().getContent();
    }

    public void addThumbnailImage(Bitmap bitmap)
    {
        listThumbnail.add(bitmap);
    }
    public Bitmap getThumbnailImage(int index)
    {
        return listThumbnail.get(index);
//        if(listThumbnail.size() > index) {
//            return listThumbnail.get(index);
//        }else {
//            return null;
//        }
    }
}
