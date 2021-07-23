package com.ang.androidcodeblock

import android.inputmethodservice.KeyboardView
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.doOnLayout
import com.ang.androidcodeblock.tool.KeyBoardUtil

class KeyboardActivity : AppCompatActivity() {
    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyboard)
        val keyboard = findViewById<KeyboardView>(R.id.kv_keyboard)

        editText = this.findViewById(R.id.appCompatEditText);

        editText?.setOnTouchListener { v, event ->
            if (editText!!.hasFocus()) {
                //用来初始化我们的软键盘
                KeyBoardUtil(keyboard, editText!!).showKeyboard();
            }
            if (editText!!.hasFocus()) KeyBoardUtil(keyboard, editText!!).showKeyboard()
            false
        }

        //在我们点EditText的时候弹出我们的软键盘
//        editText.setOnTouchListener(new View . OnTouchListener () {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (editText.hasFocus()) {
//                    //用来初始化我们的软键盘
//                    new KeyBoardUtil (keyboard, editText).showKeyboard();
//                }
//                return false;
//            }
//        });
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    }
}