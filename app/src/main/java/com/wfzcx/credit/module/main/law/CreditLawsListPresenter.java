package com.wfzcx.credit.module.main.law;

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
public class CreditLawsListPresenter extends BeamListActivityPresenter<CreditLawsListActivity, Map> {

    @Override
    protected void onCreate(@NonNull CreditLawsListActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        String tmpStr = "[{title:'关于加强企业环境信用体系建设的指导意见 ',src:'信用潍坊',date:'2016-08-27'}," +
                "{title:'食品药品监管总局关于推进食品药品安全信用体系建设的指导意见 ',src:'省发展改革委',date:'2016-08-22'}," +
                "{title:'国务院关于“先照后证”改革后 加强事中事后监管的意见 ',src:'信用潍坊',date:'2016-08-17'}," +
                "{title:'关于在行政管理事项中使用信用记录和信用报告的实施意见 ',src:'省民政厅',date:'2016-01-23'}," +
                "{title:'国务院办公厅关于运用大数据加强对市场主体服务和监管的若干意见 ',src:'省食品药品监管局',date:'2015-12-02'}," +
                "{title:'交通运输部关于印发水运工程设计和施工企业信用评价办法的通知 ',src:'省发展改革委',date:'2015-12-02'}," +
                "{title:'国家统计局关于发布《统计上严重失信企业信息公示暂行办法》的公告 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'农业部关于加快推进农产品质量安全信用体系建设的指导意见 ',src:'中国山东',date:'2015-09-28'}," +
                "{title:'《中国保险业信用体系建设规划（2015－2020年） ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'社会信用体系建设敲定时间表 ',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'最高人民法院关于公布失信被执行人名单信息的若干规定 ',src:'中国山东',date:'2015-09-28'}," +
                "{title:'关于组织申报山东省社会信用体系建设试点单位的通知',src:'省发展改革委',date:'2015-09-28'}," +
                "{title:'两部门要求支持和规范社会组织承接政府购买服务 ',src:'省发展改革委',date:'2015-09-28'}," +
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
