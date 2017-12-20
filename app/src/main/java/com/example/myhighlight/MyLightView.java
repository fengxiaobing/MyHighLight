package com.example.myhighlight;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by RF
 * on 2017/12/20.
 */

public class MyLightView extends FrameLayout {
    private Paint maskPaint;
    private PorterDuffXfermode porterDuffXfermode;
    private int maskColor;
    private Point pointX,pointY;

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

    public void removeView() {
        ((ViewGroup) this.getParent()).removeView(this);
    }
    public MyLightView(@NonNull Context context) {
        this(context,null);
    }

    public MyLightView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //设置画笔
        //此处颜色为半透明颜色，也可以通过#80000000来设置
        maskColor = Color.argb(0xCC, 0, 0, 0);
        maskPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        maskPaint.setColor(Color.BLUE);
        maskPaint.setStyle(Paint.Style.FILL);
        maskPaint.setAntiAlias(true);
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.XOR);


        setWillNotDraw(false);
        setClickable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //第一种方式：通过设置画笔setXfermode的属性来实现
        //要想使用 setXfermode() 正常绘制，必须使用离屏缓存 (Off-screen Buffer) 把内容绘制在额外的层上，
        // 再把绘制好的内容贴回 View 中
        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        canvas.drawColor(maskColor);
        // 设置 Xfermode
        maskPaint.setXfermode(porterDuffXfermode);
        canvas.drawOval(pointX.x,pointX.y,pointY.x,pointY.y, maskPaint);
        maskPaint.setTextSize(80);
        canvas.drawText("终于成功了",400,400,maskPaint);
        // 用完及时清除 Xfermode
        maskPaint.setXfermode(null);
        canvas.restoreToCount(saved);



        //第二种方式：通过画布的裁剪来实现
        //这里是通过 canvas.clipRect来实现的，你也可以通过canvas.clipPath()来实现高亮的各种形状
//        canvas.clipRect(pointX.x,pointX.y,pointY.x,pointY.y, Region.Op.DIFFERENCE);

        //此处没有封装，只是抛砖引玉，你可以根据自己的需求进行拓展
//        Path path = new Path();
//        path.addOval(pointX.x,pointX.y,pointY.x,pointY.y,Path.Direction.CCW);
//        canvas.clipPath(path, Region.Op.DIFFERENCE);
//
//        //两种绘制半透明的方式都可以
////        canvas.drawColor(Color.parseColor("#80000000"));
//        canvas.drawColor(maskColor);
    }


    //如果继承的是ViewGroup，那么下面两个方法需要实现，自己来测量的布局，如果继承FrameLayout，那么可以忽略以下两个方法，因为如果继承FrameLayout已经帮你写好
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        measureChildren(widthMeasureSpec,heightMeasureSpec);
//    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        int count = getChildCount();
//        for (int i = 0; i < count; i++) {
//            View view = getChildAt(i);
//            view.layout(100,100,700,700);
//        }
//    }
}
