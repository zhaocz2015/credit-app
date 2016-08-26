package com.wfzcx.credit.data.service;


import com.wfzcx.credit.data.model.AccountModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Copyright (C) 2016
 * All right reserved.
 *
 * @author:赵小布
 * @email: zhaocz2015@163.com
 * @date: 2016-08-23
 */
@Singleton
@Component(modules = {ServiceAPIModule.class})
public interface ServiceAPIModuleComponent {
    void inject(AccountModel model);
}
