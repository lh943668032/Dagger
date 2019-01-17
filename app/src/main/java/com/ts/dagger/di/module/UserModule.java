package com.ts.dagger.di.module;

import com.ts.dagger.bean.B;
import com.ts.dagger.bean.D;
import com.ts.dagger.debug.Debug;
import com.ts.dagger.di.Dev;
import com.ts.dagger.di.Release;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

    @Dev
    @Provides
    D providerDevD(){
        D d = new D();
        Debug.d("UserModule",d+"");
        return d;
    }

    @Release
    @Provides
    D providerReleaseD(){
        D d = new D();
        Debug.d("UserModule",d+"");
        return d;
    }

    @Provides
    B providerB(){
        B b = new B();
        return b;
    }

}
