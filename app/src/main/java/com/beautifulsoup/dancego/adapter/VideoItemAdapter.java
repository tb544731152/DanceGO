package com.beautifulsoup.dancego.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beautifulsoup.dancego.bean.Video;
import com.bumptech.glide.Glide;
import com.realfans.dancego.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class VideoItemAdapter extends RecyclerView.Adapter<VideoItemAdapter.ViewHolder> {



    private Context mContext;
    private int item_position;
    private VideoItemSelected videoItemSelected;
    private List<Video.DataBean.VideosBean> videoList;



    public VideoItemAdapter(Context context,int item_position){
        this.mContext=context;
        this.item_position=item_position;
    }

    public void setVideo(List<Video.DataBean.VideosBean> videoList){
        this.videoList=videoList;
        this.notifyDataSetChanged();
    }

    public void setVideoItemSelected(VideoItemSelected videoItemSelected) {
        this.videoItemSelected = videoItemSelected;
    }

    @Override
    public VideoItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_video,parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(VideoItemAdapter.ViewHolder holder, final int position) {
        holder.tv_video_title.setText(videoList.get(position).getTitle());
        Glide.with(mContext).load(videoList.get(position).getImgurl()).into(holder.bg_video_image);

        holder.bg_video_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=videoItemSelected){
                    videoItemSelected.selectedVideo(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView bg_video_image;
        TextView tv_video_title;
        View rootView;
        public ViewHolder(View itemView) {
            super(itemView);
            rootView=itemView;
            bg_video_image= (ImageView) itemView.findViewById(R.id.bg_video_image);
            tv_video_title= (TextView) itemView.findViewById(R.id.tv_video_title);
        }
    }

    public interface VideoItemSelected{
        void selectedVideo(int pos);
    }
}
