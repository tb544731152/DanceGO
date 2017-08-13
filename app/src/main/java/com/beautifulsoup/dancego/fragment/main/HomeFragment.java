package com.beautifulsoup.dancego.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beautifulsoup.dancego.adapter.HomePagerAdapter;
import com.beautifulsoup.dancego.fragment.base.BaseFragment;
import com.realfans.dancego.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by BeautifulSoup on 2017/7/31.
 */

public class HomeFragment extends BaseFragment{
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

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

        View view2=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_songlibrary,null);

        List<View> views=new ArrayList<>();
        views.add(view1);
        views.add(view2);
        viewPager.setAdapter(new HomePagerAdapter(views,titles));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
