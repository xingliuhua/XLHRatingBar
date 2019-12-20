[中文版](https://github.com/xingliuhua/XLHRatingBar/blob/master/README.cn.md)
# XLhRatingBar

A custom Android ratingbar, no fixed style, everything is specified by you.

<img src="https://github.com/xingliuhua/XLHRatingBar/blob/master/screenshot_1571735043111.jpg" height="330" width="190" >

## Background
We often use the rating bar to do some scoring, progress and rating functions. Android.widget.ratingbar
can achieve some simple effects. We can useLayer list and Android: progressdrawable.
We can also place some pictures and change the style of the pictures when clicking.

If we want to achieve some complex effects, these solutions will be a bit troublesome：
* half step size
* The size of each star varies
* 1、3、5 step size is 0.5, 2、4、6 stop size is 1.
* Vertical or oblique

They are all so cumbersome, inflexible, and poorly scalable.

## Feature

* Each internal unit control (star) has three states: unchecked, half selected, and all selected.
* The selection status of the internal unit control is determined by the user in the callback according to the location of the click.
* Customize the style of each internal cell control. The user can return the control dynamically according to the location and state of the cell control.
* Total number of custom property or code setting internal unit controls, selected.
* Listening in the selected state.

## Install

```gradle
dependencies {
	//other dependencies...
	compile 'com.xingliuhua:xlhratingbar_lib:4.0'
}


## Usage
### SimpleRatingView
The library and the default implementation of a simple style and function, the default total of 5 stars,
each time the minimum can be changed by half. It can be used directly in code or XML files.
```java
XLHRatingBar xlhRatingBar = new XLHRatingBar(this);
//add to viewGroup
```
or xml file:
```xml
<com.xingliuhua.xlhratingbar.XLHRatingBar
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:numStars="5"
                app:rating="2.5" />
```
### custom style
#### implements IRatingView
Iratingview is the behavior abstraction of a single internal control. You can return corresponding
values according to your own business requirements. Please refer to the default implementation of simpleratingview.
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

#### set class name in xml

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


#### or set class name in code


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

### Maintainers

[@xingliuhua](https://github.com/xingliuhua).

## Contributing

Feel free to dive in! [Open an issue] or submit PRs.
