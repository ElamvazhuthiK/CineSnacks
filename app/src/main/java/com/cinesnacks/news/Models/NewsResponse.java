package com.cinesnacks.news.models;

/**
 * Created by ElamvazhuthiK on 5/14/15.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

//@Generated("org.jsonschema2pojo")
public class NewsResponse {

    @Expose
    private String status;
    @Expose
    private Integer count;
    @SerializedName("count_total")
    @Expose
    private Integer countTotal;
    @Expose
    private Integer pages;
    @Expose
    private List<Post> posts = new ArrayList<Post>();

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
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The countTotal
     */
    public Integer getCountTotal() {
        return countTotal;
    }

    /**
     *
     * @param countTotal
     * The count_total
     */
    public void setCountTotal(Integer countTotal) {
        this.countTotal = countTotal;
    }

    /**
     *
     * @return
     * The pages
     */
    public Integer getPages() {
        return pages;
    }

    /**
     *
     * @param pages
     * The pages
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     *
     * @return
     * The posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     *
     * @param posts
     * The posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
