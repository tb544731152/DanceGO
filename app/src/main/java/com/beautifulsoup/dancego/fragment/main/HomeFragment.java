package com.beautifulsoup.dancego.fragment.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.beautifulsoup.dancego.activity.VideoPlayerActivity;
import com.beautifulsoup.dancego.adapter.HomePagerAdapter;
import com.beautifulsoup.dancego.adapter.SongItemAdapter;
import com.beautifulsoup.dancego.adapter.VideoItemAdapter;
import com.beautifulsoup.dancego.bean.Music;
import com.beautifulsoup.dancego.bean.Video;
import com.beautifulsoup.dancego.fragment.base.BaseFragment;
import com.beautifulsoup.dancego.listener.GroupListener;
import com.beautifulsoup.dancego.presenter.HomePresenter;
import com.beautifulsoup.dancego.presenter.impl.HomePresenterImpl;
import com.beautifulsoup.dancego.utils.ConstantConfig;
import com.beautifulsoup.dancego.utils.ResourceUtil;
import com.beautifulsoup.dancego.view.HomeView;
import com.gavin.com.library.StickyDecoration;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.realfans.dancego.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by BeautifulSoup on 2017/7/31.
 */

public class HomeFragment extends BaseFragment implements HomeView{

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private RecyclerView rv_learn_dance;
    private RecyclerView rv_songlist;


    private HomePresenter homePresenter=null;
    private boolean isFirst=true;

    private List<Video.DataBean.VideosBean> videosList=new ArrayList<>();


    @Override
    protected View loadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    protected void loadData(View view) {
        String[] titles=new String[]{"团体舞视频","舞曲库"};
        tabLayout.setupWithViewPager(viewPager);

        View view1=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_video,null);
        rv_learn_dance=(RecyclerView) view1.findViewById(R.id.rv_learn_video);



        View view2=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_songlibrary,null);
        rv_songlist=(RecyclerView) view2.findViewById(R.id.rv_songlist);


        List<View> views=new ArrayList<>();
        views.add(view1);
        views.add(view2);
        viewPager.setAdapter(new HomePagerAdapter(views,titles));



        homePresenter=new HomePresenterImpl(this,getActivity());


      viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==1){
                    if(isFirst){
//                        getActivity().findViewById(R.id.md_search_view).setVisibility(View.GONE);
                    }else {
                        getActivity().findViewById(R.id.md_search_view).setVisibility(View.VISIBLE);

                    }
                    isFirst=false;
                }else{
                    getActivity().findViewById(R.id.md_search_view).setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getVideo(ConstantConfig.GET_VIDEO);
        getMusic(ConstantConfig.GET_MUSIC);
    }

    @Override
    public void getVideo(String url) {
        videosList.clear();
        homePresenter.getVideo(url);
    }

    @Override
    public void getMusic(String url) {
        homePresenter.getMusic(url);
    }

    @Override
    public void setLearnDanceData(final Video video){
        for(int i=0;i<video.getData().size();i++){
            videosList.addAll(video.getData().get(i).getVideos());
        }

        VideoItemAdapter videoItemAdapter=new VideoItemAdapter(getActivity(),0);
        videoItemAdapter.setVideo(videosList);
        videoItemAdapter.setVideoItemSelected(new VideoItemAdapter.VideoItemSelected() {
            @Override
            public void selectedVideo(int pos) {
                Intent intent=new Intent(getActivity(), VideoPlayerActivity.class);
                intent.putExtra("video_url",videosList.get(pos).getVideourl());
                startActivity(intent);
            }
        });

        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        rv_learn_dance.setAdapter(videoItemAdapter);
        rv_learn_dance.setLayoutManager(layoutManager);

/*        rv_learn_dance.addItemDecoration(StickyDecoration.Builder.init(new com.gavin.com.library.listener.GroupListener() {
            @Override
            public String getGroupName(int position) {
                if (videosList.size()>position){
//                    return video.getData().get(position).getColumnname();
                    return videosList.get(position).getTitle();
                }
                return null;
            }
        }).setGroupTextColor(Color.BLACK).setGroupHeight((int) ResourceUtil.dp2px(getActivity(),40))
                .setTextSideMargin((int) ResourceUtil.dp2px(getActivity(),10))
                .isAlignLeft(true)

                .build());*/

    }

    @Override
    public void setSongListData(Music music) {
        SongItemAdapter songItemAdapter=new SongItemAdapter(getActivity());
        songItemAdapter.setMusic(music);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_songlist.setLayoutManager(manager);
        rv_songlist.setAdapter(songItemAdapter);
    }


}
