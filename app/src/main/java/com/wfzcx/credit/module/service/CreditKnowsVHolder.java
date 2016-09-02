package com.wfzcx.credit.module.service;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wfzcx.credit.R;
import com.wfzcx.credit.module.main.news.CreditNewsInfoActivity;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-30
 */
public class CreditKnowsVHolder extends BaseViewHolder<Map> {
    @BindView(R.id.tv_news_title)
    TextView tvNewsTitle;
    @BindView(R.id.tv_news_src)
    TextView tvNewsSrc;
    @BindView(R.id.tv_news_date)
    TextView tvNewsDate;

    Map info;

    public CreditKnowsVHolder(ViewGroup parent) {
        super(parent, R.layout.item_credit_news);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), CreditNewsInfoActivity.class);
            intent.putExtra("info", JSON.toJSONString(info));
            getContext().startActivity(intent);
        });
    }

    @Override
    public void setData(Map data) {
        info = data;

        tvNewsTitle.setText((String) data.get("title"));
        tvNewsSrc.setText("来源:" + data.get("src"));
        tvNewsDate.setText((String) data.get("date"));

    }
}
