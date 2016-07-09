package com.che.app.weironggou.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by 秦谦谦 on 16/7/8.
 */
public class BaseApplicate extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }

    public static Context getContext() {
        return context;
    }
}
