# CustomWidgets


**Simple Custom Android Views**

Library is added to jCenter. If you are not using jCenter add repository below.

```
maven { url "http://dl.bintray.com/janez/maven" }
```
and
```
compile 'si.puntar.widgets:widgets:1.0'
```


For now most important thing is to setup **layout_marginTop** to first child in SlideView. In out sample we have 60dp of **slide_view** visible on screen. It is used to handle whole pannel.

It's recommended to use only one child view of **si.puntar.widgets.SlideView**. 
```
<si.puntar.widgets.SlideView
        android:id="@+id/slide_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/holo_green_light"
        android:orientation="vertical">

        <ScrollView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_marginTop="60dp"
                android:background="@android:color/holo_blue_light">
```

If you find any other usage of this library please contact me and I will update this file.

