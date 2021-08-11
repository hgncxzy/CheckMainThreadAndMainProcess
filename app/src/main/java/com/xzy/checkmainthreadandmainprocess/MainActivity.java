package com.xzy.checkmainthreadandmainprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.xzy.checkmainthreadandmainprocess.service.MyService;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.xzy.checkmainthreadandmainprocess.IsMainThread.isMainThread01;
import static com.xzy.checkmainthreadandmainprocess.IsMainThread.isMainThread02;
import static com.xzy.checkmainthreadandmainprocess.IsMainThread.isMainThread03;

/**
 * 检查是否是主线程、是否是主进程
 *
 * @author xzy
 */
public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkIsMainThread();
        checkIsMainProcess();

        // 开启其他进程
        intent = new Intent(this, MyService.class);
        startService(intent);
    }

    private void checkIsMainThread() {
        // main thread test.

        Log.d(Common.TAG, "isMainThread:" + isMainThread01() + "--" + isMainThread02() + "--"
                + isMainThread03());

        // other thread test.
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2,
                60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Log.d(Common.TAG, "isMainThread2:" + isMainThread01() + "--" + isMainThread02() + "--"
                        + isMainThread03());
            }
        });
    }


    private void checkIsMainProcess() {
        try {
            IsMainProcess isMainProcess = new IsMainProcess();
            Log.d(Common.TAG, "MainActivity 在主进程:" + isMainProcess.isMainProcess(this));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (intent != null) {
            stopService(intent);
        }
    }
}