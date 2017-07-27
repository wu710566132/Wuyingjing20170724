package com.bw.wuyingjing20170724;
/*
 * 类用途:全局初始化
 * 作者：吴迎静 
 * 时间： 2017/7/24.
 */

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class MyApp extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }



}
