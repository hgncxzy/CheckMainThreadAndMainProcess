package com.xzy.checkmainthreadandmainprocess.app;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

import com.xzy.checkmainthreadandmainprocess.IsMainProcess;

import static com.xzy.checkmainthreadandmainprocess.Common.TAG;

/**
 * @author ：created by xzy.
 * @date ：2021/8/11
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"执行了Application中的onCreate方法");
        handleTest();
    }


    private void handleTest() {
        try {
            IsMainProcess isMainProcess = new IsMainProcess();
            if(isMainProcess.isMainProcess(this)){
                Log.d(TAG, "当前进程是主进程");
            }else{
                Log.d(TAG, "当前进程不是主进程");
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
