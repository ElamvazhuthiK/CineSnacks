package com.cinesnacks.connections.http;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Sasikumar on 1/27/2015.
 */
public class HTTPConnection {


    public static void sendGetRequest(Context context, HTTPConnectionSettings connectionSettings, HTTPResponseListener listener) {
        sendRequest(context, Request.Method.GET, connectionSettings, listener);
    }

    public static void sendPostRequest(Context context, HTTPConnectionSettings connectionSettings, HTTPResponseListener listener) {
        sendRequest(context, Request.Method.POST, connectionSettings, listener);
    }

    private static void sendRequest(Context context, int request, final HTTPConnectionSettings connectionSettings, final HTTPResponseListener listener) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(request, connectionSettings.getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (listener != null) {
                            listener.handleResponse(response);
                        }
//                        System.out.println("SAsikumar response=" + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (listener != null) {
                    listener.handleError(error);
                }
                error.printStackTrace();
//                System.out.println("SAsikumar error=" + error);
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                if (connectionSettings.getRequestParams() != null && connectionSettings.getRequestParams().size() > 0) {
                    return connectionSettings.getRequestParams();
                }

                return null;

            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return connectionSettings.getRequest() == null ? null : connectionSettings.getRequest().getBytes(connectionSettings.getRequestCharset());
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using ",
                            connectionSettings.getRequest());
                    return null;
                }
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
//                Read headers
                return super.parseNetworkResponse(response);
            }


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
//                Set Headers
                return super.getHeaders();
            }
        };

//        Set timeout
        RetryPolicy policy = new DefaultRetryPolicy(connectionSettings.READ_TIMEOUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}