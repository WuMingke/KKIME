package com.example.administrator.kkime;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodSubtype;

/**
 * Created by Administrator on 2019/1/10.
 */

public class KKIMEService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    //一个用于呈现虚拟键盘的 view，同时处理着每一个键盘所对应的点击、触摸等事件
    private KeyboardView keyboardView;
    //Keyboard 的样式是以 XML 文件的形式存在的，由多个 Row 和 Key 组成，我们可以直接在 XML 定义键盘的行、键、以及键大小，
    private Keyboard keyboard;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public View onCreateInputView() {
        //定义键盘
        // keyboard被创建后，将调用onCreateInputView函数
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard, null);// 此处使用了keyboard.xml
        keyboard = new Keyboard(this, R.xml.qwerty);// 此处使用了qwerty.xml
        keyboardView.setKeyboard(keyboard);
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
        InputConnection connection = getCurrentInputConnection();
        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                connection.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_DONE:
                connection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                char code = (char) primaryCode;
                connection.commitText(String.valueOf(code), 1);
        }
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
