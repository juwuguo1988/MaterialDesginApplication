package cn.jwg.materialdesgin.core.common.views.pickers.listeners;

import android.view.GestureDetector;
import android.view.MotionEvent;
import cn.jwg.materialdesgin.core.common.views.wheelview.WheelView;


final public class WheelViewGestureListener extends GestureDetector.SimpleOnGestureListener {

    final WheelView wheelView;

    public WheelViewGestureListener(WheelView wheelView) {
        this.wheelView = wheelView;
    }

    @Override
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        wheelView.scrollBy(velocityY);
        return true;
    }
}
