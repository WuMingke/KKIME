package com.example.administrator.kkime;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodSubtype;

/**
 * Created by Administrator on 2019/1/10.
 */

public class KKIMEService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public View onCreateInputView() {
        //定义键盘
        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public View onCreateCandidatesView() {//候选词的展示view
        return super.onCreateCandidatesView();
    }

    @Override
    public void onStartInputView(EditorInfo info, boolean restarting) {//输入控件接收到焦点
        super.onStartInputView(info, restarting);
    }

    /*输入框得到当前输入法subtype*/


    /*开始输入*/

    @Override
    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        super.onCurrentInputMethodSubtypeChanged(newSubtype);
    }

    /*检测到当前输入法的subtype被改变了*/

    @Override
    public void onFinishInput() {
        super.onFinishInput();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    //setOnKeyboardActionListener
    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {

    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }


}
