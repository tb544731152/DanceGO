package com.beautifulsoup.dancego.activity;


import android.content.Context;
import android.content.Intent;
import android.nfc.tech.NfcA;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.beautifulsoup.dancego.activity.base.BaseActivity;
import com.beautifulsoup.dancego.fragment.main.GroupFragment;
import com.beautifulsoup.dancego.fragment.main.HomeFragment;
import com.beautifulsoup.dancego.fragment.main.MusicFragment;
import com.beautifulsoup.dancego.utils.ActivityController;
import com.beautifulsoup.dancego.utils.ConstantConfig;
import com.beautifulsoup.dancego.view.MainView;
import com.realfans.dancego.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements MainView{

    private ActionBar actionBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar navigationBar;


    private long mExitTime=0;

    private Fragment home_fragment;
    private Fragment group_fragment;
    private Fragment music_fragment;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        if (null!=actionBar){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu_icon);
        }

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        navigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.ic_group, "Group"))
                .addItem(new BottomNavigationItem(R.drawable.music, "Music"))
                .initialise();
        navigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
//        navigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        home_fragment=new HomeFragment();
        group_fragment=new GroupFragment();
        music_fragment=new MusicFragment();
    }

    @Override
    protected void setListener() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_login:
                        Intent intent=new Intent();
                        intent.setClass(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_logout:

                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        navigationBar.setFirstSelectedPosition(0);
        navigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                switch (position){
                    case 1:
                        transaction.replace(R.id.frame_content,group_fragment);
                        break;
                    case 2:
                        transaction.replace(R.id.frame_content,music_fragment);
                        break;
                    case 0:
                        transaction.replace(R.id.frame_content,home_fragment);
                        break;
                    default:
                    break;
                }
                transaction.commit();

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });


        setDefaultFragment();
    }


    @Override
    protected void processLogic() {

    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String message) {

    }

    private void setDefaultFragment(){
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction tx=manager.beginTransaction();
        tx.replace(R.id.frame_content,home_fragment);
        tx.commit();
    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK&&event.getAction()==KeyEvent.ACTION_DOWN) {
            if((System.currentTimeMillis()-mExitTime)> ConstantConfig.EXIT_TIME){
                Toast.makeText(mContext,"双击退出应用",Toast.LENGTH_SHORT).show();
                mExitTime=System.currentTimeMillis();
            }else {
                ActivityController.finishAll();
                if (0!=mExitTime){
                    mExitTime=0;
                }
            }
            return true;
        }
        return false;
    }

}
