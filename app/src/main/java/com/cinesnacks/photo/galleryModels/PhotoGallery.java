package com.cinesnacks.photo.galleryModels;

/**
 * Created by ElamvazhuthiK on 6/7/15.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class PhotoGallery {

    @Expose
    private String status;
    @Expose
    private Post post;
    @SerializedName("previous_url")
    @Expose
    private String previousUrl;
    @SerializedName("next_url")
    @Expose
    private String nextUrl;

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The post
     */
    public Post getPost() {
        return post;
    }

    /**
     *
     * @param post
     * The post
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     *
     * @return
     * The previousUrl
     */
    public String getPreviousUrl() {
        return previousUrl;
    }

    /**
     *
     * @param previousUrl
     * The previous_url
     */
    public void setPreviousUrl(String previousUrl) {
        this.previousUrl = previousUrl;
    }

    /**
     *
     * @return
     * The nextUrl
     */
    public String getNextUrl() {
        return nextUrl;
    }

    /**
     *
     * @param nextUrl
     * The next_url
     */
    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

}
