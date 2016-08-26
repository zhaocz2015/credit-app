package com.wfzcx.credit.module.interact;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.beam.bijection.BeamFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;
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
public class InteractFragment extends BeamFragment {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vsts_credit_notice)
    VerticalScrollTextSwicher noticeTxtSwitcher;

    @BindView(R.id.recycler_notice)
    EasyRecyclerView noticeRecycler;
    @BindView(R.id.recycler_reply)
    EasyRecyclerView replyRecycler;
    @BindView(R.id.recycler_report)
    EasyRecyclerView reportRecycler;

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_interact, container, false);
            ButterKnife.bind(this, rootView);

            initToolbar();
            initNoticeTxtSwitcher();
            initNoticeRecycelr();
            initReplyRecycelr();
            initReportRecycelr();
        }

        return rootView;
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

    private void initNoticeRecycelr() {
        RecyclerArrayAdapter noticeAdapter = new RecyclerArrayAdapter(getContext()) {
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

        noticeAdapter.setOnItemClickListener(position -> {
            JUtils.Toast("信用要闻");
        });

        noticeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#c7c7c7"), Util.dip2px(getContext(), 0.5f), 0, 0);
        noticeRecycler.addItemDecoration(itemDecoration);
        noticeRecycler.setAdapter(noticeAdapter);


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
        noticeAdapter.addAll(data);
    }

    private void initReplyRecycelr() {
        RecyclerArrayAdapter noticeAdapter = new RecyclerArrayAdapter(getContext()) {
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

        noticeAdapter.setOnItemClickListener(position -> {
            JUtils.Toast("信用要闻");
        });

        replyRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#c7c7c7"), Util.dip2px(getContext(), 0.5f), 0, 0);
        replyRecycler.addItemDecoration(itemDecoration);
        replyRecycler.setAdapter(noticeAdapter);


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
        noticeAdapter.addAll(data);
    }

    private void initReportRecycelr() {
        RecyclerArrayAdapter noticeAdapter = new RecyclerArrayAdapter(getContext()) {
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

        noticeAdapter.setOnItemClickListener(position -> {
            JUtils.Toast("信用要闻");
        });

        reportRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#c7c7c7"), Util.dip2px(getContext(), 0.5f), 0, 0);
        reportRecycler.addItemDecoration(itemDecoration);
        reportRecycler.setAdapter(noticeAdapter);


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
        noticeAdapter.addAll(data);
    }

    private void initToolbar() {
        toolbar.setNavigationIcon(null);
        toolbarTitle.setText(R.string.main_tab_title_interact);
    }

    @OnClick({R.id.ll_notice_more, R.id.ll_reply_more, R.id.ll_report_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_notice_more:
                break;
            case R.id.ll_reply_more:
                break;
            case R.id.ll_report_more:
                break;
        }
    }
}
