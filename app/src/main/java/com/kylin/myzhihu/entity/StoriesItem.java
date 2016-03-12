package com.kylin.myzhihu.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Author: kylin_gu
 * Created by: ModelGenerator on 2016/3/12
 */
public class StoriesItem implements Serializable{

    public List<String> images;
    public int type;
    public long id;
    public int gaPrefix;
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
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

    @Override
    public String toString() {
        return super.toString();
    }
}