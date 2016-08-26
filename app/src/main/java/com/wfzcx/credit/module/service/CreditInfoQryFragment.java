package com.wfzcx.credit.module.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.beam.bijection.BeamFragment;
import com.jude.utils.JUtils;
import com.wfzcx.credit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-26
 */
public class CreditInfoQryFragment extends BeamFragment {

    private View rootView;

    @BindView(R.id.tcl_key_words)
    TagContainerLayout mTagContainerLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_credit_info_qry, container, false);
            ButterKnife.bind(this, rootView);

            initTagContainerLayout();
        }

        return rootView;
    }

    private void initTagContainerLayout() {

        mTagContainerLayout.setTags(new String[]{"信用潍坊", "信用黑名单", "诚信企业", "信用曝光", "潍柴动力", "福田重工", "歌尔声学", "潍柴动力", "福田重工", "歌尔声学", "潍柴动力", "福田重工", "歌尔声学", "潍柴动力", "福田重工", "歌尔声学", "潍柴动力", "福田重工", "歌尔声学", "潍柴动力", "福田重工", "歌尔声学"});
        mTagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                JUtils.Toast(text);
            }

            @Override
            public void onTagLongClick(int position, String text) {

            }
        });
    }

}
