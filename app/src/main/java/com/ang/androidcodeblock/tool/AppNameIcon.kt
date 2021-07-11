package com.ang.androidcodeblock.tool

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log
import com.ang.androidcodeblock.MainActivity

object AppNameIcon {
    private val TAG: String = "AppNameIcon"

    /**
     * 获取应用程序名称
     */
    fun getAppName(context: Context) {
        try {
            val packageManager = context.packageManager;
            val applicationInfoList: List<ApplicationInfo> =
                packageManager.getInstalledApplications(PackageManager.MATCH_UNINSTALLED_PACKAGES);
            for (info in applicationInfoList) {
                val labelRes = info.packageName;
                val name = info.loadLabel(packageManager);
                Log.d(TAG, labelRes + name);
            }
        } catch (e: Exception) {
            e.printStackTrace();
        }
    }
}