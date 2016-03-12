package com.kylin.myzhihu.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kylin.myzhihu.R;

import java.util.ArrayList;

/**
 * Created by kylin_gu on 2016/3/13.
 */
public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.ViewHolder>{

    private ArrayList<String> mDataSet;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public StoriesAdapter(ArrayList data){
        mDataSet = data;
    }

    public ArrayList getDataSet(){
        return mDataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stories_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        TextView tv = (TextView) v.findViewById(R.id.tv_stories_item);
        ViewHolder vh = new ViewHolder(tv);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}