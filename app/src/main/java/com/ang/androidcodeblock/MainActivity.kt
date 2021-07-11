package com.ang.androidcodeblock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.ang.androidcodeblock.tool.AppNameIcon

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        findViewById<Button>(R.id.btn_app_info).setOnClickListener(View.OnClickListener {
            AppNameIcon.getAppName(this)


        })

    }


}