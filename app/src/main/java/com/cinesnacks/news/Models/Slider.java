package com.cinesnacks.news.models;

/**
 * Created by ElamvazhuthiK on 5/14/15.
 */
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

//@Generated("org.jsonschema2pojo")
public class Slider {

    @Expose
    private String url;
    @Expose
    private Integer width;
    @Expose
    private Integer height;

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

}
