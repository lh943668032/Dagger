package com.ts.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ts.dagger.R;
import com.ts.dagger.app.MyApp;
import com.ts.dagger.bean.B;
import com.ts.dagger.bean.D;
import com.ts.dagger.bean.DataManager;
import com.ts.dagger.bean.E;
import com.ts.dagger.bean.Manager;
import com.ts.dagger.debug.Debug;
import com.ts.dagger.di.Dev;
import com.ts.dagger.di.Release;
import com.ts.dagger.di.component.DaggerMainComponent;
import com.ts.dagger.di.component.DaggerUserComponent;
import com.ts.dagger.di.module.MainModule;
import com.ts.dagger.di.module.UserModule;
import com.ts.dagger.presenter.IView;
import com.ts.dagger.presenter.LoginPresenter;

import java.util.Date;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements IView {
    public static final String TAG = "LoginActivity";

//    @Dev
//    @Inject
//    D d;
//
//    @Release
//    @Inject
//    D d1;

    @Inject
    B b;

    @Inject
    E e;

    @Inject
    Manager dataManager;

    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerUserComponent.builder()
                .userModule(new UserModule(this))
                .appComponent(((MyApp)getApplication()).getAppComponent())
//                .mainModule(new MainModule(this))
                .build().inject(this);
        Debug.d(TAG,b+"");
        Debug.d(TAG,e+"");
        Debug.d(TAG,dataManager+"");
        dataManager.manage();
        mLoginPresenter.login();
//        com.ts.dagger.debug.Debug.d(TAG,d+"");
//        com.ts.dagger.debug.Debug.d(TAG,d1+"");
    }

    @Override
    public void show() {
        Debug.d(TAG,"show");
    }
}
