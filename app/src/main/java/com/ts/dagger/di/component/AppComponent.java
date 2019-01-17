package com.ts.dagger.di.component;

import android.content.Context;
import android.provider.ContactsContract;

import com.ts.dagger.app.MyApp;
import com.ts.dagger.bean.DataManager;
import com.ts.dagger.bean.E;
import com.ts.dagger.bean.Manager;
import com.ts.dagger.di.module.AppModule;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MyApp myApp);

    E getE();

    Manager getDataManager();
}
