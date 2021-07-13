package com.ang.androidcodeblock

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.ang.androidcodeblock.tool.AppNameIcon
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName //获取Java中的Class,class后面要加.java

    /*
    * 类似Java定义初始化流程写法写法
    * */
//    private var btn_app_info: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置屏幕常亮，有三种实现方式，这里只是其中一种;也就是阻止息屏！
        window.setFlags(
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
        )
        setContentView(R.layout.activity_main)
        /*
        * 类似Java定义初始化流程写法写法
        * */
//        init()
        /*
        * 通过kotlin-android-extensions插件不用再写findViewById
        * */
//        init2()
        /*
         * 懒加载方式初始化
         * */
//        init3()

        init4()
    }

    /*
        * 类似Java定义初始化流程写法写法
        * */
//    private fun init() {
//        btn_app_info = findViewById(R.id.btn_app_info)
//        btn_app_info?.setOnClickListener(View.OnClickListener {
//            Log.d(TAG,"it = $it")
//            AppNameIcon.getAppName(this)
//        })
//    }

    /*
    * 通过kotlin-android-extensions插件不用再写findViewById
    * */
//    private fun init2() {
//        btn_app_info.setOnClickListener {
//            Log.d(TAG, "it = $it")
//            AppNameIcon.getAppName(this)
//        }
//    }

    /*
    * 懒加载方式初始化
    * */
//    private val btn_app_info: Button by lazy(findViewById(R.id.btn_app_info))
//    val btn_app_info: Button by lazy { findViewById(R.id.btn_app_info) }
//    private fun init3() {
//        btn_app_info.setOnClickListener {
//            Log.d(TAG, "it = $it")
//            AppNameIcon.getAppName(this)
//        }
//    }

    /******************* get属性访问器实现 start *********************/
    //get属性访问器实现
    val btn_app_info:Button
        @SuppressLint("WrongViewCast")
        get() {
            return findViewById(R.id.btn_app_info)
        }

    private fun init4() {
        btn_app_info.setOnClickListener {
            AppNameIcon.getAppName(this)
        }
        testListener()
    }
    /******************* get属性访问器实现 end *********************/

    //Kotlin版接口回调
    private fun testListener() {
        AppNameIcon.setListener {
            Log.e(TAG, it.toString())
        }
    }

}