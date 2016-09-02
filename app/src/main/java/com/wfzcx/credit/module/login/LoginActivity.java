package com.wfzcx.credit.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.tagview.TAGView;
import com.wfzcx.credit.MainActivity;
import com.wfzcx.credit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-25
 */
public class LoginActivity extends BeamBaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.btn_login)
    TAGView loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initToolbar();

        loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        });
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText("用户登录");
    }
}
