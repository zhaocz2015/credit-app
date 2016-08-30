package com.wfzcx.credit.module.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
 * @date: 2016-08-25
 */
public class ServiceFragment extends BeamFragment {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab_service)
    TabLayout mTabLayout;
    @BindView(R.id.vp_service)
    ViewPager mViewPager;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_service, container, false);
            ButterKnife.bind(this, rootView);

            initToolbar();
            initViewPager();
        }

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void initToolbar() {
        toolbar.setNavigationIcon(null);
        toolbarTitle.setText(R.string.main_tab_title_service);
    }

    private void initViewPager() {

        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {

            private String[] titles = {"信用查询", "信用知识"};

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new CreditInfoQryFragment();
                    case 1:
                        return new CreditDataQryFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);

    }

}
