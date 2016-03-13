package com.kylin.myzhihu.utils;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.kylin.myzhihu.R;
import com.kylin.myzhihu.entity.AbstractStoriesItem;
import com.kylin.myzhihu.entity.StoriesItem;

import java.util.List;

/**
 * Created by kylin_gu on 2016/3/13.
 */
public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.ViewHolder>{

    private List<? extends AbstractStoriesItem> mDataSet;
    private CustomItemClickListener itemClickListener;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public TextView mTvTitle;
        public ImageView mIvPic;
        public ViewHolder(View v) {
            super(v);
            mCardView = (CardView) v.findViewById(R.id.item_cardview);
            mTvTitle = (TextView) v.findViewById(R.id.tv_story_title);
            mIvPic = (ImageView) v.findViewById(R.id.iv_story_pic);
        }
    }

    public interface CustomItemClickListener{
        void onItemClick(View v, int postion);
    }

    public StoriesAdapter(List<?extends AbstractStoriesItem> data, CustomItemClickListener listener){
        mDataSet = data;
        itemClickListener = listener;
    }

    public List<? extends AbstractStoriesItem> getDataSet(){
        return mDataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stories_item, parent, false);
        final ViewHolder mViewHolder = new ViewHolder(v);
        mViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 itemClickListener.onItemClick(v, mViewHolder.getAdapterPosition());
            }
        });
        return mViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        StoriesItem story = (StoriesItem)mDataSet.get(position);
        holder.mCardView.setTag(((StoriesItem) mDataSet.get(position)).getId());
        // Loading image with placeholder and error image
        // Display the first image defaultly if there's more than one pic.
        AppController.getInstance().getImageLoader().get(story.getImages().get(0),
                ImageLoader.getImageListener(holder.mIvPic, android.R.drawable.stat_sys_download,
                        android.R.drawable.stat_notify_error));
        //holder.mIvPic.setImageResource(R.drawable.ic_menu_gallery);
        //// If you are using NetworkImageView
        //imgNetWorkView.setImageUrl(Const.URL_IMAGE, imageLoader);
        holder.mTvTitle.setText(story.getTitle());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}