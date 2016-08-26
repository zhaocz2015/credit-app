package com.wfzcx.credit.module.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.beam.bijection.BeamFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.Util;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
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
public class Main2Fragment extends BeamFragment {

    private View rootView;

    @BindView(R.id.roll_pager_news)
    RollPagerView newsRollPager;

    @BindView(R.id.recycler_news)
    EasyRecyclerView newsRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_main2, container, false);
            ButterKnife.bind(this, rootView);

            initNewsRollPager();
            initNewsRecycler();

        }

        return rootView;
    }

    private void initNewsRollPager() {
        newsRollPager.setHintView(new ColorPointHintView(getContext(), getResources().getColor(R.color.blue_2196F3), Color.WHITE));
        newsRollPager.setAdapter(new LoopPagerAdapter(newsRollPager) {

            private int[] rollPages = {R.drawable.ic_roll_page_001, R.drawable.ic_roll_page_002, R.drawable.ic_roll_page_003, R.drawable.ic_roll_page_004};

            @Override
            public View getView(ViewGroup container, int position) {
                ImageView imgView = new ImageView(getContext());
                imgView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                imgView.setImageResource(rollPages[position]);
                imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                imgView.setOnClickListener(v -> {
                    JUtils.Toast("查看图片新闻");
                });

                return imgView;
            }

            @Override
            public int getRealCount() {
                return rollPages.length;
            }
        });

    }

    private void initNewsRecycler() {
        RecyclerArrayAdapter newsAdapter = new RecyclerArrayAdapter(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new NewsVHodler(parent);
            }

            class NewsVHodler extends BaseViewHolder<Map> {

                public NewsVHodler(ViewGroup parent) {
                    super(parent, R.layout.item_credit_news);
                }

                @Override
                public void setData(Map data) {

                }
            }

        };

        newsAdapter.setOnItemClickListener(position -> {
            JUtils.Toast("信用要闻");
        });

        newsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#dddddd"), Util.dip2px(getContext(), 0.5f), 0, 0);
        newsRecycler.addItemDecoration(itemDecoration);
        newsRecycler.setAdapter(newsAdapter);


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
        data.add(m5);
        newsAdapter.addAll(data);

    }
}
