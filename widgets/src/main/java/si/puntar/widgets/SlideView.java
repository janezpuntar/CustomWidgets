package si.puntar.widgets;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class SlideView extends FrameLayout implements View.OnTouchListener {

    private float dragOffsetY;
    private int width, height;

    private GestureDetector gestureDetector;

    public SlideView(Context context) {
        super(context);
        init(context);
    }

    public SlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public SlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SlideView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(parentWidth, parentHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        height = getMeasuredHeight();
        width = getMeasuredWidth();

        animate().setDuration(0).y(height - getChildAt(0).getTop()).start();
    }

    private void init(Context context) {
        setOnTouchListener(this);
        gestureDetector = new GestureDetector(context, new MyGestureDetector(this));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                dragOffsetY = getY() - event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                animate().setDuration(0)
                        .y((int) (event.getRawY() + dragOffsetY))
                        .start();
                break;
        }

        gestureDetector.onTouchEvent(event);
        return true;
    }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {

        private View view;
        private ObjectAnimator animator;

        public MyGestureDetector(View view) {
            this.view = view;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e1.getRawY() > e2.getRawY()) {
                animator = ObjectAnimator.ofFloat(view, View.Y, (int) e2.getRawY() + dragOffsetY, 0);
            } else {
                animator = ObjectAnimator.ofFloat(view, View.Y, (int) e1.getRawY() - dragOffsetY, height - getChildAt(0).getTop());
            }
            animator.start();

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
