package com.che.app.weironggou.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.che.app.weironggou.R;
import com.che.app.weironggou.util.RoundImageView;

import java.util.List;

/**
 * Created by zhaolong on 16/7/6.
 */
public class MainAdapter extends BaseAdapter implements View.OnClickListener {
    private List<String> mList;
    private Context context;
    private OnMainClickListener onMainClickListener;


    public interface OnMainClickListener{
        void  setPoition(int poition);
    }
    public void setClickListener(OnMainClickListener onMainClickListener){
        this.onMainClickListener=onMainClickListener;

    }



    public MainAdapter(Context context, List<String> mList){

        this.context = context;
        this.mList=mList;

    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHollde viewHollde;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.zhu_adapter_item,null);
            viewHollde=new viewHollde();
            viewHollde.headImage = (ImageView)convertView.findViewById(R.id.headImage);
            viewHollde.layRound_one = (LinearLayout)convertView.findViewById(R.id.layRound_one);
            viewHollde.layRound_two = (LinearLayout)convertView.findViewById(R.id.layRound_two);
            viewHollde.layRound_three = (LinearLayout)convertView.findViewById(R.id.layRound_three);
            viewHollde.layRound_four = (LinearLayout)convertView.findViewById(R.id.layRound_four);
            viewHollde.layRound_five = (LinearLayout)convertView.findViewById(R.id.layRound_five);
            viewHollde.roundImageOne = (RoundImageView)convertView.findViewById(R.id.roundImageOne);
            viewHollde.roundName_one = (TextView)convertView.findViewById(R.id.roundName_one);
            viewHollde.roundGender_one = (ImageView)convertView.findViewById(R.id.roundGender_one);
            viewHollde.roundAge_one = (TextView)convertView.findViewById(R.id.roundAge_one);
            viewHollde.roundImageTwo = (RoundImageView)convertView.findViewById(R.id.roundImageTwo);
            viewHollde.roundName_two = (TextView)convertView.findViewById(R.id.roundName_two);
            viewHollde.roundGender_two = (ImageView)convertView.findViewById(R.id.roundGender_two);
            viewHollde.roundAge_two = (TextView)convertView.findViewById(R.id.roundAge_two);
            viewHollde.roundImageThree = (RoundImageView)convertView.findViewById(R.id.roundImageThree);
            viewHollde.roundName_three = (TextView)convertView.findViewById(R.id.roundName_three);
            viewHollde.roundGender_three = (ImageView)convertView.findViewById(R.id.roundGender_three);
            viewHollde.roundAge_three = (TextView)convertView.findViewById(R.id.roundAge_three);
            viewHollde.roundImageFour = (RoundImageView)convertView.findViewById(R.id.roundImageFour);
            viewHollde.roundName_four = (TextView)convertView.findViewById(R.id.roundName_four);
            viewHollde.roundGender_four = (ImageView)convertView.findViewById(R.id.roundGender_four);
            viewHollde.roundAge_four = (TextView)convertView.findViewById(R.id.roundAge_four);
            viewHollde.roundImageFive = (RoundImageView)convertView.findViewById(R.id.roundImageFive);
            viewHollde.roundName_five = (TextView)convertView.findViewById(R.id.roundName_five);
            viewHollde.roundGender_five = (ImageView)convertView.findViewById(R.id.roundGender_five);
            viewHollde.roundAge_five =(TextView)convertView.findViewById(R.id.roundAge_five);
            viewHollde.lookAll = (LinearLayout)convertView.findViewById(R.id.lookAll);

            convertView.setTag(viewHollde);
        }else{
            viewHollde = (viewHollde)convertView.getTag();
        }

       viewHollde.layRound_one.setOnClickListener(this);
        viewHollde.layRound_two.setOnClickListener(this);
        viewHollde.layRound_three.setOnClickListener(this);
        viewHollde.layRound_four.setOnClickListener(this);
        viewHollde.layRound_five.setOnClickListener(this);






         return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layRound_one:
                onMainClickListener.setPoition(1);
                break;
            case R.id.layRound_two:
                onMainClickListener.setPoition(2);
                break;
            case R.id.layRound_three:
                onMainClickListener.setPoition(3);
                break;
            case R.id.layRound_four:
                onMainClickListener.setPoition(4);
                break;
            case R.id.layRound_five:
                onMainClickListener.setPoition(5);
                break;
            default:
                break;

        }




    }

    static class viewHollde{
       ImageView headImage;//头部头像
        LinearLayout layRound_one;
        LinearLayout layRound_two;
        LinearLayout layRound_three;
        LinearLayout layRound_four;
        LinearLayout layRound_five;
        //第一张图片信息
        RoundImageView roundImageOne;
        TextView roundName_one;
        ImageView roundGender_one;
        TextView roundAge_one;
        //第二张图片信息
        RoundImageView roundImageTwo;
        TextView roundName_two;
        ImageView roundGender_two;
        TextView roundAge_two;
        //第三张图片信息
        RoundImageView roundImageThree;
        TextView roundName_three;
        ImageView roundGender_three;
        TextView roundAge_three;
        //第四张图片信息
        RoundImageView roundImageFour;
        TextView roundName_four;
        ImageView roundGender_four;
        TextView roundAge_four;
        //第五张图片信息
        RoundImageView roundImageFive;
        TextView roundName_five;
        ImageView roundGender_five;
        TextView roundAge_five;
        //查看所有按钮
        LinearLayout lookAll;
    }






}
