package com.wfzcx.credit.module.main.ents;

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
public class CreditEntInfoActivity extends BeamBaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.tv_ent_name)
    TextView tvEntName;
    @BindView(R.id.tv_ent_user)
    TextView tvEntUser;
    @BindView(R.id.tv_ent_money)
    TextView tvEntMoney;
    @BindView(R.id.tv_ent_date)
    TextView tvEntDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_ent_info);
        ButterKnife.bind(this);

        initToolbar();
        initData();
    }

    private void initData() {
        Map entData = JSON.parseObject(getIntent().getStringExtra("info"), Map.class);
        tvEntName.setText((String) entData.get("name"));
        tvEntUser.setText((String) entData.get("user"));
        tvEntMoney.setText((String) entData.get("money"));
        tvEntDate.setText((String) entData.get("date"));
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText(getIntent().getStringExtra("title"));
    }
}
