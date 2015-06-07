package com.cinesnacks.photo.galleryModels;

/**
 * Created by ElamvazhuthiK on 6/7/15.
 */
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

//@Generated("org.jsonschema2pojo")
public class Post {

    @Expose
    private Integer id;
    @Expose
    private String title;
    @Expose
    private String date;
    @Expose
    private String modified;
    @Expose
    private List<Attachment> attachments = new ArrayList<Attachment>();

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     *
     * @param modified
     * The modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     *
     * @return
     * The attachments
     */
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     *
     * @param attachments
     * The attachments
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

}
