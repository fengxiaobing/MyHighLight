package com.example.myhighlight;

import android.app.Activity;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by RF
 * on 2017/12/20.
 */

public class MyViewHelper implements View.OnClickListener {

    private ViewGroup decorView;
    private static MyViewHelper myViewHelper = null;
    private MyLightView myLightView;

    private Activity activity;

    private MyViewHelper() {
    }

    public static MyViewHelper getInstance() {
        if (myViewHelper == null) {
            myViewHelper = new MyViewHelper();
        }
        return myViewHelper;
    }

    /**
     * 展现出控件 高亮的风格
     * @param mActivity 传入的Activity
     * @param myFocusView 需要被高亮显示的控件
     * @param text 需要辅助的文字说明
     *       （文字说明所在位置位于控件右上方，可以手动修改，此处写死在方法中，自己可以修改）
     */
    void showLightView(Activity mActivity, View myFocusView, String text) {
        activity = mActivity;
        int[] loc = new int[2];
        //获取myFocusView控件所在屏幕的位置（即坐标）
        myFocusView.getLocationOnScreen(loc);

        //获取文字说明的控件，因为该控件在xml中，所以需要通过这种方式获取并设置文字显示内容
        View deco_view1 = LayoutInflater.from(mActivity).inflate(R.layout.layout_decor, (ViewGroup) mActivity.getWindow().getDecorView(), false);
        Button mButton = deco_view1.findViewById(R.id.button3);
        mButton.setOnClickListener(this);
        mButton.setText(text);

        //对文字说明控件进行动态布局：辅助需要myFocusView的坐标
        FrameLayout.LayoutParams child_params1 = (FrameLayout.LayoutParams) deco_view1.getLayoutParams();
        child_params1.leftMargin = loc[0] + myFocusView.getWidth();
        child_params1.topMargin = loc[1] - myFocusView.getHeight();

        //将myFocusView的坐标传入自定义view中用于绘制高亮显示区域。同时自定义view为ViewGroup，所以把文字说明的控件也传进去
        myLightView = new MyLightView(mActivity);
        myLightView.setPointX(new Point(loc[0], loc[1]));
        myLightView.setPointY(new Point(loc[0] + myFocusView.getWidth(), loc[1] + myFocusView.getHeight()));
        myLightView.addView(deco_view1);

        //最后设置myLightView的布局，并添加到跟布局decorView中，最终整个布局结束
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        decorView = (ViewGroup) mActivity.getWindow().getDecorView();
        decorView.addView(myLightView, params);
    }

    /**
     * 关闭高亮的显示
     */
    void dismissLight() {
        myLightView.removeView();
    }

    private setOnLightClick setOnLightClick;

    /**
     * 接口回调，此处是文字说明的点击事件
     * @param setOnLightClick
     */
     void setOnLightClicListener(setOnLightClick setOnLightClick) {
        this.setOnLightClick = setOnLightClick;
    }

    public interface setOnLightClick {
        void onClick(View view);
    }

    @Override
    public void onClick(View v) {

        setOnLightClick.onClick(v);
    }
}
