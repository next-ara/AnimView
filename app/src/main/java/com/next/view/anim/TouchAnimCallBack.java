package com.next.view.anim;

import android.view.MotionEvent;
import android.view.View;

/**
 * ClassName:点击动画回调接口
 *
 * @author Afton
 * @time 2023/10/25
 * @auditor
 */
public interface TouchAnimCallBack {

    /**
     * 点击事件回调
     *
     * @param view        控件
     * @param motionEvent 事件
     */
    void onTouchEvent(View view, MotionEvent motionEvent);
}