package com.beautifulsoup.dancego.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by BeautifulSoup on 2017/7/31.
 */

public abstract class BaseFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=loadFragmentView(inflater,container,savedInstanceState);
        loadData(view);
        return view;
    }

    protected abstract View loadFragmentView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState);

    protected abstract void loadData(View view);
}
