package com.example.xjwad.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"接收到自定义广播，注意版本，高版本不可用隐式注册广播",Toast.LENGTH_SHORT).show();
    }
}
