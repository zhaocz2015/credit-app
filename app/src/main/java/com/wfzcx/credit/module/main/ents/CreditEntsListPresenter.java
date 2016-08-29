package com.wfzcx.credit.module.main.ents;

import android.os.Bundle;
import android.support.annotation.NonNull;

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
public class CreditEntsListPresenter extends BeamListActivityPresenter<CreditEntsListActivity, Map> {

    @Override
    protected void onCreate(@NonNull CreditEntsListActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        List<Map> data = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Map m1 = new HashMap<>();
            m1.put("name", "123");
            data.add(m1);
        }

        try {

            Observable.just(data)
                    .compose(new ErrorTransform<>())
                    .unsafeSubscribe(getRefreshSubscriber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
