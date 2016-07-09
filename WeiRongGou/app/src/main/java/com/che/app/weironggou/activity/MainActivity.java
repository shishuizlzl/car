package com.che.app.weironggou.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.che.app.weironggou.R;
import com.che.app.weironggou.base.BaseActivity;
import com.che.app.weironggou.fragment.HomeFragment;
import com.che.app.weironggou.fragment.MessageFragment;
import com.che.app.weironggou.fragment.NearbyFragment;
import com.che.app.weironggou.util.SlideOutInter;

public class MainActivity extends FragmentActivity implements SlideOutInter{
    private DrawerLayout drawerLayout;
    private LinearLayout viewZhu;
    private Fragment[] fragments;
    private HomeFragment homeFragment;
    private NearbyFragment nearbyFragment;
    private MessageFragment messageFragment;



    private ImageView[] imagebuttons;
    private TextView[] textviews;
    private FragmentTransaction transaction;
    private int index;
    // 当前fragment的index
    private int currentTabIndex;
    @Override
    public int setLayout() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        transaction = getSupportFragmentManager().beginTransaction();
        return  R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //侧边栏加载
        initDrawerLayout();
        //初始化数据
        init();

    }

    @Override
    protected void initData() {

    }

    @Override
    public void setMessage(boolean boll) {
        if(boll == true){
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }
    private void init(){
        viewZhu = (LinearLayout) findViewById(R.id.mainpage);
        homeFragment = new HomeFragment();
        nearbyFragment = new NearbyFragment();
        messageFragment = new MessageFragment();
        fragments = new Fragment[]{homeFragment, nearbyFragment, messageFragment};
        imagebuttons = new ImageView[3];
        imagebuttons[0] = (ImageView)findViewById(R.id.ib_zhu);
        imagebuttons[1] = (ImageView)findViewById(R.id.ib_nearby);
        imagebuttons[2] = (ImageView)findViewById(R.id.ib_message);
        imagebuttons[0].setSelected(true);
        textviews = new TextView[3];
        textviews[0] = (TextView)findViewById(R.id.tv_zhu);
        textviews[1] = (TextView)findViewById(R.id.tv_nearby);
        textviews[2] = (TextView)findViewById(R.id.tv_message);
        textviews[0].setTextColor(0xFF0471ce);
        transaction.add(R.id.fragment_container,homeFragment).add(R.id.fragment_container,nearbyFragment).add(R.id.fragment_container,messageFragment).hide(nearbyFragment).hide(messageFragment).show(homeFragment).commit();

    }
    public void onTabClicked(View view) {

        switch (view.getId()) {
            case R.id.re_zhu:
                index = 0;
                break;
            case R.id.re_nearby:
                index = 1;
                break;
            case R.id.re_message:
                index = 2;
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        imagebuttons[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        imagebuttons[index].setSelected(true);
        textviews[currentTabIndex].setTextColor(0xFF999999);
        textviews[index].setTextColor(0xFF0471ce);
        currentTabIndex = index;
    }
    private void initDrawerLayout(){
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                //当侧边栏打开获取数据
                Toast.makeText(MainActivity.this,"aflsj",Toast.LENGTH_LONG).show();

            }
            @Override
            public void onDrawerClosed(View drawerView) {
            }
            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
        drawerLayout.setScrimColor(Color.TRANSPARENT);
    }
    //设置点击效果
    private void toggleLeftSliding(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            drawerLayout.openDrawer(GravityCompat.START);
            //当侧边栏打开获取数据
        }
    }

}
