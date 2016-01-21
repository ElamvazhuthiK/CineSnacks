package com.cinesnacks.base;

import com.android.volley.VolleyError;
import com.cinesnacks.connections.http.HTTPConnection;
import com.cinesnacks.connections.http.HTTPConnectionSettings;
import com.cinesnacks.connections.http.HTTPResponseListener;

/**
 * Created by ElamvazhuthiK on 5/12/15.
 */

public class BaseModel implements HTTPResponseListener {

    public HTTPConnectionSettings conSettings;
    public HTTPConnection con;
//    public void sendRequest(Context context, String url, final BaseModelListener listener)
//    {
//        // Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(context);
//        // Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
////                        System.out.print("Response is: "+ response.substring(0,500));
//                        if (listener != null) {
//                            listener.response(response);
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                if (listener != null) {
//                    listener.error(error.getMessage());
//                }
//            }
//        });
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);
//    }
//
    public void handleResponse(String response)
    {
    }
    public void handleError(VolleyError error)
    {
    }
}
