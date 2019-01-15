package com.example.xjwad.activitytest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

    //启动活动
    public static void actionStart(Context context){
        Intent intent = new Intent(context,SendDataTest.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //调用浏览器
        Button button_view = (Button)findViewById(R.id.button_view);
        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        //调用拨号界面
        Button button_call = (Button)findViewById(R.id.button_call);
        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

/*        Button button_geo = (Button)findViewById(R.id.button_geo);
        button_geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.Action_)
            }
        });
*/

        //向下传递数据-接收数据
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        TextView textView = (TextView)findViewById(R.id.textView_showData);
        textView.setText(data);

    }
}
