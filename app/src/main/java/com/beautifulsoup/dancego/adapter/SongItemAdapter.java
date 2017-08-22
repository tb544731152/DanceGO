package com.beautifulsoup.dancego.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beautifulsoup.dancego.bean.Music;
import com.realfans.dancego.R;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public class SongItemAdapter extends RecyclerView.Adapter<SongItemAdapter.ViewHolder> {

    private Music music;
    private Context mContext;

    public SongItemAdapter(Context mContext){
        this.mContext=mContext;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @Override
    public SongItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(mContext).inflate(R.layout.item_songlist,parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SongItemAdapter.ViewHolder holder, int position) {

        int size=music.getData().get(position).getMusicsize();
        int time=music.getData().get(position).getTimelength();

        holder.tv_song_name.setText("舞曲名:"+music.getData().get(position).getMusicname());
        holder.tv_song_size.setText("大小:"+size/1024/1024+"."+size/1024%1024+"m");
        holder.tv_song_time.setText("时长:"+time/60+":"+time%60);
    }

    @Override
    public int getItemCount() {
        return music.getData().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_song_name;
        TextView tv_song_size;
        TextView tv_song_time;
        ImageView iv_add;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_song_name= (TextView) itemView.findViewById(R.id.tv_song_name);
            tv_song_size= (TextView) itemView.findViewById(R.id.tv_song_size);
            tv_song_time= (TextView) itemView.findViewById(R.id.tv_song_time);
            iv_add= (ImageView) itemView.findViewById(R.id.iv_add);
        }
    }

}
