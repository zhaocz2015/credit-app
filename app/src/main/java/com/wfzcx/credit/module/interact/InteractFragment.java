package com.wfzcx.credit.module.interact;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wfzcx.credit.R;
import com.wfzcx.credit.module.main.news.CreditNewsInfoActivity;
import com.wfzcx.credit.ui.VerticalScrollTextSwicher;

import java.util.ArrayList;
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
@RequiresPresenter(InteractPresenter.class)
public class InteractFragment extends BeamListFragment<InteractPresenter, Map> {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.vsts_credit_notice)
    VerticalScrollTextSwicher noticeTxtSwitcher;


    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
            ButterKnife.bind(this, rootView);

            initToolbar();
            initNoticeTxtSwitcher();
        }

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_interact;
    }

    @Override
    public ListConfig getConfig() {
        return super.getConfig().setRefreshAble(true);
    }

    @Override
    public BaseViewHolder<Map> getViewHolder(ViewGroup parent, int viewType) {
        return new NoticeVHolder(parent);
    }

    private void initNoticeTxtSwitcher() {

        String tmpStr = "[{title:'关于公开征集“信用潍坊”标识（LOGO）的公告',src:'信用潍坊',date:'2016-08-27'}," +
                "{title:'关于公布潍坊市创建社会信用体系建设试点示范城市（单位）（第一批）名单的通知',src:'省发展改革委',date:'2016-08-22'}," +
                "{title:'信用潍坊行政许可和行政处罚信用信息公示报送系统模板下载公告',src:'信用潍坊',date:'2016-08-17'}";

        List<String> txts = new ArrayList<>();
        txts.add("关于公开征集“信用潍坊”标识（LOGO）的公告");
        txts.add("关于公布潍坊市创建社会信用体系建设试点示范城市（单位）（第一批）名单的通知");
        txts.add("信用潍坊行政许可和行政处罚信用信息公示报送系统模板下载公告");

        noticeTxtSwitcher.setTexts(txts);
        noticeTxtSwitcher.start();

        noticeTxtSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VerticalScrollTextSwicher vsts = (VerticalScrollTextSwicher) view;
                TextView tv = (TextView) vsts.getCurrentView();
//                JUtils.Toast(tv.getText().toString());

                Intent intent = new Intent(getContext(), CreditNewsInfoActivity.class);
                intent.putExtra("info", "{title:'关于公开征集“信用潍坊”标识（LOGO）的公告',src:'信用潍坊',date:'2016-08-27'}");
                getContext().startActivity(intent);
            }
        });
    }

    private void initToolbar() {
        toolbar.setNavigationIcon(null);
        toolbarTitle.setText(R.string.main_tab_title_interact);
    }

    @OnClick({R.id.ll_credit_rely, R.id.ll_credit_report, R.id.ll_leave_msg})
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), CreditReportActivity.class);
        switch (view.getId()) {
            case R.id.ll_credit_rely:
                intent.putExtra("title", "信用申诉");
                break;
            case R.id.ll_credit_report:
                intent.putExtra("title", "举报投诉");
                break;
            case R.id.ll_leave_msg:
                intent.putExtra("title", "我要留言");
                break;
        }

        startActivity(intent);
    }
}
