package com.wfzcx.credit.module.main.expo;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.jude.beam.expansion.list.BeamListActivityPresenter;
import com.wfzcx.credit.data.service.ErrorTransform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-29
 */
public class CreditExpoListPresenter extends BeamListActivityPresenter<CreditExpoListActivity, Map> {

    @Override
    protected void onCreate(@NonNull CreditExpoListActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        String tmpStr = "[{title:'2016年食品药品行政处罚案件信息公开（第二期） ',src:'省信用办',date:'2016-08-10'}," +
                "{title:'2016年食品药品行政处罚案件信息公开（第一期）',src:'中国网',date:'2016-09-01'}," +
                "{title:'坊子区国家税务局欠税公告决定书 ',src:'新华日报',date:'2016-08-17'}," +
                "{title:'潍坊经济开发区国家税务局欠税公告决定书潍经国税欠公字[2016]2号  ',src:'潍坊晚报',date:'2016-08-31'}," +
                "{title:'民政部：申请慈善组织认定时弄虚作假纳入信用记录',src:'中国新闻网',date:'2016-08-31'}," +
                "{title:'关于对扰乱建筑市场秩序欠薪上访责任主体及有关人员的处理意见 ',src:'省发展改革委',date:'2015-12-02'}," +
                "{title:'奎文国家税务局欠税公告决定书奎国税欠公字〔2016〕3号 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'青州市国家税务局欠税公告决定书 ',src:'中国山东',date:'2015-09-28'}," +
                "{title:'奎文国家税务局欠税公告决定书',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'诸城市国家税务局欠税公告决定书',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'坊子区国税局2016年2月份违法违章公告 （2015—2020年）的通知',src:'中国山东',date:'2015-09-28'}," +
                "{title:'寒亭区国家税务局 潍坊市地方税务局寒亭分局联合欠税公告决定书 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'安丘市国税局2015年第4季度纳税人欠税情况公告 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'2016年2月份潍坊环境违法案件行政处罚 ',src:'坊子国税局',date:'2015-08-27'}" +
                "]";

        try {

            Observable.just(JSON.parseArray(tmpStr, Map.class))
                    .compose(new ErrorTransform<>())
                    .unsafeSubscribe(getRefreshSubscriber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
