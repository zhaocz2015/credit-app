package com.wfzcx.credit.module.main.trend;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListActivity;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
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
@RequiresPresenter(CreditTrendListPresenter.class)
public class CreditTrendListActivity extends BeamListActivity<CreditTrendListPresenter, Map> {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        initToolbar();
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText("信用动态");
    }

    @Override
    public int getLayout() {
        return R.layout.include_data_list;
    }

    @Override
    public BaseViewHolder<Map> getViewHolder(ViewGroup parent, int viewType) {
        return new CreditTrendVHodler(parent);
    }

    @Override
    public ListConfig getConfig() {
        return super.getConfig().setRefreshAble(true).setNoMoreAble(false);
    }
}
