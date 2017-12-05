package cn.jwg.materialdesgin.core.common.views.pickers.task;


import cn.jwg.materialdesgin.core.common.views.pickers.listeners.OnItemPickListener;
import cn.jwg.materialdesgin.core.common.views.wheelview.WheelView;

final public class OnItemPickedRunnable implements Runnable {
    final private WheelView wheelView;
    private OnItemPickListener onItemPickListener;
    public OnItemPickedRunnable(WheelView wheelView, OnItemPickListener onItemPickListener) {
        this.wheelView = wheelView;
        this.onItemPickListener = onItemPickListener;
    }

    @Override
    public final void run() {
        onItemPickListener.onItemPicked(wheelView.getCurrentPosition(),wheelView.getCurrentItem());
    }
}
