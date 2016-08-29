package com.wfzcx.credit.module.main.expo;

import android.content.Intent;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wfzcx.credit.R;

import java.util.Map;

import butterknife.ButterKnife;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-29
 */
public class CreditExpoVHodler extends BaseViewHolder<Map> {
    public CreditExpoVHodler(ViewGroup parent) {
        super(parent, R.layout.item_credit_expo);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(view -> {
            getContext().startActivity(new Intent(getContext(), CreditExpoInfoActivity.class));
        });

    }


    @Override
    public void setData(Map data) {

    }
}
