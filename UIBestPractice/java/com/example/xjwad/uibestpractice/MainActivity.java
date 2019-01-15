package com.example.xjwad.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsgs();
        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        msgRecyclerView = (RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                //价值一个亿的AI回复
                String reContent = content.replaceAll("吗?([?？])*","")+"!";

                if (!"".equals(content)){
                    Msg sendMsg = new Msg(content,Msg.TYPE_SEND);
                    msgList.add(sendMsg);
                    //用于通知列表中有新的数据插入
                    adapter.notifyItemInserted(msgList.size()-1);
                    //将显示的数据定位到走后一行，保证可以看到最后发出的消息
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    inputText.setText("");

                    Msg reMsg = new Msg(reContent,Msg.TYPE_RECIVED);
                    msgList.add(reMsg);
                    //用于通知列表中有新的数据插入
                    adapter.notifyItemInserted(msgList.size()-1);
                    //将显示的数据定位到走后一行，保证可以看到最后发出的消息
                    msgRecyclerView.scrollToPosition(msgList.size()-1);

                }
            }
        });
    }

    private void initMsgs(){
        Msg msg1 = new Msg("你好，我是小X",Msg.TYPE_RECIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("你好",Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("你有什么问题吗？你可以试着问我‘在吗？’",Msg.TYPE_RECIVED);
        msgList.add(msg3);
    }
}
