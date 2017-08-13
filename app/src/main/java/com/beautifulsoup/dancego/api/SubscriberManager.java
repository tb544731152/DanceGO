package com.beautifulsoup.dancego.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.beautifulsoup.dancego.listener.HttpDataListener;
import com.beautifulsoup.dancego.utils.ConstantConfig;

import java.lang.ref.WeakReference;

import rx.Subscriber;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class SubscriberManager<T> extends Subscriber<T> {

    private HttpDataListener onNextListener;
    private WeakReference<Context> mContext;
    private ProgressDialog progressDialog;

    //默认的构造器,内部已经指定了ProgressDialog的样式
    public SubscriberManager(HttpDataListener dataListener, Context context){
        this.onNextListener=dataListener;
        this.mContext=new WeakReference<Context>(context);
        initProgressDialog();
    }
    //自定义ProgressDialog提示文字
    public SubscriberManager(HttpDataListener mSubscriberOnNextListener, Context context, String message) {
        this.onNextListener = mSubscriberOnNextListener;
        this.mContext = new WeakReference<>(context);
        initProgressDialog(message);
    }

    //自定义ProgressDialog
    public SubscriberManager(HttpDataListener mSubscriberOnNextListener, Context context, ProgressDialog dialog) {
        this.onNextListener = mSubscriberOnNextListener;
        this.mContext = new WeakReference<>(context);
        this.progressDialog = dialog;
    }

    @Override
    public void onStart() {
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        cancelRequest();
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        Context context=this.mContext.get();
        if (null==context){
            return;
        }
        Log.i(ConstantConfig.REQUEST_ERROR, e.getMessage());
        Toast.makeText(context,"请求失败",Toast.LENGTH_SHORT).show();
        cancelRequest();
        dismissProgressDialog();
    }

    @Override
    public void onNext(T t) {
        if(onNextListener!=null){
            onNextListener.onNext(t);
        }
    }

    public void cancelRequest(){
        if(!isUnsubscribed()){
            unsubscribe();
        }
    }

    private void initProgressDialog() {
        Context context = this.mContext.get();
        if (progressDialog == null && context != null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("加载中……");
            progressDialog.setCancelable(false);
        }
    }

    private void initProgressDialog(String message) {
        Context context = this.mContext.get();
        if (progressDialog == null && context != null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
        }
    }


    private void showProgressDialog(){
        Context context=this.mContext.get();
        if(null==progressDialog||null==context){
            return;
        }
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    private void dismissProgressDialog(){
        if(null!=progressDialog&&progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }



}
