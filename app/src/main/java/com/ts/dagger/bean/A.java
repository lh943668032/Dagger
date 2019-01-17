package com.ts.dagger.bean;

import android.util.Log;

import com.ts.dagger.debug.Debug;

public class A {

    private B b;

    public A(){

    }

    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public void eat(){
        Debug.d("A", "eat: ");
    }
}
