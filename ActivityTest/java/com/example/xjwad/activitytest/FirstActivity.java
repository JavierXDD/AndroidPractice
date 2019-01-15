package com.example.xjwad.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {


    //启动活动
    public static void actionStart(Context context ){
        Intent intent = new Intent(context,FirstActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //显式intent
                //Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //startActivity(intent);

                //隐式intent
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        //向下传递数据
        Button button_sendData = (Button)findViewById(R.id.button_sendData);
        button_sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "i am test data";
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });

        //返回数据给上一个活动
        //1传递数据
        Button button_sendReturnData = (Button)findViewById(R.id.button_sendReturnData);
        button_sendReturnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //原始启动方法
                String data = "i am data,i will back ";
                Intent intent = new Intent(FirstActivity.this,SendDataTest.class);
                intent.putExtra("showData","begainShow");
                intent.putExtra("data",data);
                startActivityForResult(intent,1);


                /*简化的启动方法
                * 但是此方法不可以把数据返回
                * 经测试此方法可行*/
                //SendDataTest.actionStart(FirstActivity.this,"begainShow","i am data,i will back ");
            }
        });




    }

    //2接收返回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView textView = (TextView)findViewById(R.id.textView_showReturnedData);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String string_returnedData = data.getStringExtra("data_return");
                    Log.d("info","*******"+string_returnedData);
                    textView.setText(string_returnedData);
                }else {
                    Log.d("info","return eorr!!!!!!!!!");
                }
                break;
            default:
        }
    }



    //菜单栏三个点
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    //菜单项
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_add:
                Toast.makeText(this,"click item_add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_remove:
                Toast.makeText(this,"show item_remove",Toast.LENGTH_SHORT).show();
                break;
            default :

        }
        return true;
    }

}
