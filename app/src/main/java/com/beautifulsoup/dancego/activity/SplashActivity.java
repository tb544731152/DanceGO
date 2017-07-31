package com.beautifulsoup.dancego.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.beautifulsoup.dancego.utils.ConstantConfig;
import com.bumptech.glide.Glide;
import com.realfans.dancego.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by BeautifulSoup on 2017/7/31.
 */

public class SplashActivity extends AppCompatActivity {

    private static final int ANIMATION_DURATION=2000;
    @BindView(R.id.iv_splash)
    ImageView iv_splash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        Glide.with(this).load(ConstantConfig.SPLASH_IMAGE).error(R.drawable.splash_base).into(iv_splash);
        animateImage();
    }

    private void animateImage(){

        ObjectAnimator animatorX=ObjectAnimator.ofFloat(iv_splash,"scaleX",1f,1.13f);
        ObjectAnimator animatorY=ObjectAnimator.ofFloat(iv_splash,"scaleY",1f,1.13f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        });

    }




}
