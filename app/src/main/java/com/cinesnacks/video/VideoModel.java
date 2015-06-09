package com.cinesnacks.video;

import android.content.Context;

import com.android.volley.VolleyError;
import com.cinesnacks.base.BaseModel;
import com.cinesnacks.base.BaseModelListener;
import com.cinesnacks.connections.http.HTTPConnection;
import com.cinesnacks.connections.http.HTTPConnectionSettings;
import com.cinesnacks.connections.http.HTTPResponseListener;
import com.cinesnacks.video.models.Post;
import com.cinesnacks.video.models.VideoResponse;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ElamvazhuthiK on 6/9/15.
 */

interface VideoModelListener extends BaseModelListener
{

}
public class VideoModel extends BaseModel {
    private VideoResponse videoResponse;
    VideoModel ()
    {
        con = new HTTPConnection();
        conSettings = new HTTPConnectionSettings();
    }
    //sendGetRequest(Context context, HTTPConnectionSettings connectionSettings, HTTPResponseListener listener)
    public void sendVideoRequest(Context context, String url, final VideoModelListener listener)
    {
        conSettings.setUrl(url);
        HTTPConnection.sendGetRequest(context, conSettings, new HTTPResponseListener() {
            @Override
            public void handleResponse(String response) {
                if (listener != null) {
                    Gson gson = new Gson();
                    videoResponse = gson.fromJson(response, VideoResponse.class);
                    listener.response(response);
                }
            }
            @Override
            public void handleError(VolleyError error) {
                if (listener != null) {
                    listener.error(error.getMessage());
                }
                System.out.println("Video fragment handle Error");
            }
        });
    }
    public List<Post> getPosts()
    {
        return videoResponse.getPosts();
    }
}