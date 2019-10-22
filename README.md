you can custom star style

<img src="https://github.com/xingliuhua/XLHRatingBar/blob/master/20180807210646.png" height="330" width="190" >


## How to use
### add the library as dependency

Add the library as dependency to your build.gradle file.
```gradle
dependencies {
	//other dependencies...
	compile 'com.xingliuhua:xlhratingbar_lib:2.1'
}
```
### implement interface
implement IRatingViewand  to custom your star UI.of course,you can see SimpleRatingView
```java
public interface IRatingView {
    /**
     * get image resource state by posi and state
     *
     * @param posi
     * @param state
     * @return
     */
    int getStateRes(int posi, int state);

    /**
     * @param rating
     * @param numStars
     * @param position from 0
     * @return
     */
    int getCurrentState(float rating, int numStars, int position);

    /**
     * get a ImageView,you can set LinearLayout.LayoutParams for your ImageView
     *
     * @param context
     * @param posi    from 0
     * @return
     */
    ImageView getRatingView(Context context,int numStars, int posi);

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
SimpleRatingView:
```java
public class SimpleRatingView implements IRatingView {

    @Override
    public int getStateRes(int posi, int state) {
        int id = R.drawable.ic_star_border_red_400_36dp;
        switch (state) {
            case STATE_NONE:
                id = R.drawable.ic_star_border_red_400_36dp;
                break;
            case STATE_HALF:
                id = R.drawable.ic_star_half_red_400_36dp;
                break;
            case STATE_FULL:
                id = R.drawable.ic_star_red_400_36dp;
                break;
            default:
                break;
        }
        return id;
    }

    @Override
    public int getCurrentState(float rating, int numStars, int position) {
        position++;
        float dis = position - rating;
        if (dis <= 0) {
            return STATE_FULL;
        }
        if (dis == 0.5) {
            return STATE_HALF;
        }
        if (dis > 0.5) {
            return STATE_NONE;
        }
        return 0;
    }


    @Override
    public ImageView getRatingView(Context context, int numStars, int posi) {
        ImageView imageView = new ImageView(context);
        return imageView;
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
 xlhRatingBar.setRatingView(new SimpleRatingView5());
```
other:

```java
 xlhRatingBar.setNumStars(7);
 xlhRatingBar.setRating(5);
 xlhRatingBar.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(float rating, int numStars) {
                Toast.makeText(getApplicationContext(), "rating:" + rating, Toast.LENGTH_SHORT).show();
            }
 });
findViewById(R.id.btn_get_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "rating:" + xlhRatingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
});
```
