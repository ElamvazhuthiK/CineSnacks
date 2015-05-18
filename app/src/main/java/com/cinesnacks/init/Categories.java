package com.cinesnacks.init;

/**
 * Created by ElamvazhuthiK on 5/12/15.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

//@Generated("org.jsonschema2pojo")
public class Categories {

    //@Generated("org.jsonschema2pojo")
    public class Category {
        @Expose
        private Integer id;
        @Expose
        private String slug;
        @Expose
        private String title;
        @Expose
        private String description;
        @Expose
        private Integer parent;
        @SerializedName("post_count")
        @Expose
        private Integer postCount;

        /**
         * @return The id
         */
        public Integer getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * @return The slug
         */
        public String getSlug() {
            return slug;
        }

        /**
         * @param slug The slug
         */
        public void setSlug(String slug) {
            this.slug = slug;
        }

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * @return The parent
         */
        public Integer getParent() {
            return parent;
        }

        /**
         * @param parent The parent
         */
        public void setParent(Integer parent) {
            this.parent = parent;
        }

        /**
         * @return The postCount
         */
        public Integer getPostCount() {
            return postCount;
        }

        /**
         * @param postCount The post_count
         */
        public void setPostCount(Integer postCount) {
            this.postCount = postCount;
        }
    }
    @Expose
    private String status;
    @Expose
    private Integer count;
    @Expose
    private List<Category> categories = new ArrayList<Category>();

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
     * The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}


