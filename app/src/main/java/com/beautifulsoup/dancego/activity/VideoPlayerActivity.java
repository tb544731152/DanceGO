package com.beautifulsoup.dancego.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

import com.beautifulsoup.dancego.activity.base.BaseActivity;
import com.realfans.dancego.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public class VideoPlayerActivity extends BaseActivity {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_videoplay);
        ButterKnife.bind(this);

//        webView.setWebViewClient(new WebViewClient());
        WebSettings settings=webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/video.html");
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic() {
        Intent intent=getIntent();
        String videoURL=intent.getStringExtra("video_url");
        if(null!=videoURL){
            Uri uri=Uri.parse(videoURL);
            webView.loadUrl("javascript:setUrl("+videoURL+")");


        }

    }

    @Override
    protected Context getActivityContext() {
        return this;
    }
}
