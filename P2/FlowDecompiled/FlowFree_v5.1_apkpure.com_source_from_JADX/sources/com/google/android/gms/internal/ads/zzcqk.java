package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcqk implements SensorEventListener {
    private final Context zza;
    @Nullable
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzcqj zzf;
    @GuardedBy("this")
    private boolean zzg;

    zzcqk(Context context) {
        this.zza = context;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfT)).booleanValue()) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0] / 9.80665f;
            float f2 = fArr[1] / 9.80665f;
            float f3 = fArr[2] / 9.80665f;
            if (((float) Math.sqrt((double) ((f * f) + (f2 * f2) + (f3 * f3)))) >= ((Float) zzaaa.zzc().zzb(zzaeq.zzfU)).floatValue()) {
                long currentTimeMillis = zzs.zzj().currentTimeMillis();
                if (this.zzd + ((long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzfV)).intValue()) <= currentTimeMillis) {
                    if (this.zzd + ((long) ((Integer) zzaaa.zzc().zzb(zzaeq.zzfW)).intValue()) < currentTimeMillis) {
                        this.zze = 0;
                    }
                    zze.zza("Shake detected.");
                    this.zzd = currentTimeMillis;
                    int i = this.zze + 1;
                    this.zze = i;
                    zzcqj zzcqj = this.zzf;
                    if (zzcqj != null) {
                        if (i == ((Integer) zzaaa.zzc().zzb(zzaeq.zzfX)).intValue()) {
                            zzcpz zzcpz = (zzcpz) zzcqj;
                            zzcpz.zzh(new zzcpx(zzcpz));
                        }
                    }
                }
            }
        }
    }

    public final void zza(zzcqj zzcqj) {
        this.zzf = zzcqj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzfT     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzaeo r1 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x006b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r6)     // Catch:{ all -> 0x006b }
            return
        L_0x0015:
            android.hardware.SensorManager r0 = r6.zzb     // Catch:{ all -> 0x006b }
            r1 = 1
            if (r0 != 0) goto L_0x0036
            android.content.Context r0 = r6.zza     // Catch:{ all -> 0x006b }
            java.lang.String r2 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ all -> 0x006b }
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch:{ all -> 0x006b }
            r6.zzb = r0     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x002f
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)     // Catch:{ all -> 0x006b }
            r6.zzc = r0     // Catch:{ all -> 0x006b }
            goto L_0x0036
        L_0x002f:
            java.lang.String r0 = "Shake detection failed to initialize. Failed to obtain accelerometer."
            com.google.android.gms.internal.ads.zzbbk.zzi(r0)     // Catch:{ all -> 0x006b }
            monitor-exit(r6)     // Catch:{ all -> 0x006b }
            return
        L_0x0036:
            boolean r0 = r6.zzg     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0069
            android.hardware.SensorManager r0 = r6.zzb     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0069
            android.hardware.Sensor r2 = r6.zzc     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x0069
            r3 = 2
            r0.registerListener(r6, r2, r3)     // Catch:{ all -> 0x006b }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzs.zzj()     // Catch:{ all -> 0x006b }
            long r2 = r0.currentTimeMillis()     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzaei<java.lang.Integer> r0 = com.google.android.gms.internal.ads.zzaeq.zzfV     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.ads.zzaeo r4 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r4.zzb(r0)     // Catch:{ all -> 0x006b }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x006b }
            int r0 = r0.intValue()     // Catch:{ all -> 0x006b }
            long r4 = (long) r0     // Catch:{ all -> 0x006b }
            long r2 = r2 - r4
            r6.zzd = r2     // Catch:{ all -> 0x006b }
            r6.zzg = r1     // Catch:{ all -> 0x006b }
            java.lang.String r0 = "Listening for shake gestures."
            com.google.android.gms.ads.internal.util.zze.zza(r0)     // Catch:{ all -> 0x006b }
        L_0x0069:
            monitor-exit(r6)     // Catch:{ all -> 0x006b }
            return
        L_0x006b:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqk.zzb():void");
    }

    public final void zzc() {
        synchronized (this) {
            if (this.zzg) {
                SensorManager sensorManager = this.zzb;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.zzc);
                    zze.zza("Stopped listening for shake gestures.");
                }
                this.zzg = false;
            }
        }
    }
}
