package com.wfzcx.credit.module.main.knows;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.jude.beam.expansion.list.BeamListActivityPresenter;
import com.wfzcx.credit.data.service.ErrorTransform;

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
public class CreditKnowsListPresenter extends BeamListActivityPresenter<CreditKnowsListActivity, Map> {

    @Override
    protected void onCreate(@NonNull CreditKnowsListActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        String tmpStr = "[{title:'信用评级等传统风控技术仍是最有效的 ',src:'信用潍坊',date:'2016-08-27'}," +
                "{title:'社会信用体系建设 要重视的四个基本问题 ',src:'省发展改革委',date:'2016-08-22'}," +
                "{title:'培育企业文化　打造诚信品牌 ',src:'信用潍坊',date:'2016-08-17'}," +
                "{title:'为人处世诚信始 ',src:'省民政厅',date:'2016-01-23'}," +
                "{title:'让诚信之花永放光彩 ',src:'省食品药品监管局',date:'2015-12-02'}," +
                "{title:'诚信经营　厚道做事 ',src:'省发展改革委',date:'2015-12-02'}," +
                "{title:'潍昌房屋：诚信经营 厚道做事 树立“厚道鲁商”良好形象 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'潍坊海天银通汽车出租旅游有限公司 出租车驾驶员拾金不昧，道德高尚 ',src:'中国山东',date:'2015-09-28'}," +
                "{title:'寿光市积极打造“信义菜乡”品牌 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'聚焦民企诚信力量 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'浙江日报：诚信是金 （2015—2020年）的通知',src:'中国山东',date:'2015-09-28'}," +
                "{title:'【人民日报】当文明人 做诚信事 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'潍坊市荣膺“全国文明城市”称号 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'诚信非发自内心 交换人质亦枉然 ',src:'坊子国税局',date:'2015-08-27'}" +
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
