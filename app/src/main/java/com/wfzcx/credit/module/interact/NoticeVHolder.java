package com.wfzcx.credit.module.interact;

import android.content.Intent;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wfzcx.credit.R;
import com.wfzcx.credit.module.main.news.CreditNewsInfoActivity;

import java.util.Map;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-30
 */
public class NoticeVHolder extends BaseViewHolder<Map> {
    public NoticeVHolder(ViewGroup parent) {
        super(parent, R.layout.item_credit_news);
        itemView.setOnClickListener(v -> {
            getContext().startActivity(new Intent(getContext(), CreditNewsInfoActivity.class));
        });
    }

    @Override
    public void setData(Map data) {
        
    }
}
