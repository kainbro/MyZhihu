package com.kylin.myzhihu.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Author: kylin_gu
 * Created by: ModelGenerator on 2016/3/12
 *
 *     {"date":"20160312",
 *          "stories":[
 *              {"images":["http:\/\/pic4.zhimg.com\/9a8f32adc3a8e803365a3c7f8200ad93.jpg"],
 *                  "type":0,"id":7984006,"ga_prefix":"031212","title":"���� �� ����Ľ�һ������Щ��ζ��"},
 *              {"images":["http:\/\/pic2.zhimg.com\/0b1d015c695c1c7371060e3a92e905bd.jpg"],
 *                  "type":0,"id":7984315,"ga_prefix":"031211","title":"����Ĵ��۾��������ʡ�Ϊʲô�˻���������ô�ش���"}],
 *          "top_stories":[
 *              {"image":"http:\/\/pic3.zhimg.com\/1f007506e285df04e54443668027d9da.jpg","type":0,
 *                  "id":7984006,"ga_prefix":"031212","title":"���� �� ����Ľ�һ������Щ��ζ��"},
 *              {"image":"http:\/\/pic4.zhimg.com\/dd4a861159e85223bb119b324f7e460b.jpg","type":0,
 *                  "id":7990874,"ga_prefix":"031207","title":"�����ձ� 24 Сʱ���� �� 121 ���ձ��Ƽ����� 5 ƪ����"}
 *          ]
 *      }
 **
 */
public class LatestStoriesBean implements Serializable{
    public long date;
    public List<StoriesItem> stories;
    public List<TopStoriesItem> topStories;

    public List<StoriesItem> getStories() {
        return stories;
    }

    public void setStories(List<StoriesItem> stories) {
        this.stories = stories;
    }

    public List<TopStoriesItem> getTopStories() {
        return topStories;
    }

    public void setTopStories(List<TopStoriesItem> topStories) {
        this.topStories = topStories;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }


}

