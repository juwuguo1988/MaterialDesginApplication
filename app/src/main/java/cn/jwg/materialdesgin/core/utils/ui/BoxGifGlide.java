package cn.jwg.materialdesgin.core.utils.ui;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 药盒开关盖gif动画
 */
public class BoxGifGlide {
    private RequestManager manager;

    public BoxGifGlide(Context mcontext) {
        manager = Glide.with(mcontext);
    }

    /**
     * gif开始
     *
     * @param drawableId
     * @param imgView
     */
    public void startOpen(int drawableId, ImageView imgView) {
        manager.load(drawableId)
                .asGif()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imgView);
    }


    public void stopGif() {
        if (null != manager) {
            manager.onStop();
        }
    }
}
