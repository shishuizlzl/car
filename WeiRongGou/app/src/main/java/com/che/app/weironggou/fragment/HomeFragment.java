package com.che.app.weironggou.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.che.app.weironggou.R;
import com.che.app.weironggou.activity.SearchActivity;
import com.che.app.weironggou.adapter.MainAdapter;
import com.che.app.weironggou.util.SlideOutInter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaolong on 16/7/6.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private LinearLayout titleHead;
    private Button leftButton;//左边菜单按钮
    private Button rightButton;//右边搜索按钮
    private LinearLayout leftLay;
    private LinearLayout rightLay;
    private ListView listView;
    private MainAdapter mainAdapter;
    private List<String> mList;
    private SlideOutInter slideOutInter;
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        slideOutInter=(SlideOutInter)getActivity();
        View view = inflater.inflate(R.layout.home_fragment,null);
        //控件初始化与赋值
        init(view);
        return view;
    }


    private void init(View view){
        titleHead = (LinearLayout)view.findViewById(R.id.title_header);
        leftLay = (LinearLayout)titleHead.findViewById(R.id.header_iv_lay);
        rightLay = (LinearLayout)titleHead.findViewById(R.id.header_middle_lay);
        leftLay.setOnClickListener(this);
        rightLay.setOnClickListener(this);
        leftButton = (Button)titleHead.findViewById(R.id.header_iv_logo);
        leftButton.setBackgroundResource(R.drawable.slidingmenu);
        rightButton = (Button)titleHead.findViewById(R.id.header_ib_middle_imagebutton);
        rightButton.setBackgroundResource(R.drawable.sousuo);
        rightButton.setOnClickListener(this);
        mList = new ArrayList<String>();
        for (int i =0 ; i<11 ; i++){
            mList.add("1");
        }
        listView = (ListView)view.findViewById(R.id.zhu_list);
        mainAdapter = new MainAdapter(getActivity(),mList);
        listView.setAdapter(mainAdapter);
        mainAdapter.setClickListener(new MainAdapter.OnMainClickListener() {
            @Override
            public void setPoition(int poition) {
                switch (poition){
                    case 1:
                        Toast.makeText(getActivity(),"1",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(getActivity(),"2",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(getActivity(),"3",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.header_iv_lay:
                slideOutInter.setMessage(true);
                break;
            case R.id.header_middle_lay:
                break;
            //搜索栏的点击事件
            case R.id.header_ib_middle_imagebutton:
                Log.d("点击事件","点击了");
                Intent intent=new Intent(getContext(),SearchActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }


    }
}
