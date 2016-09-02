package com.wfzcx.credit.module.service;

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
public class CreditInfoQryPresenter extends BeamListFragmentPresenter<CreditInfoQryFragment, Map> {

    @Override
    protected void onCreateView(@NonNull CreditInfoQryFragment view) {
        super.onCreateView(view);
        onRefresh();
    }

    @Override
    public void onRefresh() {

        String tmpStr = "[{'name':'潍坊银行股份有限公司','user':'史跃峰 ','money':'8000万元人民币','date':'1997-08-15'}," +
                "{'name':'潍柴动力股份有限公司','user':'谭旭光','money':'399861.9278万人民币','date':'2002-12-23'}," +
                "{'name':'歌尔股份有限公司','user':'姜滨','money':'152658.1348万元人民币','date':'2001-06-25'}," +
                "{'name':'潍坊人寿保险股份有限公司','user':'刘云江','money':'4000万元人民币','date':'2000-10-19'}," +
                "{'name':'潍坊世纪泰华集团有限公司','user':'王旭山','money':'7300万元人民币','date':'2015-01-14'}," +
                "{'name':'潍坊软件园发展中心','user':'董玉伦','money':'1000万元人民币','date':'2008-10-29'}," +
                "{'name':'潍坊天创置业有限公司','user':'王旭山','money':'7300万元人民币','date':'2015-01-14'}," +
                "{'name':'潍坊中润软件有限公司','user':'张立杰','money':'1000万元人民币','date':'2008-03-21'}," +
                "{'name':'潍坊新基立实业有限公司','user':'黄文平','money':'8000万元人民币','date':'2006-5-29'}," +
                "{'name':'潍坊睿云软件有限公司','user':'史恩光','money':'5400万元人民币','date':'1999-10-29'}," +
                "{'name':'潍坊市四方通达网络科技股份有限公司','user':'韩春梅','money':'1000万元人民币','date':'2008-11-24'}," +
                "{'name':'潍坊歌尔电子有限公司','user':'姜滨','money':'1000万元人民币','date':'1997-05-24'}," +
                "{'name':'潍坊市易盟网络信息有限公司','user':'白著尚','money':'7000万元人民币','date':'2011-10-19'}," +
                "{'name':'潍坊智合软件有限公司','user':'刘欣欣','money':'1000万元人民币','date':'2001-10-29'}," +
                "{'name':'潍坊中创软件工程有限责任公司','user':'景新海','money':'1000万元人民币','date':'2008-07-27'}," +
                "{'name':'潍坊北基能源科技实业集团有限公司','user':'孙臣志','money':'5800万元人民币','date':'2010-10-25'}," +
                "{'name':'潍坊润凯信息技术有限公司','user':'陈勇','money':'10000万元人民币','date':'2013-10-23'}," +
                "{'name':'潍坊华腾网络科技有限公司','user':'刘龙华','money':'6000万元人民币','date':'2008-10-29'}," +
                "{'name':'潍坊鑫丰电子商务有限公司','user':'郭东','money':'5000万元人民币','date':'2008-10-29'}," +
                "{'name':'潍坊国建高创科技有限公司','user':'陈家欣','money':'1600万元人民币','date':'2008-10-29'}," +
                "{'name':'潍坊伟达信息科技发展有限公司','user':'张寞轩','money':'3000万元人民币','date':'2008-10-29'}," +
                "{'name':'潍坊高新软件评测中心','user':'王飞虎','money':'8000万元人民币','date':'2008-10-29'}," +
                "{'name':'潍坊红奔腾软件科技有限公司','user':'张爱强','money':'1000万元人民币','date':'2008-10-29'}," +
                "{'name':'潍坊易科软件开发有限公司','user':'刘荆','money':'7000万元人民币','date':'2008-10-29'}," +
                "{'name':'潍坊鼎晖中狮信息科技有限公司','user':'李虎山','money':'1000万元人民币','date':'2008-10-29'}]";

        try {

            Observable.just(JSON.parseArray(tmpStr, Map.class))
                    .compose(new ErrorTransform<>())
                    .unsafeSubscribe(getRefreshSubscriber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
