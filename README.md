# CustomWidgets


**Simple Custom Android Views**

You have to add in your project:

```
maven { url "http://dl.bintray.com/janez/maven" }
```
and
```
compile 'si.puntar.widgets:widgets:1.0'
```


For now most important thing is to setup margin top to first child in SlideView.
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
            **android:layout_marginTop="60dp"**
            android:background="@android:color/holo_blue_light">
```

