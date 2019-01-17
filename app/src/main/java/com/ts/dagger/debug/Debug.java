package com.ts.dagger.debug;

import android.util.Log;

public class Debug {
    public static final String TAG = "lh";
    public static void d(String tag,String msg){
        Log.d(TAG, tag+": " + msg);
    }
}
