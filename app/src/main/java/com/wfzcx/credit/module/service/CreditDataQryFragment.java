package com.wfzcx.credit.module.service;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.beam.bijection.BeamFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;
import com.jude.utils.JUtils;
import com.wfzcx.credit.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class CreditDataQryFragment extends BeamFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    private View rootView;

    @BindView(R.id.recycler)
    EasyRecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_credit_data_qry, container, false);
            ButterKnife.bind(this, rootView);

            initDataRecycler();
        }

        return rootView;
    }

    private Handler handler = new Handler();
    private RecyclerArrayAdapter adapter;

    private void initDataRecycler() {
        adapter = new RecyclerArrayAdapter(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new TrendVHodler(parent);
            }

            class TrendVHodler extends BaseViewHolder<Map> {

                public TrendVHodler(ViewGroup parent) {
                    super(parent, R.layout.item_service_credit_data);
                }

                @Override
                public void setData(Map data) {

                }
            }

        };

        adapter.setOnItemClickListener(position -> {
            JUtils.Toast("信用动态");
        });


        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#c7c7c7"), Util.dip2px(getContext(), 0.5f), 0, 0);
        recycler.addItemDecoration(itemDecoration);
        recycler.setAdapter(adapter);


        recycler.setRefreshListener(this);
        recycler.setRefreshing(true);
        onRefresh();
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Map> data = new ArrayList<Map>();

                Map m1 = new HashMap();
                Map m2 = new HashMap();
                Map m3 = new HashMap();
                Map m4 = new HashMap();
                Map m5 = new HashMap();

                data.add(m1);
                data.add(m2);
                data.add(m3);
                data.add(m4);
                data.add(m5);
                adapter.addAll(data);
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.clear();

                List<Map> data = new ArrayList<Map>();

                Map m1 = new HashMap();
                Map m2 = new HashMap();
                Map m3 = new HashMap();
                Map m4 = new HashMap();
                Map m5 = new HashMap();

                data.add(m1);
                data.add(m2);
                data.add(m3);
                data.add(m4);
                data.add(m5);
                adapter.addAll(data);
            }
        }, 1000);
    }
}
