package com.example.xjwad.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SendDataTest extends BaseActivity {
    //启动活动
    public static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,SendDataTest.class);
        intent.putExtra("showData",data1);
        intent.putExtra("data",data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data_test);

        TextView textView_begain = (TextView)findViewById(R.id.textView_BegainShow);
        textView_begain.setText(getIntent().getStringExtra("showData"));

        //接收数据
        String data = getIntent().getStringExtra("data");
        //显示数据
        TextView textView = (TextView)findViewById(R.id.textView_showReciveData);
        textView.setText(data);
        Log.d("info","************接收的数据是："+data+"************");
        //返回接收的数据
        Button button = (Button)findViewById(R.id.button_sendReciveData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = getIntent().getStringExtra("data");

                Intent intent = new Intent();
                intent.putExtra("data_return",data);
                Log.d("info","***********返回的数据是："+data+"************");
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }

    //重写BACK键
    @Override
    public void onBackPressed() {
        String data = getIntent().getStringExtra("data");
        Intent intent = new Intent();
        intent.putExtra("data_return",data);
        setResult(RESULT_OK,intent);
        finish();
    }
}
