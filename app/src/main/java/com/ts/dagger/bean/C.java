package com.ts.dagger.bean;

import android.content.Context;

import com.ts.dagger.debug.Debug;

public class C {
    Context mContext;
    public C(Context context){
        mContext = context;
    }

    public void print(){
        Debug.d("c","print c");
    }
}
