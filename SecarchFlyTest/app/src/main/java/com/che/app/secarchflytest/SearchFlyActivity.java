package com.che.app.secarchflytest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SearchFlyActivity extends Activity implements OnClickListener {  
    public static final String[] keywords = { "邵林傻逼", "邵林干你妹", "FUCK YOU", "肥猪", "你是狗屎", 
        "邵林下边小", "你奶奶个母熊", "幼稚园程度的高中生", "邵林你妹的", "邵林化粪池堵塞的凶手", 
        "你是一陀粪", "邵林屁股大", "邵林是母猪", "邵林火山爆发的脸", "邵林纯傻逼", "邵林干你妹", "FUCK YOU", "肥猪", "你是狗屎", 
        "邵林下边小", "你奶奶个母熊", "幼稚园程度的高中生", "邵林你妹的", "邵林化粪池堵塞的凶手"
         };  
private KeywordsFlow keywordsFlow;  
private Button btnIn, btnOut;  
Handler handler;

public void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.main);  
    btnIn = (Button) findViewById(R.id.button1);  
    btnOut = (Button) findViewById(R.id.button2);  
    btnIn.setOnClickListener(this);  
    btnOut.setOnClickListener(this);  
    keywordsFlow = (KeywordsFlow) findViewById(R.id.frameLayout1);  
    keywordsFlow.setDuration(800l);  
    keywordsFlow.setOnItemClickListener(this);  
     
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
    timer.schedule(task, 0, 1000);

    
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
    if (v == btnIn) {  
        keywordsFlow.rubKeywords();  
        feedKeywordsFlow(keywordsFlow, keywords);  
        keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);  
    } else if (v == btnOut) {  
        keywordsFlow.rubKeywords();  
        feedKeywordsFlow(keywordsFlow, keywords);  
        keywordsFlow.go2Show(KeywordsFlow.ANIMATION_OUT);  
    } else if (v instanceof TextView) {  
        String keyword = ((TextView) v).getText().toString();  
        Log.e("Search", keyword);
    }  
}  
}