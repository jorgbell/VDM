package com.flurry.sdk;

import android.location.Location;
import android.os.Build;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.iv */
public final class C1872iv extends C1891jm {

    /* renamed from: a */
    public final int f4607a;

    /* renamed from: b */
    public boolean f4608b;

    /* renamed from: c */
    public boolean f4609c;

    /* renamed from: d */
    public final Location f4610d;

    public C1872iv(int i, boolean z, boolean z2, Location location) {
        this.f4607a = i;
        this.f4608b = z;
        this.f4609c = z2;
        this.f4610d = location;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        Location location;
        double d;
        boolean z;
        double d2;
        JSONObject a = super.mo11543a();
        a.put("fl.report.location.enabled", this.f4608b);
        if (this.f4608b) {
            a.put("fl.location.permission.status", this.f4609c);
            if (this.f4609c && (location = this.f4610d) != null) {
                int i = Build.VERSION.SDK_INT;
                boolean z2 = false;
                double d3 = 0.0d;
                if (i >= 26) {
                    d3 = (double) location.getVerticalAccuracyMeters();
                    double bearingAccuracyDegrees = (double) this.f4610d.getBearingAccuracyDegrees();
                    double speedAccuracyMetersPerSecond = (double) this.f4610d.getSpeedAccuracyMetersPerSecond();
                    boolean hasBearingAccuracy = this.f4610d.hasBearingAccuracy();
                    z = this.f4610d.hasSpeedAccuracy();
                    d = speedAccuracyMetersPerSecond;
                    d2 = bearingAccuracyDegrees;
                    z2 = hasBearingAccuracy;
                } else {
                    d2 = 0.0d;
                    d = 0.0d;
                    z = false;
                }
                a.put("fl.precision.value", this.f4607a);
                a.put("fl.latitude.value", this.f4610d.getLatitude());
                a.put("fl.longitude.value", this.f4610d.getLongitude());
                a.put("fl.horizontal.accuracy.value", (double) this.f4610d.getAccuracy());
                a.put("fl.time.epoch.value", this.f4610d.getTime());
                if (i >= 17) {
                    a.put("fl.time.uptime.value", TimeUnit.NANOSECONDS.toMillis(this.f4610d.getElapsedRealtimeNanos()));
                }
                a.put("fl.altitude.value", this.f4610d.getAltitude());
                a.put("fl.vertical.accuracy.value", d3);
                a.put("fl.bearing.value", (double) this.f4610d.getBearing());
                a.put("fl.speed.value", (double) this.f4610d.getSpeed());
                a.put("fl.bearing.accuracy.available", z2);
                a.put("fl.speed.accuracy.available", z);
                a.put("fl.bearing.accuracy.degrees", d2);
                a.put("fl.speed.accuracy.meters.per.sec", d);
            }
        }
        return a;
    }
}
