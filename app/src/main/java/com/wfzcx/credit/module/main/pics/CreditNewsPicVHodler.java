package com.wfzcx.credit.module.main.pics;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
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
public class CreditNewsPicVHodler extends BaseViewHolder<Map> {

    @BindView(R.id.iv_news_pic)
    ImageView ivNewsPic;

    @BindView(R.id.tv_news_title)
    TextView tvNewsTitle;
    @BindView(R.id.tv_news_src)
    TextView tvNewsSrc;
    @BindView(R.id.tv_news_date)
    TextView tvNewsDate;

    Map info;

    public CreditNewsPicVHodler(ViewGroup parent) {
        super(parent, R.layout.item_credit_news_pic);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), CreditNewsPicInfoActivity.class);
            intent.putExtra("info", JSON.toJSONString(info));
            getContext().startActivity(intent);
        });
    }

    private int[] newsPics = {R.drawable.ic_roll_page_001, R.drawable.ic_roll_page_002, R.drawable.ic_roll_page_003, R.drawable.ic_roll_page_004};

    @Override
    public void setData(Map data) {
        info = data;

        ivNewsPic.setImageResource(newsPics[getAdapterPosition() % 4]);

        tvNewsTitle.setText((String) data.get("title"));
        tvNewsSrc.setText("来源:" + data.get("src"));
        tvNewsDate.setText((String) data.get("date"));

    }
}
