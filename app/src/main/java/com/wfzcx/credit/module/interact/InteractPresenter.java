package com.wfzcx.credit.module.interact;

import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.jude.beam.expansion.list.BeamListFragmentPresenter;
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
 * @date: 2016-08-30
 */
public class InteractPresenter extends BeamListFragmentPresenter<InteractFragment, Map> {

    @Override
    protected void onCreateView(@NonNull InteractFragment view) {
        super.onCreateView(view);
        onRefresh();
    }

    @Override
    public void onRefresh() {

        String tmpStr = "[{title:'关于公开征集“信用潍坊”标识（LOGO）的公告',src:'信用潍坊',date:'2016-08-27'}," +
                "{title:'关于公布潍坊市创建社会信用体系建设试点示范城市（单位）（第一批）名单的通知',src:'省发展改革委',date:'2016-08-22'}," +
                "{title:'信用潍坊行政许可和行政处罚信用信息公示报送系统模板下载公告',src:'信用潍坊',date:'2016-08-17'}," +
                "{title:'山东省民政厅关于实施社会组织统一社会信用代码制度改革的公告',src:'省民政厅',date:'2016-01-23'}," +
                "{title:'山东省食品药品安全信用分级分类管理办法（试行）',src:'省食品药品监管局',date:'2015-12-02'}," +
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
