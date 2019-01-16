package com.example.xjwad.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private NetworkChangeReceiver networkChangeReceiver;

    /*定义内部类，继承自BroadcastReceiver，重写父类OnReceive()方法。
    * 每当网络状态发生变化，onReceive（）方法就会执行。*/
    class NetworkChangeReceiver extends BroadcastReceiver{
        public void onReceive(Context context, Intent intent){

            /*ConnectivityManager这是一个系统服务类，专门管理网络连接,
            * 调用他的getActiveNetworkInfo（）方法，得到networkInfo实例，
            * networkInfo的isAvailable（）方法可以判断当前是否有网络连接。*/
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context,"*****有 网*****",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"*****没 有 网*****",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*创建IntentFilter实例，添加"android.net.conn.CONNECTIVITY_CHANGE"的action,
        * 当网络状态发生变化时，系统发出值为"android.net.conn.CONNECTIVITY_CHANGE"的广播，
        * 广播接收器想要监听什么广播，就添加相应的action。
        * 接下来创建NetworkChangeReceiver实例，
        * 调用registerReceiver（）方法进行注册，
        * 将IntentFilter和NetworkChangeReceiver的实例都传了进去，
        * 这样NetworkChangeReceiver就会收到所有值为"android.net.conn.CONNECTIVITY_CHANGE"的广播。*/
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);


        /*发送自定义的广播*/
        Button button = (Button)findViewById(R.id.button_sendBroadcast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*书中使用此例子进行自定义广播的发送，但发送后接收器无反应。
                经查证后，Android 8.0 对广播增加了限制，
                除了有限的例外广播，应用不能使用清单（AndroidManifest.xml)注册隐式广播。
                但可以在运行时动态注册这些广播，并且可以使用清单注册专门针对他们的显示广播。（API 26）

                Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
                sendBroadcast(intent);

                */

                //使用显式
                Intent intent = new Intent(new Intent(MainActivity.this,MyBroadcastReceiver.class));
                intent.setAction("com.example.broadcasttest.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });
    }

    /*动态注册的广播接收器要取消注册，
    * 调用unregisterReceiver（）方法来实现取消注册。*/
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
}
