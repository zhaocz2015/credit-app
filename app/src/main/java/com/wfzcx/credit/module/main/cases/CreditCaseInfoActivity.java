package com.wfzcx.credit.module.main.cases;

import android.os.Bundle;
import android.widget.TextView;

import com.jude.beam.expansion.BeamBaseActivity;
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
public class CreditCaseInfoActivity extends BeamBaseActivity {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_case_info);
        ButterKnife.bind(this);

        initToolbar();

    }

    private void initToolbar() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText("案例详情");
    }
}
