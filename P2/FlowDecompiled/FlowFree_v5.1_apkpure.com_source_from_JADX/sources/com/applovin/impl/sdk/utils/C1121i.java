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
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.utils.i */
public class C1121i implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private final C1062k f2399a;

    /* renamed from: b */
    private final SensorManager f2400b;

    /* renamed from: c */
    private final Sensor f2401c;

    /* renamed from: d */
    private final C1122a f2402d;

    /* renamed from: e */
    private float f2403e;

    /* renamed from: com.applovin.impl.sdk.utils.i$a */
    public interface C1122a {
        /* renamed from: b */
        void mo9418b();

        /* renamed from: c */
        void mo9419c();
    }

    public C1121i(C1062k kVar, C1122a aVar) {
        this.f2399a = kVar;
        SensorManager sensorManager = (SensorManager) kVar.mo9334J().getSystemService("sensor");
        this.f2400b = sensorManager;
        this.f2401c = sensorManager.getDefaultSensor(1);
        this.f2402d = aVar;
    }

    /* renamed from: a */
    public void mo9612a() {
        this.f2400b.unregisterListener(this);
        this.f2400b.registerListener(this, this.f2401c, (int) TimeUnit.MILLISECONDS.toMicros(50));
        this.f2399a.mo9375aj().unregisterReceiver(this);
        this.f2399a.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.f2399a.mo9375aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: b */
    public void mo9613b() {
        this.f2399a.mo9375aj().unregisterReceiver(this);
        this.f2400b.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2400b.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            mo9612a();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float max = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f = this.f2403e;
            float f2 = (f * 0.5f) + (max * 0.5f);
            this.f2403e = f2;
            if (f < 0.8f && f2 > 0.8f) {
                this.f2402d.mo9419c();
            } else if (f > -0.8f && f2 < -0.8f) {
                this.f2402d.mo9418b();
            }
        }
    }
}
