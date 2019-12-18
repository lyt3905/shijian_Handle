package cn.edu.bistu.cs.se.shijian_handle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button xiaoxi1;
    Button xiaoxi2;
    TextView xianshi;
    private Handler handler=new Handler(){
        public void handleMessage(Message message){
            switch (message.what){
                case 1:xianshi.setText("收到线程1的消息");break;
                case 2:xianshi.setText("收到线程2的消息");break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xiaoxi1=findViewById(R.id.xiaoxi1);
        xiaoxi2=findViewById(R.id.xiaoxi2);
        xianshi=findViewById(R.id.xianshi);

        xiaoxi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 new Thread(new Runnable() {
                     @Override
                     public void run() {
                         Message message=new Message();
                         message.what=1;
                         handler.sendMessage(message);
                     }
                 }).start();

            }
        });
        xiaoxi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message=new Message();
                        message.what=2;
                        handler.sendMessage(message);
                    }
                }).start();

            }
        });




    }
}
