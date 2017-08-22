package com.beautifulsoup.dancego.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beautifulsoup.dancego.bean.GroupList;
import com.beautifulsoup.dancego.view.base.BaseView;

/**
 * Created by BeautifulSoup on 2017/8/20.
 */

public interface GroupView extends BaseView {


    View getGroupList(GroupList groupList);


}
