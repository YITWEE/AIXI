package com.yitwee.www.aixi;

import android.app.Application;

/**
 * Created by cjb on 2016/11/11.
 */

public class MyApplication extends Application {
    // 程序退出标记
    private static boolean isProgramExit = false;
    public void setExit(boolean exit) {
        isProgramExit= exit;
    }
    public boolean isExit() {
        return isProgramExit;
    }
}
