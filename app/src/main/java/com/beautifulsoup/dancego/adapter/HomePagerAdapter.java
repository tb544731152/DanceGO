package com.beautifulsoup.dancego.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.beautifulsoup.dancego.fragment.base.BaseFragment;

import java.util.List;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class HomePagerAdapter extends PagerAdapter {
    private List<View> viewList=null;
    private String[] titles;

    public HomePagerAdapter(List<View> views,String[] titles){
        this.viewList=views;
        this.titles=titles;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=viewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
