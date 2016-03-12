package com.kylin.myzhihu.presenters;

import android.util.Log;

import com.alibaba.fastjson.TypeReference;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.kylin.myzhihu.entity.LatestStoriesBean;
import com.kylin.myzhihu.entity.StoriesItem;
import com.kylin.myzhihu.utils.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kylin_gu on 2016/3/12.
 */
public class MainActivityPresenter {

    private static final String TAG = "MainActivityPresenter";

    private IMainActivityUi mUi;
    // Tag used to cancel the request
    static final String tag_json_obj = "json_obj_req";
//    String url = "http://api.androidhive.info/volley/person_object.json";
    String url = "http://news-at.zhihu.com/api/4/news/latest";

    private IMainActivityUi getUi(){
        return mUi;
    }

    public void onUiReady(IMainActivityUi ui){
        mUi = ui;
        //register listener
    }

    public void onUiUnready(){
        //ungister listener
    }

    public void requestLatestStories(){
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, "",
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        LatestStoriesBean bean = parseLatestJsonStories(response);
                        getUi().updateTopStories(bean.getTopStories());
                        getUi().updateStories(bean.getStories());

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "requestLatestStories: Error: " + error.getMessage());
                    }
                });

        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    private LatestStoriesBean parseLatestJsonStories(JSONObject jObject){

        if (jObject == null) return null;

        LatestStoriesBean mBean;
        mBean = com.alibaba.fastjson.JSON.parseObject(jObject.toString(), LatestStoriesBean.class);
        Log.d(TAG, "parseLatestJsonStories: fastjson date = " + mBean.getDate());
        Log.d(TAG, "parseLatestJsonStories: fastjson title = " + mBean.getStories().get(0).getTitle());
        return mBean;
    }

    public interface IMainActivityUi{
        void updateTopStories(List topStories);
        void updateStories(List stories);
    }

}
