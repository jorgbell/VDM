package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0965b;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.utils.n */
public class C1154n implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private final int f2474a;

    /* renamed from: b */
    private final float f2475b;

    /* renamed from: c */
    private final SensorManager f2476c;

    /* renamed from: d */
    private final Sensor f2477d;

    /* renamed from: e */
    private final Sensor f2478e;

    /* renamed from: f */
    private final C1062k f2479f;

    /* renamed from: g */
    private float[] f2480g;

    /* renamed from: h */
    private float f2481h;

    public C1154n(C1062k kVar) {
        this.f2479f = kVar;
        SensorManager sensorManager = (SensorManager) kVar.mo9334J().getSystemService("sensor");
        this.f2476c = sensorManager;
        this.f2477d = sensorManager.getDefaultSensor(9);
        this.f2478e = sensorManager.getDefaultSensor(4);
        this.f2474a = ((Integer) kVar.mo9350a(C0965b.f1746dN)).intValue();
        this.f2475b = ((Float) kVar.mo9350a(C0965b.f1745dM)).floatValue();
        kVar.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        kVar.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public void mo9654a() {
        this.f2476c.unregisterListener(this);
        if (((Boolean) this.f2479f.mo9333I().mo9121a(C0965b.f1743dK)).booleanValue()) {
            this.f2476c.registerListener(this, this.f2477d, (int) TimeUnit.MILLISECONDS.toMicros((long) this.f2474a));
        }
        if (((Boolean) this.f2479f.mo9333I().mo9121a(C0965b.f1744dL)).booleanValue()) {
            this.f2476c.registerListener(this, this.f2478e, (int) TimeUnit.MILLISECONDS.toMicros((long) this.f2474a));
        }
    }

    /* renamed from: b */
    public float mo9655b() {
        return this.f2481h;
    }

    /* renamed from: c */
    public float mo9656c() {
        float[] fArr = this.f2480g;
        if (fArr == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos((double) (fArr[2] / 9.81f)));
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2476c.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            mo9654a();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.f2480g = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f = this.f2481h * this.f2475b;
            this.f2481h = f;
            this.f2481h = f + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }
}
