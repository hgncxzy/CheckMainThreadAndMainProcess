package com.xzy.checkmainthreadandmainprocess;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;

import java.util.List;

/**
 * https://www.jianshu.com/p/ff501fdae476
 */
public class IsMainProcess {


    /**
     * 判断是否主进程
     * @param context 上下文
     * @return true是主进程
     */
    public boolean isMainProcess(Context context) throws PackageManager.NameNotFoundException {
        return isPidOfProcessName(context, Process.myPid(), getMainProcessName(context));
    }

    /**
     * 获取当前App所有进程
     */
    public List<ActivityManager.RunningAppProcessInfo> getRunningAppProcessInfos(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        return am.getRunningAppProcesses();
    }

    /**
     * 判断该进程ID是否属于该进程名
     *
     * @param context
     * @param pid     进程ID
     * @param p_name  进程名
     * @return true属于该进程名
     */
    public boolean isPidOfProcessName(Context context, int pid, String p_name) {
        if (p_name == null)
            return false;
        boolean isMain = false;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        //遍历所有进程
        for (ActivityManager.RunningAppProcessInfo process : am.getRunningAppProcesses()) {
            if (process.pid == pid) {
                //进程ID相同时判断该进程名是否一致
                if (process.processName.equals(p_name)) {
                    isMain = true;
                }
                break;
            }
        }
        return isMain;
    }

    /**
     * 获取主进程名
     *
     * @param context 上下文
     * @return 主进程名
     */
    public String getMainProcessName(Context context) throws PackageManager.NameNotFoundException {
        return context
                .getPackageManager()
                .getApplicationInfo(context.getPackageName(), 0)
                .processName;
    }
}
