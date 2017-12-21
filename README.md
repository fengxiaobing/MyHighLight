# MyHighLight
学完了自定义view之后，自己写了一个高亮的控件，欢迎指教
先放一张效果图：
![效果展示图](https://github.com/fengxiaobing/MyHighLight/blob/master/showgif.gif)


代码说明：

  1.已经对自定义的高亮控件进行了封装，并且与activity之间通过一个工具类MyViewHelper进行传递
  
  2.只是进行了初步封装，还有一些不完善的有待补充，比如没有把绘制高亮的形状类型作为参数提取出来（圆形还是矩形）和文字说明位于控件的方向（默认右上方）没有作为参数提取出来。
  
使用方式：

  (展示高亮)showLightView(Activity mActivity, View myFocusView, String text)
  
  该方法为显示高亮控件的方法：
  
      参数一（mActivity）：因为需要动态创建view，所以必须要用到activity
      
      参数二（myFocusView）：即需要被高亮展示的控件
      
      参数三（text）：控件右上角的文字说明的内容
 （高亮消失）removeView()；


注：因为高亮的实现可以有两种方式：画布的裁剪（Region.Op）实现和画笔的绘制（Xfermode来实现）。不过我个人觉得使用画笔来实现的可扩展性相对高一些。
