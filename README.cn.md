[English](https://github.com/xingliuhua/XLHRatingBar/blob/master/README.md)
# XLhRatingBar

一个自定义的android RatingBar，无固定样式，一切由你指定。

<img src="https://github.com/xingliuhua/XLHRatingBar/blob/master/screenshot_1571735043111.jpg" height="330" width="190" >

## 背景
我们常常要使用到RatingBar来做一些评分、进度、等级功能。android.widget.RatingBar可以实现一些简单效果，我们可以利用
layer-list和android:progressDrawable。我们还可以放置一些图片，当点击的时候改变图片的样式来实现。

我们如果想实现一些复杂的效果，这些方案就有点麻烦了：
* 每次半颗星
* 每颗星的大小不一
* 第1、3、5是半颗，第2、4、6是整颗
* 竖向或者斜向放置

他们都显得那么笨重，不够灵活，扩展性也非常差。

## 功能

* 每个内部单元控件（就是星星）有三种状态：未选中、选中一半、全选中。
* 内部单元控件的选中状态由用户在回调中根据点击的位置自己判断。
* 自定义每个内部单元控件的样式，用户可根据单元控件的位置、状态动态返回控件。
* 自定义属性或代码设置内部单元控件的总数，已选个数。
* 选中状态的监听。

## 安装

```gradle
dependencies {
	//other dependencies...
	compile 'com.xingliuhua:xlhratingbar_lib:4.0'
}


## 使用
### SimpleRatingView
该库以及默认实现了简单的样式及功能,默认共5颗星，每次最小可以改变半颗。可以直接在代码或xml文件中使用。
```java
XLHRatingBar xlhRatingBar = new XLHRatingBar(this);
//添加到容器布局中即可
```
或者在xml布局中
```xml
<com.xingliuhua.xlhratingbar.XLHRatingBar
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:numStars="5"
                app:rating="2.5" />
```
### 自定义样式
#### 实现接口IRatingView
IRatingView就是单个内部控件的行为抽象，你可以根据自己的业务需求来返回对应的值，可以参考SimpleRatingView默认实现。
```java
public interface IRatingView {
    /**
     * you can change your item style by state and position. eg:color,text size.
     * @param state STATE_NONE,STATE_HALF,STATE_FULL
     * @param position star index. start from 0
     * @param starNums star item number
     */
    void setCurrentState(int state,int position,int starNums);

    /**
     * return you start item view,you can custom item by positon
     * @param context
     * @param position star index. start from 0
     * @param starNums star item number
     * @return
     */
    ViewGroup getRatingView(Context context,int position,int starNums);

    /**
     * not selected
     */
    public static final int STATE_NONE = 0;
    /**
     * select half
     */
    public static final int STATE_HALF = 1;
    /**
     * selected
     */
    public static final int STATE_FULL = 2;

}
```

#### 在布局中引用并指定IRatingView的实现类。

```xml
<com.example.xlhratingbar.XLHRatingBar
		xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical"
        app:numStars="5"
        app:rating="5"
        app:ratingViewClass="com.example.xlhratingbar_lib.SimpleRatingView"
        />
```


#### 代码中使用


```java
 LinearLayout llContainer = (LinearLayout) findViewById(R.id.ll_container);
 XLHRatingBar xlhRatingBar = new XLHRatingBar(this);
 xlhRatingBar.setNumStars(3);
 xlhRatingBar.setEnabled(false);//can not change rating by touch
 xlhRatingBar.setRatingViewClassName("com.example.xlhratingbar.MyRatingView4");
 xlhRatingBar.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
     @Override
     public void onChange(float rating, int numStars) {
        Toast.makeText(getApplicationContext(), "rating:" + rating, 0).show();
     }
 });
 llContainer.addView(xlhRatingBar);
```

### 维护者

[@xingliuhua](https://github.com/xingliuhua).

### 如何贡献

非常欢迎你的加入! 提一个Issue 或者提交一个 Pull Request.
