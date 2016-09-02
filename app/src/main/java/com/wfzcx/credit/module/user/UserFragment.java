package com.wfzcx.credit.module.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.beam.bijection.BeamFragment;
import com.jude.utils.JUtils;
import com.wfzcx.credit.R;
import com.wfzcx.credit.module.login.LoginActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-25
 */
public class UserFragment extends BeamFragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_user, container, false);
            ButterKnife.bind(this, rootView);

        }

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.my_star_btn, R.id.my_update_btn, R.id.my_report_btn, R.id.my_info_btn, R.id.btn_logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_star_btn:
                JUtils.Toast("我的关注");
                break;
            case R.id.my_update_btn:
                JUtils.Toast("版本更新");
                break;
            case R.id.my_report_btn:
                JUtils.Toast("我的投诉");
                break;
            case R.id.my_info_btn:
                JUtils.Toast("关于我们");
                break;
            case R.id.btn_logout:
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
                break;
        }
    }
}
