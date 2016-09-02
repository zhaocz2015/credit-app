package com.wfzcx.credit.module.main.cases;

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
public class CreditCaseListPresenter extends BeamListActivityPresenter<CreditCaseListActivity, Map> {

    @Override
    protected void onCreate(@NonNull CreditCaseListActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        String tmpStr = "[{title:'奎文区失信联合惩戒典型案例', src:'坊子国税局', date: '2016-08-27'}," +
                "{title:'高新区社会诚信典型案例', src:'潍坊税务总局', date: '2016-08-27'}," +
                "{title:'滨海区失信联合惩戒典型案例', src:'工商行政管理总局', date: '2016-08-27'}," +
                "{title:'经济开发区守信联合激励典型案例', src:'财政部网站', date: '2016-08-27'}," +
                "{title:'潍城区失信联合惩戒型案例', src:'工商行政管理总局', date: '2016-08-27'}," +
                "{title:'经济开发区守信联合激励典型案例', src:'财政部网站', date: '2016-08-27'}," +
                "{title:'寒亭区区失信联合惩戒型案例', src:'工商行政管理总局', date: '2016-08-27'}," +
                "{title:'经济开发区失信联合惩戒型案例', src:'财政部网站', date: '2016-08-27'}," +
                "{title:'昌邑市失信联合惩戒型案例', src:'工商行政管理总局', date: '2016-08-27'}," +
                "{title:'诸城市守信联合激励典型案例', src:'财政部网站', date: '2016-08-27'}," +
                "{title:'昌乐县失信联合惩戒型案例', src:'工商行政管理总局', date: '2016-08-27'}," +
                "{title:'安丘市守信联合激励典型案例', src:'财政部网站', date: '2016-08-27'}," +
                "{title:'临朐县失信联合惩戒型案例', src:'工商行政管理总局', date: '2016-08-27'}," +
                "{title:'经济开发区守信联合激励典型案例', src:'财政部网站', date: '2016-08-27'}," +
                "{title:'安丘市失信联合惩戒典型案例', src:'中国新闻网', date: '2016-08-27'}," +
                "{title:'《关于加强和推进济南市物流行业诚信体系建设的实施意见》解读 ',src:'坊子国税局',date:'2015-08-27'}" +
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
