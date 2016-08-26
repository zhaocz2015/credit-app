package com.wfzcx.credit.module.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.wfzcx.credit.ui.VerticalScrollTextSwicher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
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
public class MainFragment extends BeamFragment {

    private View rootView;

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vsts_credit_notice)
    VerticalScrollTextSwicher noticeTxtSwitcher;

    @BindView(R.id.roll_pager_view)
    RollPagerView mRollPagerView;

    @BindView(R.id.recycler_news)
    EasyRecyclerView newsRecycler;

    @BindView(R.id.recycler_enterprise)
    EasyRecyclerView entsRecycler;

    @BindView(R.id.recycler_trend)
    EasyRecyclerView trendRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ButterKnife.bind(this, rootView);

            initToolbar();
            initNoticeTxtSwitcher();
            initRollPagerView();
            initNewsRecycler();
            initEntsRecycler();
            initTrendRecycler();
        }

        return rootView;
    }

    private void initToolbar() {
        toolbar.setNavigationIcon(null);
        toolbarTitle.setText(R.string.main_tab_title_main);
    }

    private void initNoticeTxtSwitcher() {
        List<String> txts = new ArrayList<>();
        txts.add("山东省社会信用体系建设联席会议办公室关于印发2016年山东省社会信用体系建设工作任务分工意见的通知");
        txts.add("关于公开征集“信用威海”标识（LOGO）的公告");
        txts.add("信用山东行政许可和行政处罚信用信息公示报送系统模板下载公告");

        noticeTxtSwitcher.setTexts(txts);
        noticeTxtSwitcher.start();

        noticeTxtSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerticalScrollTextSwicher vsts = (VerticalScrollTextSwicher) view;
                TextView tv = (TextView) vsts.getCurrentView();
                JUtils.Toast(tv.getText().toString());
            }
        });
    }

    private void initRollPagerView() {
        mRollPagerView.setHintView(new ColorPointHintView(getContext(), getResources().getColor(R.color.blue_2196F3), Color.WHITE));
        mRollPagerView.setAdapter(new LoopPagerAdapter(mRollPagerView) {

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
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#c7c7c7"), Util.dip2px(getContext(), 0.5f), 0, 0);
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
        newsAdapter.addAll(data);

    }

    private void initEntsRecycler() {
        RecyclerArrayAdapter entsAdapter = new RecyclerArrayAdapter(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new EntsVHodler(parent);
            }

            class EntsVHodler extends BaseViewHolder<Map> {

                public EntsVHodler(ViewGroup parent) {
                    super(parent, R.layout.item_credit_enterprise);
                }

                @Override
                public void setData(Map data) {

                }
            }

        };

        entsAdapter.setOnItemClickListener(position -> {
            JUtils.Toast("诚信企业");
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        entsRecycler.setLayoutManager(linearLayoutManager);
        entsRecycler.setAdapter(entsAdapter);

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
        data.add(m1);
        data.add(m2);
        data.add(m3);
        data.add(m4);
        data.add(m5);
        entsAdapter.addAll(data);
    }

    private void initTrendRecycler() {

        RecyclerArrayAdapter trendAdapter = new RecyclerArrayAdapter(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new TrendVHodler(parent);
            }

            class TrendVHodler extends BaseViewHolder<Map> {

                public TrendVHodler(ViewGroup parent) {
                    super(parent, R.layout.item_credit_trend);
                }

                @Override
                public void setData(Map data) {

                }
            }

        };

        trendAdapter.setOnItemClickListener(position -> {
            JUtils.Toast("信用动态");
        });

        trendRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#c7c7c7"), Util.dip2px(getContext(), 0.5f), 0, 0);
        trendRecycler.addItemDecoration(itemDecoration);
        trendRecycler.setAdapter(trendAdapter);


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
        trendAdapter.addAll(data);

    }

    @OnClick({R.id.ll_credit_exposure, R.id.ll_big_case, R.id.ll_mind_lib, R.id.ll_law_legula, R.id.ll_news_more, R.id.ll_enterprise_more, R.id.ll_trend_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_credit_exposure: // 信用曝光台
                JUtils.Toast("信用曝光台");
                break;
            case R.id.ll_big_case: // 重大案例
                JUtils.Toast("重大案例");
                break;
            case R.id.ll_mind_lib: //信用知识库
                JUtils.Toast("信用知识库");
                break;
            case R.id.ll_law_legula: // 法律法规
                JUtils.Toast("法律法规");
                break;
            case R.id.ll_news_more: // 信用要闻
                JUtils.Toast("信用要闻");
                break;
            case R.id.ll_enterprise_more: // 诚信企业
                JUtils.Toast("诚信企业");
                break;
            case R.id.ll_trend_more: // 信用动态
                JUtils.Toast("信用动态");
                break;
        }
    }
}
