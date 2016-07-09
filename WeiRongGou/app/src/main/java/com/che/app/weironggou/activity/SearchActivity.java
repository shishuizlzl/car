package com.che.app.weironggou.activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.che.app.weironggou.R;
import com.che.app.weironggou.base.BaseActivity;
import com.che.app.weironggou.util.KeywordsFlow;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhaolong on 16/7/9.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {
    public static final String[] keywords = { "邵林傻逼", "邵林干你妹", "FUCK YOU", "肥猪", "你是狗屎",
            "邵林下边小", "你奶奶个母熊", "幼稚园程度的高中生", "邵林你妹的", "邵林化粪池堵塞的凶手",
            "你是一陀粪", "邵林屁股大", "邵林是母猪", "邵林火山爆发的脸", "邵林纯傻逼", "邵林干你妹", "FUCK YOU", "肥猪", "你是狗屎",
            "邵林下边小", "你奶奶个母熊", "幼稚园程度的高中生", "邵林你妹的", "邵林化粪池堵塞的凶手"
    };
    private KeywordsFlow keywordsFlow;
    private Button btnIn, btnOut;
    private Handler handler;

    @Override
    public int setLayout() {
        return R.layout.activity_scarch;
    }

    @Override
    protected void initView() {
        keywordsFlow = (KeywordsFlow) findViewById(R.id.keyWordsFlow);
        keywordsFlow.setDuration(800l);
        keywordsFlow.setOnItemClickListener(SearchActivity.this);
        feedKeywordsFlow(keywordsFlow, keywords);
        keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);
        handler  = new Handler(){
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 1){
                    keywordsFlow.rubKeywords();
                    feedKeywordsFlow(keywordsFlow, keywords);
                    keywordsFlow.go2Show(KeywordsFlow.ANIMATION_OUT);
                }
            }
        };
        Timer timer = new Timer(true);
        TimerTask task = new TimerTask() {
            public void run() {
                Message msg = new Message();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        };
        //启动定时器
        timer.schedule(task, 0, 3000);
    }

    @Override
    protected void initData() {

    }
    private static void feedKeywordsFlow(KeywordsFlow keywordsFlow, String[] arr) {
        Random random = new Random();
        for (int i = 0; i < KeywordsFlow.MAX; i++) {
            int ran = random.nextInt(arr.length);
            String tmp = arr[ran];
            keywordsFlow.feedKeyword(tmp);
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof TextView) {
            String keyword = ((TextView) v).getText().toString();
            Toast.makeText(SearchActivity.this, keyword, Toast.LENGTH_LONG).show();
        }
    }
}
