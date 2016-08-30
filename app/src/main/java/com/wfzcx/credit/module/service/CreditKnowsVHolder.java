package com.wfzcx.credit.module.service;

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
public class CreditKnowsVHolder extends BaseViewHolder<Map> {
    public CreditKnowsVHolder(ViewGroup parent) {
        super(parent, R.layout.item_service_credit_data);

        itemView.setOnClickListener(v -> {
            getContext().startActivity(new Intent(getContext(), CreditNewsInfoActivity.class));
        });
    }
}
