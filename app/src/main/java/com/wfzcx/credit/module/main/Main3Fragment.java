package com.wfzcx.credit.module.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.jude.beam.bijection.BeamFragment;
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
public class Main3Fragment extends BeamFragment {

    private View rootView;

    @BindView(R.id.wv_wx)
    WebView wxWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_web_view, container, false);
            ButterKnife.bind(this, rootView);

            initWebView();
        }

        return rootView;
    }

    private void initWebView() {
        wxWebView.getSettings().setJavaScriptEnabled(true);
        wxWebView.loadUrl("file:///android_asset/weixin/index.html");
    }
}
