package com.che.app.weironggou.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 秦谦谦 on 16/7/8.
 */
public abstract class BaceFragment extends Fragment {
    private static Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(setLayout(),container,false);

    }

    /**
     * 此方法用于绑定布局
     * @return
     */
    public abstract int setLayout() ;

    /**
     *初始化数据
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initView(view);
    }

    protected abstract void initView(View view);

    /**
     * 用于数据的交互
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        initData();
    }

    protected abstract void initData();

    /**
     * 初始化组件
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T bindView (int id) {
        return (T) getView().findViewById(id);
    }
}
