package com.beautifulsoup.dancego.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beautifulsoup.dancego.fragment.base.BaseFragment;
import com.realfans.dancego.R;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class MusicFragment extends BaseFragment {
    @Override
    protected View loadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_music,container,false);
        return view;
    }

    @Override
    protected void loadData(View view) {

    }
}
