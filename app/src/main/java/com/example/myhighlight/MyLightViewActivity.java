package com.example.myhighlight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyLightViewActivity extends AppCompatActivity implements View.OnClickListener, MyViewHelper.setOnLightClick {
    private Button button, anotherbBtton;
    private MyLightView myLightView;
    private List<View> viewList;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_light_view);
        myLightView = new MyLightView(this);
        button = findViewById(R.id.button);
        anotherbBtton = findViewById(R.id.anotherbBtton);
        button.setOnClickListener(this);
        anotherbBtton.setOnClickListener(this);

        MyViewHelper.getInstance().setOnLightClicListener(new MyViewHelper.setOnLightClick() {
            @Override
            public void onClick(View view) {
                if (viewList.size() > count) {
                    MyViewHelper.getInstance().dismissLight();
                    MyViewHelper.getInstance().showLightView(MyLightViewActivity.this, viewList.get(count), "测试说明");
                    viewList.remove(count);
                } else {
                    MyViewHelper.getInstance().dismissLight();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                MyViewHelper.getInstance().showLightView(MyLightViewActivity.this, button, "第一个");
                //这里只是模拟，意思是在list中添加你想要实现高亮的控件，因为这个按钮已经实现了高亮，所以不添加在list中
                viewList = new ArrayList<>();
//                viewList.add(button);
                viewList.add(anotherbBtton);
//                viewList.remove(button);
                break;
            case R.id.anotherbBtton:
                Toast.makeText(this, "哈哈哈", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
