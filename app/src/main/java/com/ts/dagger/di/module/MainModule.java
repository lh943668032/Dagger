package com.ts.dagger.di.module;

import android.content.Context;

import com.ts.dagger.bean.A;
import com.ts.dagger.bean.B;
import com.ts.dagger.bean.C;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//第一步，添加Module注解
@Module
public class MainModule {
    //第二步 使用Provider 注解 实例化对象

    Context mContext;

    public MainModule(Context context){
        mContext = context;
    }

    @Provides
    B providerB(){
        return new B();
    }

    @Named("default")
    @Provides
    A providerDefaultA(){
        return new A();
    }

    @Named("a")
    @Provides
    A providerBA(B b){
        return new A(b);
    }

    @Provides
    C providerC(){
        return new C(mContext);
    }
}
