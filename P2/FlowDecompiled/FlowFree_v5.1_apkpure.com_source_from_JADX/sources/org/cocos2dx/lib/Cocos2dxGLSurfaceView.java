package org.cocos2dx.lib;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.noodlecake.lib.UIKit;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class Cocos2dxGLSurfaceView extends GLSurfaceView {
    private static final int HANDLER_CLOSE_IME_KEYBOARD = 3;
    private static final int HANDLER_OPEN_IME_KEYBOARD = 2;
    private static final String TAG = Cocos2dxGLSurfaceView.class.getCanonicalName();
    private static final boolean debug = false;
    private static Handler handler;
    /* access modifiers changed from: private */
    public static Cocos2dxGLSurfaceView mainView;
    /* access modifiers changed from: private */
    public static TextInputWraper textInputWraper;
    /* access modifiers changed from: private */
    public Cocos2dxRenderer mRenderer;
    /* access modifiers changed from: private */
    public TextView mTextField;

    public Cocos2dxGLSurfaceView(Context context) {
        super(context);
        initView();
    }

    public Cocos2dxGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public void setCocos2dxRenderer(Cocos2dxRenderer cocos2dxRenderer) {
        this.mRenderer = cocos2dxRenderer;
        setRenderer(cocos2dxRenderer);
    }

    public void initView() {
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 11) {
            setPreserveEGLContextOnPause(true);
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        egl10.eglGetConfigs(eglGetDisplay, new EGLConfig[100], 100, new int[1]);
        setEGLContextClientVersion(1);
        setEGLConfigChooser(false);
        textInputWraper = new TextInputWraper(this);
        handler = new Handler() {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 2) {
                    if (i == 3 && Cocos2dxGLSurfaceView.this.mTextField != null) {
                        Cocos2dxGLSurfaceView.this.mTextField.removeTextChangedListener(Cocos2dxGLSurfaceView.textInputWraper);
                        ((InputMethodManager) Cocos2dxGLSurfaceView.mainView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(Cocos2dxGLSurfaceView.this.mTextField.getWindowToken(), 0);
                        Log.d("GLSurfaceView", "HideSoftInput");
                    }
                } else if (Cocos2dxGLSurfaceView.this.mTextField != null && Cocos2dxGLSurfaceView.this.mTextField.requestFocus()) {
                    Cocos2dxGLSurfaceView.this.mTextField.removeTextChangedListener(Cocos2dxGLSurfaceView.textInputWraper);
                    Cocos2dxGLSurfaceView.this.mTextField.setText("");
                    String str = (String) message.obj;
                    Cocos2dxGLSurfaceView.this.mTextField.append(str);
                    Cocos2dxGLSurfaceView.textInputWraper.setOriginText(str);
                    Cocos2dxGLSurfaceView.this.mTextField.addTextChangedListener(Cocos2dxGLSurfaceView.textInputWraper);
                    ((InputMethodManager) Cocos2dxGLSurfaceView.mainView.getContext().getSystemService("input_method")).showSoftInput(Cocos2dxGLSurfaceView.this.mTextField, 0);
                    Log.d("GLSurfaceView", "showSoftInput");
                }
            }
        };
        mainView = this;
    }

    public void onPause() {
        queueEvent(new Runnable() {
            public void run() {
                UIKit.onPause();
            }
        });
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        setTextField(this.mTextField);
        queueEvent(new Runnable() {
            public void run() {
                UIKit.onResume();
            }
        });
    }

    public void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        queueEvent(new Runnable() {
            public void run() {
                UIKit.onWindowFocusChanged(z);
            }
        });
    }

    public TextView getTextField() {
        return this.mTextField;
    }

    public void setTextField(TextView textView) {
        TextInputWraper textInputWraper2;
        this.mTextField = textView;
        if (textView != null && (textInputWraper2 = textInputWraper) != null) {
            textView.setOnEditorActionListener(textInputWraper2);
            requestFocus();
        }
    }

    public static void openIMEKeyboard() {
        Message message = new Message();
        message.what = 2;
        message.obj = mainView.getContentText();
        handler.sendMessage(message);
    }

    private String getContentText() {
        return this.mRenderer.getContentText();
    }

    public static void closeIMEKeyboard() {
        Message message = new Message();
        message.what = 3;
        handler.sendMessage(message);
    }

    public void insertText(final String str) {
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mRenderer.handleInsertText(str);
            }
        });
    }

    public void deleteBackward() {
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mRenderer.handleDeleteBackward();
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        final int[] iArr = new int[pointerCount];
        final float[] fArr = new float[pointerCount];
        final float[] fArr2 = new float[pointerCount];
        final long eventTime = motionEvent.getEventTime();
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            fArr[i] = motionEvent.getX(i);
            fArr2[i] = motionEvent.getY(i);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            final int pointerId = motionEvent.getPointerId(0);
            final float f = fArr[0];
            final float f2 = fArr2[0];
            queueEvent(new Runnable() {
                public void run() {
                    Cocos2dxGLSurfaceView.this.mRenderer.handleActionDown(pointerId, f, f2, eventTime);
                }
            });
        } else if (action == 1) {
            final int pointerId2 = motionEvent.getPointerId(0);
            final float f3 = fArr[0];
            final float f4 = fArr2[0];
            queueEvent(new Runnable() {
                public void run() {
                    Cocos2dxGLSurfaceView.this.mRenderer.handleActionUp(pointerId2, f3, f4, eventTime);
                }
            });
        } else if (action == 2) {
            final long j = eventTime;
            queueEvent(new Runnable() {
                public void run() {
                    Cocos2dxGLSurfaceView.this.mRenderer.handleActionMove(iArr, fArr, fArr2, j);
                }
            });
        } else if (action == 3) {
            final long j2 = eventTime;
            queueEvent(new Runnable() {
                public void run() {
                    Cocos2dxGLSurfaceView.this.mRenderer.handleActionCancel(iArr, fArr, fArr2, j2);
                }
            });
        } else if (action == 5) {
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            final int pointerId3 = motionEvent.getPointerId(action2);
            final float x = motionEvent.getX(action2);
            final float y = motionEvent.getY(action2);
            queueEvent(new Runnable() {
                public void run() {
                    Cocos2dxGLSurfaceView.this.mRenderer.handleActionDown(pointerId3, x, y, eventTime);
                }
            });
        } else if (action == 6) {
            int action3 = (motionEvent.getAction() & 65280) >> 8;
            final int pointerId4 = motionEvent.getPointerId(action3);
            final float x2 = motionEvent.getX(action3);
            final float y2 = motionEvent.getY(action3);
            queueEvent(new Runnable() {
                public void run() {
                    Cocos2dxGLSurfaceView.this.mRenderer.handleActionUp(pointerId4, x2, y2, eventTime);
                }
            });
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mRenderer.setScreenWidthAndHeight(i, i2);
    }

    public boolean onKeyDown(final int i, KeyEvent keyEvent) {
        String str = TAG;
        Log.d(str, "Cocos2dxGLSurfaceView onKeyDown");
        if (i != 4 && i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mRenderer.handleKeyDown(i);
            }
        });
        Log.d(str, "Cocos2dxGLSurfaceView swallowed onKeyDown");
        return true;
    }

    private void dumpEvent(MotionEvent motionEvent) {
        StringBuilder sb = new StringBuilder();
        int action = motionEvent.getAction();
        int i = action & 255;
        sb.append("event ACTION_");
        sb.append(new String[]{"DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"}[i]);
        if (i == 5 || i == 6) {
            sb.append("(pid ");
            sb.append(action >> 8);
            sb.append(")");
        }
        sb.append("[");
        int i2 = 0;
        while (i2 < motionEvent.getPointerCount()) {
            sb.append("#");
            sb.append(i2);
            sb.append("(pid ");
            sb.append(motionEvent.getPointerId(i2));
            sb.append(")=");
            sb.append((int) motionEvent.getX(i2));
            sb.append(",");
            sb.append((int) motionEvent.getY(i2));
            i2++;
            if (i2 < motionEvent.getPointerCount()) {
                sb.append(";");
            }
        }
        sb.append("]");
        Log.d(TAG, sb.toString());
    }
}
