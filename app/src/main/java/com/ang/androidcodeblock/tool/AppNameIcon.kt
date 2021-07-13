package com.ang.androidcodeblock.tool

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log
import com.ang.androidcodeblock.MainActivity

object AppNameIcon {
    private const val TAG: String = "AppNameIcon"
    private var listener: ((List<ApplicationInfo>) -> Unit)? = null

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
                Log.d(TAG,  "包名 = $labelRes , 名字 = $name");
            }
            listener?.let {
                it(applicationInfoList)
            }

        } catch (e: Exception) {
            e.printStackTrace();
        }
    }


    fun setListener(listener: (List<ApplicationInfo>) -> Unit) {
        this.listener = listener
    }
}