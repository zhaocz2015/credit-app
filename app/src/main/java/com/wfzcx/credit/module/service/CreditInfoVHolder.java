package com.wfzcx.credit.module.service;

import android.content.Intent;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wfzcx.credit.R;
import com.wfzcx.credit.module.main.ents.CreditEntInfoActivity;

import java.util.Map;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-30
 */
public class CreditInfoVHolder extends BaseViewHolder<Map> {

    public CreditInfoVHolder(ViewGroup parent) {
        super(parent, R.layout.item_credit_ent);

        itemView.setOnClickListener(v -> {
            getContext().startActivity(new Intent(getContext(), CreditEntInfoActivity.class));
        });
    }

    @Override
    public void setData(Map data) {

    }
}
