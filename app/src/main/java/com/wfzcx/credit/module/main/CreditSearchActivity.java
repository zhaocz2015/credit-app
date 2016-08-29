package com.wfzcx.credit.module.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;
import com.wfzcx.credit.R;
import com.wfzcx.credit.module.main.ents.CreditEntsListActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-29
 */
public class CreditSearchActivity extends BeamBaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.tv_search_txt)
    TextView tvSearchTxt;
    @BindView(R.id.tcl_hot_words)
    TagContainerLayout mTagContainerLayout;
    @BindView(R.id.recycler_hist_words)
    EasyRecyclerView histRecycelr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_search);
        ButterKnife.bind(this);

        initToolbar();
        initTagContainerLayout();
        initHistRecycler();
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText("信用查询");

        tvSearchTxt.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEND || (keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                startActivity(new Intent(CreditSearchActivity.this, CreditEntsListActivity.class));
                return true;
            }
            return false;
        });
    }

    private void initTagContainerLayout() {

        mTagContainerLayout.setTags(new String[]{"信用潍坊", "信用黑名单", "诚信企业", "信用曝光", "潍柴动力", "信用曝光", "潍柴动力", "信用曝光", "潍柴动力", "信用曝光", "潍柴动力"});
        mTagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                startActivity(new Intent(CreditSearchActivity.this, CreditEntsListActivity.class));
            }

            @Override
            public void onTagLongClick(int position, String text) {

            }
        });
    }

    private void initHistRecycler() {

        RecyclerArrayAdapter noticeAdapter = new RecyclerArrayAdapter(getApplicationContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new NewsVHodler(parent);
            }

            class NewsVHodler extends BaseViewHolder<Map> {

                private TextView histText;

                public NewsVHodler(ViewGroup parent) {
                    super(parent, R.layout.item_credit_hist);
                    histText = $(R.id.hist_text);
                }

                @Override
                public void setData(Map data) {
                    histText.setText(data.get("hist").toString());
                }
            }

        };

        noticeAdapter.setOnItemClickListener(position -> {
            startActivity(new Intent(CreditSearchActivity.this, CreditEntsListActivity.class));
        });

        histRecycelr.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#c7c7c7"), Util.dip2px(getApplicationContext(), 0.5f), 0, 0);
        histRecycelr.addItemDecoration(itemDecoration);
        histRecycelr.setAdapter(noticeAdapter);

        List<Map> data = new ArrayList<Map>();

        Map m1 = new HashMap();
        m1.put("hist", "潍坊企业");
        Map m2 = new HashMap();
        m2.put("hist", "潍柴动力");
        Map m3 = new HashMap();
        m3.put("hist", "福田重工");
        Map m4 = new HashMap();
        m4.put("hist", "歌尔声学");
        Map m5 = new HashMap();
        m5.put("hist", "中国银行");

        data.add(m1);
        data.add(m2);
        data.add(m3);
        data.add(m4);
        data.add(m5);
        noticeAdapter.addAll(data);
    }
}
