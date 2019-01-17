package com.ts.dagger.di.module;

import android.app.Application;
import android.content.Context;

import com.ts.dagger.bean.AppConstants;
import com.ts.dagger.bean.DataManager;
import com.ts.dagger.bean.E;
import com.ts.dagger.bean.Manager;
import com.ts.dagger.di.ApplicationContext;
import com.ts.dagger.di.BaseUrl;
import com.ts.dagger.di.PerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application){
        mApplication = application;
    }

    @Singleton
    @Provides
    E providerE(){
        E e = new E(mApplication);
        return e;
    }

    @BaseUrl
    @Provides
    String providerBaseUrl(){
        return AppConstants.BASE_URL;
    }

    @Singleton
    @Provides
    Manager providerDataManager(DataManager dataManager){
        return dataManager;
    }

    @ApplicationContext
    @Provides
    Context providerAppContext(){
        return mApplication;
    }
}
