package com.wfzcx.credit.module.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.EasyRecyclerView;
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
 * @date: 2016-08-26
 */
@RequiresPresenter(CreditDataQryPresenter.class)
public class CreditDataQryFragment extends BeamListFragment<CreditDataQryPresenter, Map> {

    private View rootView;

    @BindView(R.id.recycler)
    EasyRecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
            ButterKnife.bind(this, rootView);

        }

        return rootView;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_credit_data_qry;
    }

    @Override
    public ListConfig getConfig() {
        return super.getConfig().setRefreshAble(true);
    }

    @Override
    public BaseViewHolder<Map> getViewHolder(ViewGroup parent, int viewType) {
        return new CreditKnowsVHolder(parent);
    }


}
