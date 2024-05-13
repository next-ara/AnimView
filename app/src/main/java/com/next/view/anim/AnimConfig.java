package com.next.view.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.MotionEvent;

/**
 * ClassName:动画配置类
 *
 * @author Afton
 * @time 2023/10/25
 * @auditor
 */
public class AnimConfig {

    private static AnimConfig animConfig;

    //点击动画回调对象
    private TouchAnimCallBack touchAnimCallBack;

    public static AnimConfig getInstance() {
        if (animConfig == null) {
            animConfig = new AnimConfig();
        }

        return animConfig;
    }

    private AnimConfig() {
    }

    /**
     * 设置点击动画回调对象
     *
     * @param touchAnimCallBack 点击回调对象
     */
    public void setTouchAnimCallBack(TouchAnimCallBack touchAnimCallBack) {
        this.touchAnimCallBack = touchAnimCallBack;
    }

    /**
     * 获取点击动画回调对象
     *
     * @return 点击动画回调对象
     */
    public TouchAnimCallBack getTouchAnimCallBack() {
        if (this.touchAnimCallBack == null) {
            this.touchAnimCallBack = this.getScaleAnim();
        }

        return this.touchAnimCallBack;
    }

    /**
     * 获取缩放动画回调对象
     *
     * @return 缩放动画回调对象
     */
    public TouchAnimCallBack getScaleAnim() {
        return (view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(200L);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.92f);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.92f);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.7f);
                    animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
                    animatorSet.start();
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.setDuration(250L);
                    ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "scaleX", 0.92f, 1.0f);
                    ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "scaleY", 0.92f, 1.0f);
                    ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, "alpha", 0.7f, 1.0f);
                    animatorSet2.play(ofFloat4).with(ofFloat5).with(ofFloat6);
                    animatorSet2.start();
                    break;
            }
        };
    }
}