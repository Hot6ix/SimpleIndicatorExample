# Simple Indicator
Simple indicator for Android

Very simple indicator for light app.

![Image](https://imgur.com/dS0cz3R.gif)

## Sample  

    <com.j.simples.simpleindicator.Indicator
        android:id="@+id/indicator"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:layout_margin="10dp"
        app:indicatorCount="4"
        app:indicatorRadius="10dp"
        app:indicatorSpaceBetween="10dp"
        app:indicatorColor="#ffffff"
        app:indicatorSelectedColor="#9e9e9e"
        app:indicatorStrokeColor="#9e9e9e"
        app:indicatorStrokeWidth="2dp"
        app:selected="1" />
        
## Attributes

| Attribute | Type | Comment | Default value |
|---|---|---|---|
| indicatorCount | Integer | Set indicator count | 0 |
| indicatorRadius | Dimension | Set indicator radius | 8dp |
| indicatorSpaceBetween | Dimension | Set space between indicators | 10dp |
| indicatorColor | Color | Set normal state indicator color | #e0e0e0 |
| indicatorSelectedColor | Color | Set selected state indicator color | #9e9e9e |
| inidicatorStrokeColor | Color | Set indicator stroke color | 0 |
| indicatorStrokeWidth | Dimension | Set indicator stroke width | 0 |
| selected | Integer | Set selected indicator | 0 |

## Method  

| Method | Comment |
|---|---|
| next() | Go to next |
| prev() | Go to previous |
| select(index) | Go to index |
| getCurrentSelected() | Get current selected Indicator index |
| getIndicatorCount() | Get indicator count |

