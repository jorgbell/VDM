package com.noodlecake.lib.uikit;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import java.util.ArrayList;

public class UIAccelerometer implements SensorEventListener {
    private static final String TAG = "NoodlecakeAccelerometer";
    private static ArrayList<UIAccelerometerData> arrayList = new ArrayList<>(10);
    private static float cachedX = 0.0f;
    private static float cachedY = 0.0f;
    private static float cachedZ = 0.0f;
    private static boolean isEnabled = false;
    private Sensor mAccelerometer;
    private Context mContext;
    private int mNaturalOrientation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getOrientation();
    private SensorManager mSensorManager;

    private static native void onSensorChanged(float f, float f2, float f3, long j);

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public UIAccelerometer(Context context) {
        this.mContext = context;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.mAccelerometer = sensorManager.getDefaultSensor(1);
    }

    public void enable() {
        isEnabled = true;
        cachedX = 0.0f;
        cachedY = 0.0f;
        cachedZ = 0.0f;
        this.mSensorManager.registerListener(this, this.mAccelerometer, 1);
    }

    public void disable() {
        isEnabled = false;
        this.mSensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f;
        int i;
        float f2;
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[2];
            int i2 = this.mContext.getResources().getConfiguration().orientation;
            if (i2 != 2 || (i = this.mNaturalOrientation) == 0) {
                if (i2 == 1 && this.mNaturalOrientation != 0) {
                    f = f3;
                }
                f = f4;
                cachedX = f3;
                cachedY = f;
                cachedZ = f5;
                addAccelData(f3, f, f5, sensorEvent.timestamp);
            }
            if (i == 1) {
                f2 = -f4;
            } else if (i != 2) {
                if (i == 3) {
                    f = -f3;
                }
                f = f4;
                cachedX = f3;
                cachedY = f;
                cachedZ = f5;
                addAccelData(f3, f, f5, sensorEvent.timestamp);
            } else {
                f2 = -f3;
                f3 = -f4;
            }
            float f6 = f3;
            f3 = f2;
            f = f6;
            cachedX = f3;
            cachedY = f;
            cachedZ = f5;
            addAccelData(f3, f, f5, sensorEvent.timestamp);
            f3 = f4;
            cachedX = f3;
            cachedY = f;
            cachedZ = f5;
            addAccelData(f3, f, f5, sensorEvent.timestamp);
        }
    }

    private static void addAccelData(float f, float f2, float f3, long j) {
        synchronized (arrayList) {
            UIAccelerometerData uIAccelerometerData = new UIAccelerometerData();
            uIAccelerometerData.f5602x = f;
            uIAccelerometerData.f5603y = f2;
            uIAccelerometerData.f5604z = f3;
            uIAccelerometerData.timestamp = j;
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
            arrayList.add(uIAccelerometerData);
        }
    }

    public static UIAccelerometerData popAccelData() {
        synchronized (arrayList) {
            if (arrayList.size() > 0) {
                UIAccelerometerData remove = arrayList.remove(0);
                return remove;
            }
            UIAccelerometerData uIAccelerometerData = new UIAccelerometerData();
            uIAccelerometerData.f5602x = cachedX;
            uIAccelerometerData.f5603y = cachedY;
            uIAccelerometerData.f5604z = cachedZ;
            uIAccelerometerData.timestamp = 0;
            return uIAccelerometerData;
        }
    }

    public static boolean hasAccelData() {
        synchronized (arrayList) {
            if (arrayList.size() > 0) {
                return true;
            }
            return false;
        }
    }

    public static void processAccelerometerData() {
        if (hasAccelData()) {
            while (hasAccelData()) {
                UIAccelerometerData popAccelData = popAccelData();
                onSensorChanged(popAccelData.f5602x, popAccelData.f5603y, popAccelData.f5604z, popAccelData.timestamp);
            }
        } else if (isEnabled) {
            UIAccelerometerData popAccelData2 = popAccelData();
            onSensorChanged(popAccelData2.f5602x, popAccelData2.f5603y, popAccelData2.f5604z, popAccelData2.timestamp);
        }
    }
}
