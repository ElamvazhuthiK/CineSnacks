package com.cinesnacks.photo.models;

/**
 * Created by ElamvazhuthiK on 5/27/15.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    private String thumbnail;
    @SerializedName("thumbnail_size")
    @Expose
    private String thumbnailSize;
    @SerializedName("thumbnail_images")
    @Expose
    private ThumbnailImages thumbnailImages;

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
     * The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     * The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return
     * The thumbnailSize
     */
    public String getThumbnailSize() {
        return thumbnailSize;
    }

    /**
     *
     * @param thumbnailSize
     * The thumbnail_size
     */
    public void setThumbnailSize(String thumbnailSize) {
        this.thumbnailSize = thumbnailSize;
    }

    /**
     *
     * @return
     * The thumbnailImages
     */
    public ThumbnailImages getThumbnailImages() {
        return thumbnailImages;
    }

    /**
     *
     * @param thumbnailImages
     * The thumbnail_images
     */
    public void setThumbnailImages(ThumbnailImages thumbnailImages) {
        this.thumbnailImages = thumbnailImages;
    }

}
