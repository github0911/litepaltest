package com.example.litepaltest.base;

import android.app.Application;

import org.litepal.LitePalApplication;

/**
 * Created by zhang on 2016/12/20.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
    }
}
