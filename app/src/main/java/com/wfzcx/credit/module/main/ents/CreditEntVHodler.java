package com.wfzcx.credit.module.main.ents;

import android.content.Intent;
import android.view.ViewGroup;
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
public class CreditEntVHodler extends BaseViewHolder<Map> {

    @BindView(R.id.tv_ent_name)
    TextView entName;
    @BindView(R.id.tv_ent_user)
    TextView entUser;
    @BindView(R.id.tv_ent_money)
    TextView entMoney;
    @BindView(R.id.tv_ent_date)
    TextView entDate;

    Map info;
    String entNameStr;

    public CreditEntVHodler(ViewGroup parent) {
        super(parent, R.layout.item_credit_ent);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(view -> {
            Intent i = new Intent(getContext(), CreditEntInfoActivity.class);
            i.putExtra("title", entNameStr);
            i.putExtra("info", JSON.toJSONString(info));
            getContext().startActivity(i);
        });

    }


    @Override
    public void setData(Map data) {

        info = data;
        entNameStr = (String) data.get("name");

        entName.setText((String) data.get("name"));
        entUser.setText((String) data.get("user"));
        entMoney.setText((String) data.get("money"));
        entDate.setText((String) data.get("date"));

    }
}
