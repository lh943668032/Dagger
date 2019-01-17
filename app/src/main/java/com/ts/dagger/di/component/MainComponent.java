package com.ts.dagger.di.component;

import com.ts.dagger.MainActivity;
import com.ts.dagger.di.PerActivity;
import com.ts.dagger.di.module.MainModule;

import javax.inject.Singleton;

import dagger.Component;
//第一步 添加@Component
//第二步 添加module
@PerActivity
@Component(modules = {MainModule.class},dependencies = AppComponent.class)
public interface MainComponent {

    //第三步  写一个方法 绑定Activity /Fragment
    void inject(MainActivity activity);
}
