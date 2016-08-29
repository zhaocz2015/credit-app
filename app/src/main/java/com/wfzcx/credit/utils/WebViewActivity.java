package com.wfzcx.credit.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.wfzcx.credit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-29
 */
public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.wv_wx)
    WebView wxWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        wxWebView.getSettings().setJavaScriptEnabled(true);
        wxWebView.loadUrl("file:///android_asset/weixin/index.html");
    }
}
