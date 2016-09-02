package com.wfzcx.credit.module.main.trend;

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
public class CreditTrendListPresenter extends BeamListActivityPresenter<CreditTrendListActivity, Map> {

    @Override
    protected void onCreate(@NonNull CreditTrendListActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        String tmpStr = "[{title:'我省信用办下发关于印发2016年山东省社会信用体系建设工作任务分工意见的通知',src:'省信用办',date:'2016-08-10'}," +
                "{title:'发改委：信用信息共享平台建设能使守信者真正受益',src:'中国网',date:'2016-09-01'}," +
                "{title:'电信诈骗将引入信用惩戒',src:'新华日报',date:'2016-08-17'}," +
                "{title:'园林绿化施工企业实行信用评价 信用aa级企业或被拒绝投标',src:'潍坊晚报',date:'2016-08-31'}," +
                "{title:'民政部：申请慈善组织认定时弄虚作假纳入信用记录',src:'中国新闻网',date:'2016-08-31'}," +
                "{title:'山东省社会信用体系建设联席会议办公室关于调整山东省社会信用体系建设联席会议成员的通知',src:'省发展改革委',date:'2015-12-02'}," +
                "{title:'山东省人民政府办公厅关于建立山东省社会信用体系建设联席会议制度的通知',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'山东省社会信用体系建设联席会议办公室关于调整山东省社会信用体系建设联席会议成员的通知',src:'中国山东',date:'2015-09-28'}," +
                "{title:'山东省社会信用体系建设联席会议办公室关于印发《2015年山东省社会信用体系建设工作任务分工意见》的通知',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'山东省社会信用体系建设联席会议办公室关于印发《山东省公共信用信息平台建设总体方案》的通知',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'山东省人民政府关于印发山东省社会信用体系建设规划（2015—2020年）的通知',src:'中国山东',date:'2015-09-28'}," +
                "{title:'关于组织申报山东省社会信用体系建设试点单位的通知',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'山东省人民政府办公厅关于建立山东省社会信用体系建设联席会议制度的通知',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'山东省社会信用体系建设联席会议办公室关于印发2015年山东省社会信用体系建设工作任务分工意见的通知',src:'坊子国税局',date:'2015-08-27'}" +
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
