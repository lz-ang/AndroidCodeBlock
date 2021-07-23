package com.ang.androidcodeblock.tool

import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.text.Editable
import android.text.InputType
import android.view.View
import android.widget.EditText
import com.ang.androidcodeblock.R
import java.lang.Character.*
import java.util.*

class KeyBoardUtil {

    private var keyboardView: KeyboardView? = null
    private var editText: EditText? = null;
    private var k1: Keyboard? = null;// 自定义键盘


    constructor(keyboard: KeyboardView?, editText: EditText) {
        //setInputType为InputType.TYPE_NULL   不然会弹出系统键盘
        this.keyboardView = keyboard
        this.editText = editText

        this.editText?.inputType = InputType.TYPE_NULL;
        k1 = Keyboard(editText.context, R.xml.key);

        this.keyboardView!!.setOnKeyboardActionListener(this.listener);
        this.keyboardView!!.keyboard = k1;
        this.keyboardView!!.isEnabled = true;
        this.keyboardView!!.isPreviewEnabled = false;
    }


    private val listener: KeyboardView.OnKeyboardActionListener =
        object : KeyboardView.OnKeyboardActionListener {
            override fun onPress(primaryCode: Int) {

            }

            override fun onRelease(primaryCode: Int) {

            }

            override fun onKey(primaryCode: Int, keyCodes: IntArray?) {

                val editable: Editable = this@KeyBoardUtil.editText?.editableText as Editable;
                val start: Int = this@KeyBoardUtil.editText!!.selectionStart
                when (primaryCode) {
                    Keyboard.KEYCODE_DELETE ->
                        if (editable != null && editable.isNotEmpty()) {
                            if (start > 0) {
                                editable.delete(start - 1, start);
                            }
                        }
                    Keyboard.KEYCODE_DONE -> {
                        keyboardView?.visibility = View.GONE;
                    }
                    else ->
                        editable.insert(start, (primaryCode.toString().toInt().toChar().toString()))
                }
            }

            override fun onText(text: CharSequence?) {

            }

            override fun swipeLeft() {

            }

            override fun swipeRight() {

            }

            override fun swipeDown() {

            }

            override fun swipeUp() {

            }

        }

    // Activity中获取焦点时调用，显示出键盘
    fun showKeyboard() {
        val visibility: Int? = keyboardView?.visibility;
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            keyboardView?.visibility = View.VISIBLE;
        }
    }

    // 隐藏键盘
    fun hideKeyboard() {
        val visibility: Int? = keyboardView?.visibility;
        if (visibility == View.VISIBLE || visibility == View.INVISIBLE) {
            keyboardView?.visibility = View.GONE;
        }
    }
}