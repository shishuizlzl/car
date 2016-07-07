package com.che.app.weironggou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.che.app.weironggou.R;
import com.che.app.weironggou.adapter.zhuAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolong on 16/7/6.
 */
public class HomeFragment extends Fragment {
    private LinearLayout titleHead;
    private Button leftButton;
    private Button rightButton;
    private ListView listView;
    private zhuAdapter zhuAdapter;
    private List<String> mList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,null);
        //控件初始化与赋值
        init(view);



        return view;
    }
    private void init(View view){
        titleHead = (LinearLayout)view.findViewById(R.id.title_header);
        leftButton = (Button)titleHead.findViewById(R.id.header_iv_logo);
        rightButton = (Button)titleHead.findViewById(R.id.header_ib_middle_imagebutton);
        mList = new ArrayList<String>();
        for (int i =0 ; i<11 ; i++){
            mList.add("1");
        }
        listView = (ListView)view.findViewById(R.id.zhu_list);
        zhuAdapter = new zhuAdapter(getActivity(),mList);
        listView.setAdapter(zhuAdapter);

    }
}
