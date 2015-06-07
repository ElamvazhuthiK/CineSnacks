package com.cinesnacks.photo.galleryModels;

/**
 * Created by ElamvazhuthiK on 6/7/15.
 */
//import javax.annotation.Generated;
import android.graphics.Bitmap;

import com.cinesnacks.connections.http.DownloadImageListener;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Images {

    @Expose
    private Full full;
    @Expose
    private Thumbnail thumbnail;

    private Bitmap bitmapThumbnail;
    @Expose
    private Medium medium;
    @Expose
    private Large large;
    @SerializedName("tie-small")
    @Expose
    private TieSmall tieSmall;
    @SerializedName("tie-large")
    @Expose
    private TieLarge tieLarge;
    @Expose
    private Slider slider;

    /**
     *
     * @return
     * The full
     */
    public Full getFull() {
        return full;
    }

    /**
     *
     * @param full
     * The full
     */
    public void setFull(Full full) {
        this.full = full;
    }

    /**
     *
     * @return
     * The thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     * The thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return
     * The medium
     */
    public Medium getMedium() {
        return medium;
    }

    /**
     *
     * @param medium
     * The medium
     */
    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    /**
     *
     * @return
     * The large
     */
    public Large getLarge() {
        return large;
    }

    /**
     *
     * @param large
     * The large
     */
    public void setLarge(Large large) {
        this.large = large;
    }

    /**
     *
     * @return
     * The tieSmall
     */
    public TieSmall getTieSmall() {
        return tieSmall;
    }

    /**
     *
     * @param tieSmall
     * The tie-small
     */
    public void setTieSmall(TieSmall tieSmall) {
        this.tieSmall = tieSmall;
    }

    /**
     *
     * @return
     * The tieLarge
     */
    public TieLarge getTieLarge() {
        return tieLarge;
    }

    /**
     *
     * @param tieLarge
     * The tie-large
     */
    public void setTieLarge(TieLarge tieLarge) {
        this.tieLarge = tieLarge;
    }

    /**
     *
     * @return
     * The slider
     */
    public Slider getSlider() {
        return slider;
    }

    /**
     *
     * @param slider
     * The slider
     */
    public void setSlider(Slider slider) {
        this.slider = slider;
    }

    public void getBitmapThumbnail(final DownloadImageListener dlListener) {
//        if (bitmapThumbnail == null && thumbnail != null) {
//            new DownloadImage(new DownloadImageListener() {
//                @Override
//                public void gotImage(Bitmap bitmap) {
//                    bitmapThumbnail = bitmap;
//                    if(dlListener != null)
//                    {
//                        dlListener.gotImage(bitmap);
//                    }
//                }
//
//                @Override
//                public void gotError() {
//                    bitmapThumbnail = null;
//                    if(dlListener != null)
//                    {
//                        dlListener.gotError();
//                    }
//                }
//            }).execute(getThumbnail());
//        }
//        else {
//            if(dlListener != null)
//            {
//                dlListener.gotImage(bitmapThumbnail);
//            }
//        }
    }
    public void setBitmapThumbnail(Bitmap bitmapThumbnail) {this.bitmapThumbnail = bitmapThumbnail;}
}
