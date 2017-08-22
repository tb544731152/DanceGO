package com.beautifulsoup.dancego.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beautifulsoup.dancego.bean.GroupList;
import com.beautifulsoup.dancego.fragment.base.BaseFragment;
import com.beautifulsoup.dancego.view.GroupView;
import com.realfans.dancego.R;

import java.util.List;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class GroupFragment extends BaseFragment implements GroupView{
    LayoutInflater inflater;
    ViewGroup container;
    View view=null;
    @Override
    protected View loadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater=inflater;
        this.container=container;
        return view;
    }

    @Override
    protected void loadData(View view) {




    }


    @Override
    public View getGroupList(GroupList groupList) {
        List<GroupList.DataBean> dataBean=groupList.getData();
        if(dataBean.size()>0){
            view=inflater.inflate(R.layout.fragment_hasgroup,container,false);
        }else{
            view=inflater.inflate(R.layout.fragment_nogroup,container,false);
        }
        return view;
    }
}
