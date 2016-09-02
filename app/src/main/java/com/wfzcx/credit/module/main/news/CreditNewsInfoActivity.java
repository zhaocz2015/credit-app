package com.wfzcx.credit.module.main.news;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jude.beam.expansion.BeamBaseActivity;
import com.wfzcx.credit.R;

import java.util.Map;

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
public class CreditNewsInfoActivity extends BeamBaseActivity {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_src)
    TextView tvSrc;

    private Map info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_trend_info);
        ButterKnife.bind(this);


        info = JSON.parseObject(getIntent().getStringExtra("info"), Map.class);
        initToolbar();

    }

    private void initToolbar() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText((String) info.get("title"));
        tvTitle.setText((String) info.get("title"));
        tvSrc.setText((String) info.get("src"));
        tvDate.setText((String) info.get("date"));
    }
}
