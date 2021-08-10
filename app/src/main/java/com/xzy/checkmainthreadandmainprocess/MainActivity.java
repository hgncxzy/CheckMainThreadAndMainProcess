package com.xzy.checkmainthreadandmainprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import static com.xzy.checkmainthreadandmainprocess.IsMainThread.isMainThread01;
import static com.xzy.checkmainthreadandmainprocess.IsMainThread.isMainThread02;
import static com.xzy.checkmainthreadandmainprocess.IsMainThread.isMainThread03;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("result", isMainThread01() + "--" + isMainThread02() + "--"
                + isMainThread03());
        try {
            IsMainProcess isMainProcess = new IsMainProcess();
            Log.d("", "isMainProcess:" + isMainProcess.isMainProcess(this));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}