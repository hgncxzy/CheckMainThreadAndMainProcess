package com.xzy.checkmainthreadandmainprocess.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * https://blog.csdn.net/zhe_ge_sha_shou/article/details/74333408
 * @author ：created by xzy.
 * @date ：2021/8/11
 */
public class MyService extends Service {

    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
