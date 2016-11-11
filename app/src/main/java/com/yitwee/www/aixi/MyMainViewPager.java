package com.yitwee.www.aixi;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by cjb on 2016/11/11.
 */

public class MyMainViewPager extends ViewPager {
    private boolean isCanScroll = true;
    public MyMainViewPager(Context context) {
        super(context);
    }
    public MyMainViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setScanScroll(boolean isCanScroll){
        this.isCanScroll = isCanScroll;
    }
  /*  @Override
    public void scrollTo(int x, int y) {
        if (isCanScroll) {
            super.scrollTo(x, y);
        }
    }*/
  @Override
  public boolean onTouchEvent(MotionEvent ev) {
      if (isCanScroll)
          return super.onTouchEvent(ev);
      else
          return false;
  }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isCanScroll)
            return super.onInterceptTouchEvent(ev);
        else
            return false;
    }
    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }
    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);   //表示切换的时候，不需要切换时间。
        //避免点击标签切换多个page页面时出现闪烁，影响用户体验
    }
}
