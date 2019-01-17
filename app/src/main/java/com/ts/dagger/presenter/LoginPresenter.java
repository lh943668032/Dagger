package com.ts.dagger.presenter;

import com.ts.dagger.debug.Debug;

import javax.inject.Inject;

public class LoginPresenter {
    public static final String TAG = "LoginPresenter";
    public IView mIView;

    @Inject
    public LoginPresenter(IView iView){
        mIView = iView;
        mIView.show();
    }

    public void login(){
        Debug.d(Debug.TAG,"login");
    }

}
