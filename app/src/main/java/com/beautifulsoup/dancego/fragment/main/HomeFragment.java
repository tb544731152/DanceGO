package com.beautifulsoup.dancego.fragment.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beautifulsoup.dancego.fragment.base.BaseFragment;
import com.beautifulsoup.dancego.utils.ConstantConfig;
import com.realfans.dancego.R;

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




    }


}
