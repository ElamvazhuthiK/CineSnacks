package com.cinesnacks.connections.http;

import com.android.volley.VolleyError;

/**
 * Created by Sasikumar on 2/2/2015.
 */
public interface HTTPResponseListener {

    public void handleResponse(String response);

    public void handleError(VolleyError error);
}
