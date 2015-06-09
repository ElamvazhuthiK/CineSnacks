package com.cinesnacks.video.models;

/**
 * Created by ElamvazhuthiK on 6/9/15.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Query {

    @SerializedName("ignore_sticky_posts")
    @Expose
    private Boolean ignoreStickyPosts;
    @Expose
    private String cat;
    @Expose
    private String exclude;

    /**
     *
     * @return
     * The ignoreStickyPosts
     */
    public Boolean getIgnoreStickyPosts() {
        return ignoreStickyPosts;
    }

    /**
     *
     * @param ignoreStickyPosts
     * The ignore_sticky_posts
     */
    public void setIgnoreStickyPosts(Boolean ignoreStickyPosts) {
        this.ignoreStickyPosts = ignoreStickyPosts;
    }

    /**
     *
     * @return
     * The cat
     */
    public String getCat() {
        return cat;
    }

    /**
     *
     * @param cat
     * The cat
     */
    public void setCat(String cat) {
        this.cat = cat;
    }

    /**
     *
     * @return
     * The exclude
     */
    public String getExclude() {
        return exclude;
    }

    /**
     *
     * @param exclude
     * The exclude
     */
    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

}
