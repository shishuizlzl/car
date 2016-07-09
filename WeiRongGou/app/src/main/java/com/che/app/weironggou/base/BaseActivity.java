package com.che.app.weironggou.base;

import android.os.Bundle;
import android.view.View;

import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by 秦谦谦 on 16/7/8.
 */
public abstract class BaseActivity extends AutoLayoutActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
    }


    public abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }
}
