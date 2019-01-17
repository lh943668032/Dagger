package com.ts.dagger.bean;

import android.content.Context;
import android.util.Log;

import com.ts.dagger.debug.Debug;
import com.ts.dagger.di.ApplicationContext;
import com.ts.dagger.di.BaseUrl;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class DataManager implements Manager{
    public static final String TAG = "DataManager";
    public Context mContext;
    public String mBaseUrl;

    @Inject
    public DataManager(@ApplicationContext Context context,@BaseUrl String baseUrl){
        mContext = context;
        Debug.d(TAG,"init");
        mBaseUrl = baseUrl;
        Debug.d(TAG,"baseUrl: " + baseUrl);
    }

    @Override
    public void manage() {
        Debug.d(TAG, "manage: data");
    }
}
