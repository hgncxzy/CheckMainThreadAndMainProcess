package com.xzy.checkmainthreadandmainprocess;

import android.os.Looper;
import android.util.Log;

public class IsMainThread {

    public static boolean isMainThread01() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean isMainThread02() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean isMainThread03() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }
}
