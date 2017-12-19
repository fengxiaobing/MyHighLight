package com.example.myhighlight;

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
        myView = new MyView(this);
//        myView.setPointX(new Point(200,200));
//        myView.setPointY(new Point(800,800));
//        decorView.addView(myView);
        
       final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
//                myView.setPointX(new Point(100,100));
//                myView.setPointY(new Point(200,200));
                myView.setView(button);
                decorView.addView(myView);
            }
        });

    }
}
