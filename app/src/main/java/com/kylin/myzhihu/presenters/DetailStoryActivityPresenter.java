package com.kylin.myzhihu.presenters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.kylin.myzhihu.utils.AppController;
import com.kylin.myzhihu.utils.MyConstant;

/**
 * Created by kylin_gu on 2016/3/13.
 */
public class DetailStoryActivityPresenter {


    private static final String TAG = "MainActivityPresenter";

    private IDetailActivityUi mUi;


    private IDetailActivityUi getUi(){
        return mUi;
    }

    public void onUiReady(IDetailActivityUi ui){
        mUi = ui;
        //register listener

        //init loading.
    }

    public void onUiUnready(){
        //ungister listener

        //cancel all the request.
        AppController.getInstance().cancelPendingRequests(MyConstant.TAG_REQ_OBJ_DETAILACTIVITY);
    }

    /**
     * http://news-at.zhihu.com/api/4/news/$storyId
     * e.g. 3892357
     * @param storyId
     */
    public void requestViewDetailStory(String storyId){
        getUi().showProgressDialog(true);
        StringRequest strReq = new StringRequest(Request.Method.GET,
                MyConstant.URL_REQUEST_STORY_BASE + storyId,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        getUi().showProgressDialog(false);
                        if (response.toString()!=null){
                            Log.d(TAG, response.toString());
                            com.alibaba.fastjson.JSONObject jObject = com.alibaba.fastjson.JSON.
                                    parseObject(response.toString());
                            getUi().showStory(jObject.get("share_url").toString());
                            getUi().updateTitleImage(jObject.get("image").toString(),
                                    AppController.getInstance().getImageLoader());
                            //jObject.get("body").toString()
                            Log.d(TAG, jObject.get("title").toString());
                            Log.d(TAG, jObject.get("image").toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        getUi().showProgressDialog(false);
                        Log.d(TAG, "requestViewDetailStory:"+error.toString());
                    }
                });
        AppController.getInstance().addToRequestQueue(strReq, MyConstant.TAG_REQ_OBJ_DETAILACTIVITY);
    }


    public interface IDetailActivityUi{
        void updateTitleImage(String url, ImageLoader imageLoader);
        void showStory(String content);
        void showProgressDialog(boolean shown);
        Context getContext();
    }
}
