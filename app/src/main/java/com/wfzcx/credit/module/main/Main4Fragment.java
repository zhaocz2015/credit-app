package com.wfzcx.credit.module.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jude.beam.bijection.BeamFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.Util;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.wfzcx.credit.R;
import com.wfzcx.credit.module.main.cases.CreditCaseListActivity;
import com.wfzcx.credit.module.main.ents.CreditEntInfoActivity;
import com.wfzcx.credit.module.main.ents.CreditEntsListActivity;
import com.wfzcx.credit.module.main.expo.CreditExpoListActivity;
import com.wfzcx.credit.module.main.knows.CreditKnowsListActivity;
import com.wfzcx.credit.module.main.law.CreditLawsListActivity;
import com.wfzcx.credit.module.main.news.CreditNewsInfoActivity;
import com.wfzcx.credit.module.main.news.CreditNewsListActivity;
import com.wfzcx.credit.module.main.trend.CreditTrendListActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-26
 */
public class Main4Fragment extends BeamFragment {

    private View rootView;

    @BindView(R.id.recycler_credit_ents)
    EasyRecyclerView entsRecycler;

    @BindView(R.id.roll_pager_news)
    RollPagerView newsRollPager;

    @BindView(R.id.recycler_news)
    EasyRecyclerView newsRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_main4, container, false);
            ButterKnife.bind(this, rootView);

            initEntsRecycler();
            initNewsRollPager();
            initNewsRecycler();

        }

        ButterKnife.bind(this, rootView);
        return rootView;
    }


    private void initEntsRecycler() {
        RecyclerArrayAdapter entsAdapter = new RecyclerArrayAdapter(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new EntsVHodler(parent);
            }

            class EntsVHodler extends BaseViewHolder<Map> {

                private CircleImageView entLogo;
                private TextView entName;

                public EntsVHodler(ViewGroup parent) {
                    super(parent, R.layout.item_credit_enterprise);


                    entLogo = (CircleImageView) itemView.findViewById(R.id.civ_ent_logo);
                    entName = (TextView) itemView.findViewById(R.id.tv_ent_name);
                }

                @Override
                public void setData(Map data) {
                    entLogo.setImageResource((Integer) data.get("logo"));
                    entName.setText((String) data.get("name"));
                }
            }

        };

        String tmpStr = "[{'name':'潍坊银行股份有限公司','user':'史跃峰 ','money':'8000万元人民币','date':'1997-08-15'}," +
                "{'name':'潍柴动力股份有限公司','user':'谭旭光','money':'399861.9278万人民币','date':'2002-12-23'}," +
                "{'name':'歌尔股份有限公司','user':'姜滨','money':'152658.1348万元人民币','date':'2001-06-25'}," +
                "{'name':'潍坊人寿保险股份有限公司','user':'刘云江','money':'4000万元人民币','date':'2000-10-19'}," +
                "{'name':'潍坊世纪泰华集团有限公司','user':'王旭山','money':'7300万元人民币','date':'2015-01-14'}]";
        List<Map> data1 = JSON.parseArray(tmpStr, Map.class);

        entsAdapter.setOnItemClickListener(position -> {
            Intent i = new Intent(getContext(), CreditEntInfoActivity.class);
            i.putExtra("title", (String) data1.get(position).get("name"));
            i.putExtra("info", JSON.toJSONString(data1.get(position)));
            getContext().startActivity(i);
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        entsRecycler.setLayoutManager(linearLayoutManager);
        entsRecycler.setAdapter(entsAdapter);

        List<Map> data = new ArrayList<Map>();

        Map m1 = new HashMap();
        m1.put("logo", R.drawable.ic_ent_01);
        m1.put("name", "潍坊银行");

        Map m2 = new HashMap();
        m2.put("logo", R.drawable.ic_ent_02);
        m2.put("name", "潍柴动力 ");

        Map m3 = new HashMap();
        m3.put("logo", R.drawable.ic_ent_03);
        m3.put("name", "歌尔声学");

        Map m4 = new HashMap();
        m4.put("logo", R.drawable.ic_ent_04);
        m4.put("name", "潍坊人寿保险");

        Map m5 = new HashMap();
        m5.put("logo", R.drawable.ic_ent_05);
        m5.put("name", "潍坊世纪泰华");


        data.add(m1);
        data.add(m2);
        data.add(m3);
        data.add(m4);
        data.add(m5);
        entsAdapter.addAll(data);
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
                    Intent i = new Intent(getContext(), CreditNewsInfoActivity.class);
                    i.putExtra("info", "{title:'纳税信用体系建设重点 扩展惩戒内容 完善税收黑名单制度', src:'潍坊税务总局', date: '2016-08-27'}");
                    getContext().startActivity(i);
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

                TextView newsTitle;
                TextView newsSrc;
                TextView newsDate;

                public NewsVHodler(ViewGroup parent) {
                    super(parent, R.layout.item_credit_news);
                    newsTitle = $(R.id.tv_news_title);
                    newsSrc = $(R.id.tv_news_src);
                    newsDate = $(R.id.tv_news_date);
                }

                @Override
                public void setData(Map data) {
                    newsTitle.setText((String) data.get("title"));
                    newsSrc.setText("来源:" + (String) data.get("src"));
                    newsDate.setText((String) data.get("date"));
                }
            }

        };

        String tmpStr = "[{title:'坊子区国家税务局欠税公告决定书', src:'坊子国税局', date: '2016-08-27'}," +
                "{title:'纳税信用体系建设重点 扩展惩戒内容 完善税收黑名单制度', src:'潍坊税务总局', date: '2016-08-27'}," +
                "{title:'全面推进“五证合一、一照一码”登记制度改革工作电视电话会议在京召开', src:'工商行政管理总局', date: '2016-08-27'}," +
                "{title:'财政部办公厅关于做好政府采购有关信用主体标识码登记工作的通知', src:'财政部网站', date: '2016-08-27'}," +
                "{title:'发改委：全国信息共享平台已归集到近5亿条信息', src:'中国新闻网', date: '2016-08-27'}," +
                "{title:'食品药品监管总局关于印发食品安全信用信息管理办法的通知', src:'食品药品监管总局网站', date: '2016-08-27'}]";
        List<Map> data1 = JSON.parseArray(tmpStr, Map.class);

        newsAdapter.setOnItemClickListener(position -> {
            Intent i = new Intent(getContext(), CreditNewsInfoActivity.class);
            i.putExtra("info", JSON.toJSONString(data1.get(position)));
            getContext().startActivity(i);
        });

        newsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.parseColor("#dddddd"), Util.dip2px(getContext(), 0.5f), 0, 0);
        newsRecycler.addItemDecoration(itemDecoration);
        newsRecycler.setAdapter(newsAdapter);


        List<Map> data = new ArrayList<Map>();

        Map m1 = new HashMap();
        m1.put("title", "坊子区国家税务局欠税公告决定书");
        m1.put("src", "坊子国税局");
        m1.put("date", "2016-08-27");

        Map m2 = new HashMap();
        m2.put("title", "纳税信用体系建设重点 扩展惩戒内容 完善税收黑名单制度");
        m2.put("src", "潍坊税务总局");
        m2.put("date", "2016-08-27");

        Map m3 = new HashMap();
        m3.put("title", "全面推进“五证合一、一照一码”登记制度改革工作电视电话会议在京召开");
        m3.put("src", "工商行政管理总局");
        m3.put("date", "2016-08-26");

        Map m4 = new HashMap();
        m4.put("title", "财政部办公厅关于做好政府采购有关信用主体标识码登记工作的通知");
        m4.put("src", "财政部网站");
        m4.put("date", "2016-08-12");

        Map m5 = new HashMap();
        m5.put("title", "发改委：全国信息共享平台已归集到近5亿条信息");
        m5.put("src", "中国新闻网");
        m5.put("date", "2016-08-05");

        Map m6 = new HashMap();
        m6.put("title", "食品药品监管总局关于印发食品安全信用信息管理办法的通知");
        m6.put("src", "食品药品监管总局网站");
        m6.put("date", "2016-08-01");

        data.add(m1);
        data.add(m2);
        data.add(m3);
        data.add(m4);
        data.add(m5);
        data.add(m6);
        newsAdapter.addAll(data);

    }

    @OnClick({R.id.ll_credit_ents_more, R.id.ll_credit_news_more, R.id.tv_search_txt, R.id.ll_credit_ents, R.id.ll_credit_expo, R.id.ll_credit_pub, R.id.ll_credit_law1, R.id.ll_credit_law2, R.id.ll_credit_law3, R.id.ll_credit_trend, R.id.ll_credit_news, R.id.ll_credit_pics, R.id.ll_credit_knows, R.id.ll_credit_search, R.id.ll_knows_search, R.id.ll_credit_reply, R.id.ll_credit_report, R.id.ll_credit_notice})
    public void onClick(View view) {
        Intent i = null;
        switch (view.getId()) {
            case R.id.tv_search_txt:
                startActivity(new Intent(getContext(), CreditSearchActivity.class));
                break;
            case R.id.ll_credit_ents:
                i = new Intent(getContext(), CreditEntsListActivity.class);
                i.putExtra("title", "诚信企业");
                startActivity(i);
                break;
            case R.id.ll_credit_expo:
                startActivity(new Intent(getContext(), CreditExpoListActivity.class));
                break;
            case R.id.ll_credit_pub:
                startActivity(new Intent(getContext(), CreditCaseListActivity.class));
                break;
            case R.id.ll_credit_law1:
                startActivity(new Intent(getContext(), CreditLawsListActivity.class));
                break;
            case R.id.ll_credit_law2:
                startActivity(new Intent(getContext(), CreditLawsListActivity.class));
                break;
            case R.id.ll_credit_law3:
                startActivity(new Intent(getContext(), CreditLawsListActivity.class));
                break;
            case R.id.ll_credit_trend:
                startActivity(new Intent(getContext(), CreditTrendListActivity.class));
                break;
            case R.id.ll_credit_news:
                startActivity(new Intent(getContext(), CreditNewsListActivity.class));
                break;
            case R.id.ll_credit_pics:
                startActivity(new Intent(getContext(), CreditNewsListActivity.class));
                break;
            case R.id.ll_credit_knows:
                startActivity(new Intent(getContext(), CreditKnowsListActivity.class));
                break;

            case R.id.ll_credit_ents_more:
                i = new Intent(getContext(), CreditEntsListActivity.class);
                i.putExtra("title", "诚信企业");
                startActivity(i);
                break;
            case R.id.ll_credit_news_more:
                startActivity(new Intent(getContext(), CreditNewsListActivity.class));
                break;


            case R.id.ll_credit_search:
                startActivity(new Intent(getContext(), CreditSearchActivity.class));
                break;
            case R.id.ll_knows_search:
                startActivity(new Intent(getContext(), CreditSearchActivity.class));
                break;
            case R.id.ll_credit_reply:
                startActivity(new Intent(getContext(), CreditSearchActivity.class));
                break;
            case R.id.ll_credit_report:
                startActivity(new Intent(getContext(), CreditSearchActivity.class));
                break;
            case R.id.ll_credit_notice:
                startActivity(new Intent(getContext(), CreditSearchActivity.class));
                break;
        }
    }

}
