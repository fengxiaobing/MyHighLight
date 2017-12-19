package com.example.myhighlight;

import android.content.ServiceConnection;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    ViewGroup decorView;
    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        decorView = (ViewGroup) this.getWindow().getDecorView();

//        myView.setPointX(new Point(200,200));
//        myView.setPointY(new Point(800,800));
//        decorView.addView(myView);
        
       final Button button = findViewById(R.id.button);
       final Button button2 = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
//                myView.setPointX(new Point(100,100));
//                myView.setPointY(new Point(200,200));
                int[] loc = new int[2];
                button.getLocationOnScreen(loc);
//                info.offsetX = loc[0] - padding;
//                info.offsetY = loc[1] - padding;
//                info.width = view.getWidth() + 2 * padding;
//                info.height = view.getHeight() + 2 * padding;
                myView = new MyView(SecondActivity.this);
                myView.setPointX(new Point(loc[0],loc[1]));
                myView.setPointY(new Point(loc[0]+button.getWidth(),loc[1]+button.getHeight()));
                decorView.removeViewAt(1);
                decorView.addView(myView);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
//                myView.setPointX(new Point(100,100));
//                myView.setPointY(new Point(200,200));
                int[] loc = new int[2];
                button2.getLocationOnScreen(loc);
//                info.offsetX = loc[0] - padding;
//                info.offsetY = loc[1] - padding;
//                info.width = view.getWidth() + 2 * padding;
//                info.height = view.getHeight() + 2 * padding;
                myView = new MyView(SecondActivity.this);
                myView.setPointX(new Point(loc[0],loc[1]));
                myView.setPointY(new Point(loc[0]+button2.getWidth(),loc[1]+button2.getHeight()));
                decorView.removeViewAt(1);
                decorView.addView(myView);
            }
        });

    }
}
