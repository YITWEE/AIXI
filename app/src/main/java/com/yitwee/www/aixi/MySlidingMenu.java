package com.yitwee.www.aixi;

/**
 * Created by cjb on 2016/10/25.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewHelper;
import com.yitwee.www.utils.ScreenUtils;
/**
 * Created by cjb on 2016/10/23.
 */

public class MySlidingMenu extends HorizontalScrollView {
    public ViewGroup menu,content;
    private int mDownX;//手指初次按下的X坐标
    private int mDownY;//手指初次按下的Y坐标
    private long mPressTime;
    private int mScreenWidth;
    private int mMenuRightPadding = mScreenWidth/5;


    private int mMenuWidth;
    private int mHalfMenuWidth;
    private boolean once;

    private boolean IsPullMenu=false;
    private boolean isOpen;
    public MySlidingMenu(Context context) {
        super(context);
    }

    public MySlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScreenWidth = ScreenUtils.getScreenWidth(context);
    }
    public MySlidingMenu(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mScreenWidth = ScreenUtils.getScreenWidth(context);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.MySlidingMenu, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++)
        {
            int attr = a.getIndex(i);
            switch (attr)
            {
                case R.styleable.MySlidingMenu_rightPadding:
                    // 默认50
/*                    mMenuRightPadding = a.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_DIP, 50f,
                                    getResources().getDisplayMetrics()));// 默认为10DP*/
                    mMenuRightPadding=mScreenWidth/5;
                    break;
            }
        }
        a.recycle();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        /**
         * 显示的设置一个宽度
         */
        if (!once)
        {
            LinearLayout wrapper = (LinearLayout) getChildAt(0);
            menu = (ViewGroup) wrapper.getChildAt(0);
            content = (ViewGroup) wrapper.getChildAt(1);
            // dp to px
            mMenuRightPadding = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, mMenuRightPadding, content
                            .getResources().getDisplayMetrics());

    //        mMenuWidth = mScreenWidth - mMenuRightPadding;
            mMenuWidth=mScreenWidth*4/5;
            mHalfMenuWidth = mMenuWidth / 2;
            menu.getLayoutParams().width = mMenuWidth;
            content.getLayoutParams().width = mScreenWidth;

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        super.onLayout(changed, l, t, r, b);
        if (changed||IsPullMenu==true)
        {
            // 将菜单隐藏
            this.scrollTo(mMenuWidth, 0);
            once = true;
            IsPullMenu=false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mDownX= (int) ev.getX();
                mPressTime=System.currentTimeMillis();
                if(mDownX>=mMenuWidth&&menu.getVisibility()==VISIBLE) return true;
                break;

        }
        if(isOpen)return super.onInterceptTouchEvent(ev);
        else return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        Log.i("tag","MySlidingMenu--------onTouch");
        int action = ev.getAction();
        if(IsPullMenu==true)
        {
              menu.setVisibility(View.VISIBLE);
        }
        if(menu.getVisibility()==VISIBLE){
            switch (action)
            {
                // Up时，进行判断，如果显示区域大于菜单宽度一半则完全显示，否则隐藏
       /*     case MotionEvent.ACTION_DOWN:
                 if(ev.getX()>mMenuWidth&&isOpen){
                     this.smoothScrollTo(mMenuWidth, 0);
                     this.setVisibility(View.GONE);
                     isOpen = false;
                 }
                return true;*/
                case MotionEvent.ACTION_DOWN:
                    Log.i("tag","MySlidingMenu--------onTouchdown");
                    // mDownX= (int) ev.getX();
                    //mPressTime=System.currentTimeMillis();
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.i("tag","MySlidingMenu--------onTouchmove");
                    break;

                case MotionEvent.ACTION_UP:
                    Log.i("tag","MySlidingMenu--------onTouchup");
                    Log.i("mDownX", String.valueOf(mDownX));
                    Log.i("mupX", String.valueOf(ev.getX()));
                    boolean flag=(System.currentTimeMillis()-mPressTime)<=500
                            &&((mDownX>=mScreenWidth*4/5&&ev.getX()<=mScreenWidth*4/5)||((mDownX-ev.getX())>=mScreenWidth/10));
                    if (flag)
                    {
                        this.smoothScrollTo(mMenuWidth, 0);
                        menu.setVisibility(View.GONE);
                        IsPullMenu=false;
                        isOpen = false;
                        return true;
                    }

                    if(mDownX>=mMenuWidth&&Math.abs(ev.getX()-mDownX)<=3){
                        this.smoothScrollTo(mMenuWidth, 0);
                        menu.setVisibility(View.GONE);
                        IsPullMenu=false;
                        isOpen = false;
                        return true;
                    }

                    int scrollX = getScrollX();
                    if (scrollX > mHalfMenuWidth)
                    {
                        this.smoothScrollTo(mMenuWidth, 0);
                        menu.setVisibility(View.GONE);
                        IsPullMenu=false;
                        isOpen = false;
                    }
                    else
                    {
                        this.smoothScrollTo(0, 0);
                        IsPullMenu=false;
                        isOpen = true;
                    }
                    return true;
            }
        }
        return super.onTouchEvent(ev);
    }
    /**
     * 打开菜单
     */
    public void openMenu()
    {
        if (isOpen)
            return;
        this.smoothScrollTo(0, 0);
        ViewHelper.setAlpha(content, 0.6f);
        isOpen = true;
    }

    /**
     * 关闭菜单
     */
    public void closeMenu()
    {
        if (isOpen)
        {
            this.smoothScrollTo(mMenuWidth, 0);
            isOpen = false;
        }
    }
    /**
     * 切换菜单状态
     */
    public void toggle()
    {
        if (isOpen)
        {
            closeMenu();
        } else
        {
            openMenu();
        }
    }
    /**
    * 获取菜单状态
     */
    public boolean getisOpen()
    {
        return isOpen;
    }
    /**
     * 设置菜单状态
     */
    public void setOpen(boolean open) {
        isOpen = open;
    }


    public void setPullMenu(boolean pullMenu) {
        IsPullMenu = pullMenu;
    }

    public boolean getPullMenu() {
        return IsPullMenu ;
    }



    /**
     * 获取菜单宽度
     */
    public int getmMenuWidth() {
        return mMenuWidth;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
            float scale = l * 1.0f / mMenuWidth;
            float leftScale = 1 - 0.6f * scale;
        //    float rightScale = 0.8f + scale * 0.2f;
            ViewHelper.setScaleX(menu, leftScale);
            ViewHelper.setScaleY(menu, leftScale);
            ViewHelper.setAlpha(menu, 0.6f + 0.4f * (1 - scale));
        if(menu.getVisibility()==VISIBLE) ViewHelper.setAlpha(content, 0.6f + 0.4f * scale);
        else ViewHelper.setAlpha(content, 0.6f + 0.4f * (1 - scale));

//        ViewHelper.setTranslationX(menu, mMenuWidth * scale * 0.6f);
            ViewHelper.setTranslationX(menu, mMenuWidth * scale);
//        ViewHelper.setPivotX(content, 0);
//        ViewHelper.setPivotY(content, content.getHeight() / 2);
//        ViewHelper.setScaleX(content, rightScale);
//        ViewHelper.setScaleY(content, rightScale);
    }

    public void LeftMove(int x) {
      //  menu.setVisibility(View.VISIBLE);
        //this.smoothScrollTo(x,0);

    }
}
