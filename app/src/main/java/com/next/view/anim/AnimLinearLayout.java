package com.next.view.anim;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.next.view.round.RoundLinearLayout;

/**
 * ClassName:动画线性布局类
 *
 * @author Afton
 * @time 2023/10/25
 * @auditor
 */
public class AnimLinearLayout extends RoundLinearLayout {

    public AnimLinearLayout(@NonNull Context context) {
        super(context);
    }

    public AnimLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public AnimLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() || isLongClickable()) {
            AnimConfig.getInstance().getTouchAnimCallBack().onTouchEvent(this, motionEvent);
        }

        return super.onTouchEvent(motionEvent);
    }
}