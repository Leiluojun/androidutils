package com.yuhj.androidutilcode;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.yuhj.utilcode.utils.CrashUtils;
import com.yuhj.utilcode.utils.LogUtils;
import com.yuhj.utilcode.utils.Utils;


public class UtilsApp extends Application {

    private static UtilsApp appContext;

    public static UtilsApp getInstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        appContext = this;
        Utils.init(getApplicationContext());
        CrashUtils.getInstance().init();
        LogUtils.getBuilder().setTag("MyTag").setLog2FileSwitch(true).create();
    }
}
