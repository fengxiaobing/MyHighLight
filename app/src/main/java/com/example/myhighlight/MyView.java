package com.example.myhighlight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2017/12/19.
 */

public class MyView extends View{
    private Paint paint;
    private Point pointX,pointY;
    private View view;

    int top, left,right,bottom;

    public void setView(View view) {
        this.view = view;
        top = view.getTop();
        left =view.getLeft();
        bottom = view.getBottom();
        right = view.getRight();

    }

    public Point getPointX() {
        return pointX;
    }

    public void setPointX(Point pointX) {
        this.pointX = pointX;
    }

    public Point getPointY() {
        return pointY;
    }

    public void setPointY(Point pointY) {
        this.pointY = pointY;
    }

    public MyView(Context context) {
        super(context);
    }



    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipRect(pointX.x,pointX.y,pointY.x,pointY.y, Region.Op.DIFFERENCE);
        canvas.drawColor(Color.parseColor("#80000000"));

    }

}
