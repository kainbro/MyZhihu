package com.kylin.myzhihu.entity;

import java.io.Serializable;

/**
 * Author: kylin_gu
 * Created by: ModelGenerator on 2016/3/12
 */
public class TopStoriesItem extends AbstractStoriesItem implements Serializable{
    public String image;
    public int type;
    public long id;
    public int gaPrefix;
    public String title;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(int gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}