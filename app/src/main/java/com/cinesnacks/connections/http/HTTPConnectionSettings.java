package com.cinesnacks.connections.http;

import com.android.volley.DefaultRetryPolicy;
import com.cinesnacks.connections.constants.ApplicationConstant;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Sasikumar on 1/29/2015.
 */
public class HTTPConnectionSettings {

    public int id;

    public static int ID_COUNTER = 1;

    private String url;
    private String request;

    private boolean post = true;
    private boolean writeRequest;

    static final int BUFF_SIZE = 4 * 1024;
    static final char[] buffer = new char[BUFF_SIZE];

    public static int READ_TIMEOUT = 15000;
    public static int CONNECTION_TIMEOUT = 15000;

    private Hashtable<String, String> requestArguments;

    private String content;

    private String contentType = "application/x-www-form-urlencoded; charset=UTF-8";
    private String requestCharset = "UTF-8";
    private String responseCharset = "UTF-8";
    private boolean fromCache;
    String cacheKey;
    int cachetime;

    public HTTPConnectionSettings() {
    }

    public void setCache(String cacheKey, int cacheTime) {
        this.cacheKey = cacheKey;
        this.cachetime = cacheTime;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public boolean isFromCache() {
        return fromCache;
    }

    public void setFromCache(boolean fromCache) {
        this.fromCache = fromCache;
    }

    public String getRequestCharset() {
        return requestCharset;
    }

    public void setRequestCharset(String requestCharset) {
        this.requestCharset = requestCharset;
    }

    public String getResponseCharset() {
        return responseCharset;
    }

    public void setResponseCharset(String responseCharset) {
        this.responseCharset = responseCharset;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public boolean isPost() {
        return post;
    }

    public void setReadTimeout(int readTimeout) {
        READ_TIMEOUT = readTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        CONNECTION_TIMEOUT = connectionTimeout;
    }

    /**
     * Returns true for a post operation and false for a get operation
     *
     * @throws IllegalStateException
     *             if invoked after an addArgument call
     */
    public void setPost(boolean post) {
        if (this.post != post && requestArguments != null
                && requestArguments.size() > 0) {
            throw new IllegalStateException(
                    "Request method (post/get) can't be modified one arguments have been assigned to the request");
        }
        this.post = post;
        if (this.post) {
            setWriteRequest(true);
        }
    }

    /**
     * @return the writeRequest
     */
    public boolean isWriteRequest() {
        return writeRequest;
    }

    /**
     * @param writeRequest
     *            the writeRequest to set
     */
    public void setWriteRequest(boolean writeRequest) {
        this.writeRequest = writeRequest;
    }

    protected String createRequestURL() {
        String url = this.url;

        // For Get Method, add the arguments
        if (!post && requestArguments != null) {
            StringBuffer b = new StringBuffer(url);
            Enumeration<String> e = requestArguments.keys();
            if (e.hasMoreElements()) {
                b.append("?");
            }
            while (e.hasMoreElements()) {
                String key = e.nextElement();
                String value = requestArguments.get(key);
                b.append(key);
                b.append("=");
                b.append(value);
                if (e.hasMoreElements()) {
                    b.append("&");
                }
            }
            return b.toString();
        }
        return url;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType
     *            the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void addArg(String key, String value) {
        if (requestArguments == null) {
            requestArguments = new Hashtable<String, String>();
        }
        if (value == null || key == null) {
            return;
        }
        requestArguments.put(key, value);
    }

    public Hashtable getRequestParams() {
        return requestArguments;
    }

      protected void buildRequestBody(HttpPost httppost)
            throws UnsupportedEncodingException, IOException {
        // if it is post
        // by default write post arguments as key value pair
        // subclass will override this method and give its respective
        // implementation e.g. json will write a json string
        // requestArguments iterate, outputstream write
        if (post) {

            StringBuffer val = new StringBuffer();

            if (requestArguments != null) {

                Enumeration e = requestArguments.keys();
                while (e.hasMoreElements()) {
                    String key = (String) e.nextElement();
                    String value = (String) requestArguments.get(key);
                    val.append(key);
                    val.append("=");
                    val.append(value);
                    if (e.hasMoreElements()) {
                        val.append("&");
                    }
                }

            } else if (request != null) {
                val = new StringBuffer(request);
            }

            StringEntity se = new StringEntity(val.toString(),
                    getRequestCharset());

            if (contentType != null)
                se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
                        contentType));

            httppost.setEntity(se);

        }
    }

    protected Object readResponse(HttpResponse httpResponse) throws Exception {

        String response = EntityUtils.toString(httpResponse.getEntity(),
                getResponseCharset());
        return response;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
