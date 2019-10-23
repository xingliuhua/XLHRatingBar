you can custom star item style. eg:image,text and so on.

<img src="https://github.com/xingliuhua/XLHRatingBar/blob/master/screenshot_1571735043111.jpg" height="330" width="190" >


## How to use
### add the library as dependency

Add the library as dependency to your build.gradle file.
```gradle
dependencies {
	//other dependencies...
	compile 'com.xingliuhua:xlhratingbar_lib:3.1.1'
}
```
### implement interface
implement IRatingView and  to custom your star UI.of course,you can see SimpleRatingView
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

SimpleRatingView implemented the interface:
```java
public class SimpleRatingView implements IRatingView {

    ViewGroup mViewGroup;

    @Override
    public void setCurrentState(int state, int position,int starNums) {

        TextView textView = mViewGroup.findViewById(R.id.tv_state);
        ImageView ivStar = mViewGroup.findViewById(R.id.iv_star);
        switch (state) {
            case IRatingView.STATE_NONE:
                ivStar.setImageResource(R.drawable.icon_star_none);
                textView.setText("none");
                break;
            case IRatingView.STATE_HALF:
                ivStar.setImageResource(R.drawable.icon_star_half);

                textView.setText("half");
                break;
            case IRatingView.STATE_FULL:
                ivStar.setImageResource(R.drawable.icon_star_full);

                textView.setText("full");

                break;
        }
    }

    @Override
    public ViewGroup getRatingView(Context context, int position,int starNums) {
        View inflate = View.inflate(context, R.layout.rating, null);
        mViewGroup = (ViewGroup) inflate;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.weight=1;
        mViewGroup.setLayoutParams(layoutParams);
        return mViewGroup;
    }
}
```

### use XLHRatingBar in xml

```xml
<com.example.xlhratingbar_lib.XLHRatingBar
		xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical"
        app:numStars="5"
        app:rating="5"
        app:ratingViewClass="com.example.xlhratingbar_lib.SimpleRatingView"
        />
```
you can set star num ,rating and ratingView class name

### set view
you can set rating view by code or xml
set view by code:

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

