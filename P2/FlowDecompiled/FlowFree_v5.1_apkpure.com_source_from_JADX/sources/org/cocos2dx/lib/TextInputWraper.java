package org.cocos2dx.lib;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/* compiled from: Cocos2dxGLSurfaceView */
class TextInputWraper implements TextWatcher, TextView.OnEditorActionListener {
    private static final Boolean debug = Boolean.FALSE;
    private Cocos2dxGLSurfaceView mMainView;
    private String mOriginText;
    private String mText;

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    private void LogD(String str) {
        if (debug.booleanValue()) {
            Log.d("TextInputFilter", str);
        }
    }

    private Boolean isFullScreenEdit() {
        return Boolean.valueOf(((InputMethodManager) this.mMainView.getTextField().getContext().getSystemService("input_method")).isFullscreenMode());
    }

    public TextInputWraper(Cocos2dxGLSurfaceView cocos2dxGLSurfaceView) {
        this.mMainView = cocos2dxGLSurfaceView;
    }

    public void setOriginText(String str) {
        this.mOriginText = str;
    }

    public void afterTextChanged(Editable editable) {
        if (!isFullScreenEdit().booleanValue()) {
            LogD("afterTextChanged: " + editable);
            int length = editable.length() - this.mText.length();
            if (length > 0) {
                String charSequence = editable.subSequence(this.mText.length(), editable.length()).toString();
                this.mMainView.insertText(charSequence);
                LogD("insertText(" + charSequence + ")");
            } else {
                while (length < 0) {
                    this.mMainView.deleteBackward();
                    LogD("deleteBackward");
                    length++;
                }
            }
            this.mText = editable.toString();
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        LogD("beforeTextChanged(" + charSequence + ")start: " + i + ",count: " + i2 + ",after: " + i3);
        this.mText = charSequence.toString();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (this.mMainView.getTextField() != textView || !isFullScreenEdit().booleanValue()) {
            return false;
        }
        for (int length = this.mOriginText.length(); length > 0; length--) {
            this.mMainView.deleteBackward();
            LogD("deleteBackward");
        }
        String charSequence = textView.getText().toString();
        if (charSequence.compareTo("") == 0) {
            charSequence = "\n";
        }
        if (10 != charSequence.charAt(charSequence.length() - 1)) {
            charSequence = charSequence + 10;
        }
        this.mMainView.insertText(charSequence);
        LogD("insertText(" + charSequence + ")");
        return false;
    }
}
