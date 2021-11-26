package com.noodlecake.lib.uikit;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class UIDevice {
    public static final int SCREEN_ORIENTATION_LANDSCAPE_LEFT = 1;
    public static final int SCREEN_ORIENTATION_LANDSCAPE_RIGHT = 3;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 0;
    public static final int SCREEN_ORIENTATION_PORTRAIT_UPSIDE_DOWN = 2;
    private static final String TAG = "UIDevice";
    private static UIDevice sharedDevice;
    private Activity mActivity;
    private int mCurrentOrientation;
    private Display mDisplay;
    private int mNaturalRotation;
    private boolean mNaturallyPortrait;

    private static native void onOrientationChangedNative(int i);

    public UIDevice(Activity activity) {
        this.mActivity = activity;
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        this.mDisplay = defaultDisplay;
        this.mNaturalRotation = defaultDisplay.getRotation();
        Log.d(TAG, " NATURAL ROTATION " + (this.mNaturalRotation * 90));
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            this.mDisplay.getSize(point);
        } else {
            point.x = this.mDisplay.getWidth();
            point.y = this.mDisplay.getHeight();
        }
        this.mNaturallyPortrait = point.y > point.x;
        int fullOrientation = getFullOrientation(0);
        this.mCurrentOrientation = fullOrientation;
        onOrientationChangedNative(fullOrientation);
        sharedDevice = this;
    }

    public int getFullOrientation(int i) {
        if (this.mNaturallyPortrait) {
            if (i == 0) {
                Log.d(TAG, " SCREEN_ORIENTATION_PORTRAIT");
                return 0;
            } else if (i == 1) {
                Log.d(TAG, " SCREEN_ORIENTATION_LANDSCAPE_LEFT");
                return 1;
            } else if (i == 2) {
                Log.d(TAG, " SCREEN_ORIENTATION_PORTRAIT_UPSIDE_DOWN");
                return 2;
            } else if (i != 3) {
                return 0;
            } else {
                Log.d(TAG, " SCREEN_ORIENTATION_LANDSCAPE_RIGHT");
                return 3;
            }
        } else if (i == 0) {
            Log.d(TAG, " SCREEN_ORIENTATION_LANDSCAPE_LEFT");
            return 1;
        } else if (i == 1) {
            Log.d(TAG, " SCREEN_ORIENTATION_PORTRAIT");
            return 0;
        } else if (i == 2) {
            Log.d(TAG, " SCREEN_ORIENTATION_LANDSCAPE_RIGHT");
            return 3;
        } else if (i != 3) {
            return 1;
        } else {
            Log.d(TAG, " SCREEN_ORIENTATION_PORTRAIT_UPSIDE_DOWN");
            return 2;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        int abs = Math.abs(this.mDisplay.getRotation() - this.mNaturalRotation);
        Log.d(TAG, " rotation " + (abs * 90) + " naturally portrait " + this.mNaturallyPortrait);
        int fullOrientation = getFullOrientation(abs);
        this.mCurrentOrientation = fullOrientation;
        onOrientationChangedNative(fullOrientation);
    }

    public static void restrictOrientationsPortraitOnly() {
        sharedDevice.restrictOrientationsPortraitOnlyReal();
    }

    private void restrictOrientationsPortraitOnlyReal() {
        Log.d(TAG, "Setting requested orientation SCREEN_ORIENTATION_SENSOR_PORTRAIT");
        this.mActivity.setRequestedOrientation(7);
    }

    public static void restrictOrientationsLandscapeOnly() {
        sharedDevice.restrictOrientationsLandscapeOnlyReal();
    }

    private void restrictOrientationsLandscapeOnlyReal() {
        Log.d(TAG, "Setting requested orientation SCREEN_ORIENTATION_SENSOR_LANDSCAPE");
        this.mActivity.setRequestedOrientation(6);
    }

    public static void restrictOrientationsAnyOrientation() {
        sharedDevice.restrictOrientationsAnyOrientationReal();
    }

    private void restrictOrientationsAnyOrientationReal() {
        Log.d(TAG, "Setting requested orientation SCREEN_ORIENTATION_SENSOR");
        this.mActivity.setRequestedOrientation(4);
    }
}
