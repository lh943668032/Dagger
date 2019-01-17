package com.ts.dagger.app;

import android.app.Application;

import com.ts.dagger.di.component.AppComponent;
import com.ts.dagger.di.component.DaggerAppComponent;
import com.ts.dagger.di.module.AppModule;

public class MyApp extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
