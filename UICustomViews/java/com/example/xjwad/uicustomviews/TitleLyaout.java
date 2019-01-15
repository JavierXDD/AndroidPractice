package com.example.xjwad.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/*创建自定义控件*/
public class TitleLyaout extends LinearLayout {
    public TitleLyaout(Context context,AttributeSet attrs){
        super(context,attrs);
        /*LayoutInflater的from()方法可以构建出一个LayoutInflater对象，
        * 然后调用inflate（）方法就可以动态加载一个布局文件，
        * inflate（）方法接收两个参数，
        * 第一个参数是要加载的 布局文件的id
        * 第二个参数是 给加载好的布局文件再添加一个父布局*/
        LayoutInflater.from(context).inflate(R.layout.title,this);

        //为按钮注册点击事件
        Button title_back = (Button)findViewById(R.id.title_back);
        Button title_edit = (Button)findViewById(R.id.title_edit);
        title_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        title_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"you clicked edit button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
