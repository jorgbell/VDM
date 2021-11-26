package org.cocos2dx.lib;

import android.opengl.GLSurfaceView;
import android.util.Log;
import com.noodlecake.lib.uikit.UIAccelerometer;
import com.noodlecake.lib.uikit.UIApplication;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Cocos2dxRenderer implements GLSurfaceView.Renderer {
    private static final long NANOSECONDSPERMINISECOND = 1000000;
    private static final long NANOSECONDSPERSECOND = 1000000000;
    private static long animationInterval = 16666666;
    private static boolean nativeInitialized = false;
    private long last;
    private int screenHeight;
    private int screenWidth;

    private static native void nativeDeleteBackward();

    private static native String nativeGetContentText();

    private static native void nativeInit(int i, int i2);

    private static native void nativeInsertText(String str);

    private static native boolean nativeKeyDown(int i);

    private static native void nativeRender();

    private static native void nativeSurfaceChanged(int i, int i2);

    private static native void nativeTouchesBegin(int i, float f, float f2, long j);

    private static native void nativeTouchesCancel(int[] iArr, float[] fArr, float[] fArr2, long j);

    private static native void nativeTouchesEnd(int i, float f, float f2, long j);

    private static native void nativeTouchesMove(int[] iArr, float[] fArr, float[] fArr2, long j);

    public int screenWidth() {
        return this.screenWidth;
    }

    public int screenHeight() {
        return this.screenHeight;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.v("noodle", "onSurfaceCreated");
        nativeInitialized = true;
        nativeInit(this.screenWidth, this.screenHeight);
        this.last = System.nanoTime();
    }

    public void setScreenWidthAndHeight(int i, int i2) {
        this.screenWidth = i;
        this.screenHeight = i2;
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.v("noodle", "onSurfaceChanged: " + i + ":" + i2);
        if (!nativeInitialized) {
            nativeInitialized = true;
            nativeInit(this.screenWidth, this.screenHeight);
            this.last = System.nanoTime();
        }
        nativeSurfaceChanged(i, i2);
    }

    public void onDrawFrame(GL10 gl10) {
        UIApplication.processActivationLifecycleEvents();
        UIAccelerometer.processAccelerometerData();
        long nanoTime = System.nanoTime();
        long j = nanoTime - this.last;
        nativeRender();
        long j2 = animationInterval;
        if (j < j2) {
            try {
                Thread.sleep(((j2 - j) * 2) / NANOSECONDSPERMINISECOND);
            } catch (Exception unused) {
            }
        }
        this.last = nanoTime;
    }

    public void handleActionDown(int i, float f, float f2, long j) {
        nativeTouchesBegin(i, f, f2, j);
    }

    public void handleActionUp(int i, float f, float f2, long j) {
        nativeTouchesEnd(i, f, f2, j);
    }

    public void handleActionCancel(int[] iArr, float[] fArr, float[] fArr2, long j) {
        nativeTouchesCancel(iArr, fArr, fArr2, j);
    }

    public void handleActionMove(int[] iArr, float[] fArr, float[] fArr2, long j) {
        nativeTouchesMove(iArr, fArr, fArr2, j);
    }

    public void handleKeyDown(int i) {
        nativeKeyDown(i);
    }

    public static void setAnimationInterval(double d) {
        animationInterval = (long) (d * 1.0E9d);
    }

    public void handleInsertText(String str) {
        nativeInsertText(str);
    }

    public void handleDeleteBackward() {
        nativeDeleteBackward();
    }

    public String getContentText() {
        return nativeGetContentText();
    }
}
