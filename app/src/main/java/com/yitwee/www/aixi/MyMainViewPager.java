package com.yitwee.www.aixi;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by cjb on 2016/11/11.
 */

public class MyMainViewPager extends ViewPager {
    private boolean isCanScroll = false;
    private int mDownX;//手指初次按下的X坐标
    private int mDownY;//手指初次按下的Y坐标
    private MySlidingMenu mySlidingMenu;
    private ViewGroup slidingMenu;
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

      mySlidingMenu.setPullMenu(true);
      if (isCanScroll)
          return super.onTouchEvent(ev);
      else
          return false;
  }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

//        Log.i("tag","MyMainMenu--------onTouch");

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("tag", "MyMainMenu--------onTouchdown");
                mySlidingMenu.setPullMenu(true);
                mDownX = (int) ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                if (ev.getX() - mDownX >= 5) {
                    mySlidingMenu.setPullMenu(true);
                    mySlidingMenu.LeftMove(10);
                    return true;
                }
                    break;
        }
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

    public void setMenu(MySlidingMenu mySlidingMenu, ViewGroup slidingMenu){
        this.slidingMenu=slidingMenu;
        this.mySlidingMenu=mySlidingMenu;
    }
}
