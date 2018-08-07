# XLHRatingBar
自定义Ratingbar，与系统提供的RatingBar相比可更方便指定每个星星的图标、大小及各个星星的间距，支持监听选中状态的变化
---------
## 在xml布局文件中使用：  
```xml
  <com.example.xlhratingbar_lib.XLHRatingBar
    xmlns:xlhRatingBar="http://schemas.android.com/apk/res-auto"
        android:id="@+id/ratingBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        xlhRatingBar:canEdit="true"
        xlhRatingBar:differentSize="true"
        xlhRatingBar:dividerWidth="5dp"
        xlhRatingBar:rating="2"
        xlhRatingBar:starCount="5"
        xlhRatingBar:stateResId="@drawable/comment_ratingbar_selector"
        xlhRatingBar:widthAndHeight="50dp"
        />
 ```
 其定义属性中：<br>
 * canEdit true 可以点击选择不同的星星，默认false
 * differentSize 星星的大小可以不同（中间的最大，两端的依次变小且星星总数为奇数时才有效）
 * dividerWidth 单个星星之间的间隔
 * starCount 星星的总个数
 * widthAndHeight 星星的大小
 * rating 已经选择的星星的个数
 * stateResId单个星星的不同状态,在drawable下：</br>
 ```xml
 <selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/evaluation_order_star_press" android:state_checked="true"></item>
    <item android:drawable="@drawable/evaluation_order_star" android:state_checked="false"></item>
</selector>
 ```
   
   
 ## 在代码中使用：
 ```java
  XLHRatingBar ratingBar = (XLHRatingBar) findViewById(R.id.ratingBar);
        ratingBar.setCountNum(5);
        ratingBar.setCountSelected(1);
        ratingBar.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(int rating) {
                tvResult.setText(rating + "");
            }
        });
 ```
 <br>附上效果图一张<br>
 ![](https://github.com/xingliuhua/XLHRatingBar/raw/master/result.png)<br>
----
## 引用
gradle dependency<br>
```xml
dependencies {
     compile 'com.xingliuhua:xlhratingbar_lib:1.0.1'
}
 ```

