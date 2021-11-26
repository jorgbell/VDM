package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdzb implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzeaf zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue<zzdc> zzd = new LinkedBlockingQueue<>();
    private final HandlerThread zze;

    public zzdzb(Context context, String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzeaf zzeaf = new zzeaf(context, handlerThread.getLooper(), this, this, 9200000);
        this.zza = zzeaf;
        zzeaf.checkAvailabilityAndConnect();
    }

    static zzdc zzc() {
        zzcn zzj = zzdc.zzj();
        zzj.zzl(32768);
        return (zzdc) zzj.zzah();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        zzb();
        r3.zze.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3.zzd.put(zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzeak r4 = r3.zzd()
            if (r4 == 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzeag r0 = new com.google.android.gms.internal.ads.zzeag     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = r3.zzb     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r3.zzc     // Catch:{ all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzeai r4 = r4.zze(r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdc r4 = r4.zza()     // Catch:{ all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzdc> r0 = r3.zzd     // Catch:{ all -> 0x0025 }
            r0.put(r4)     // Catch:{ all -> 0x0025 }
        L_0x001c:
            r3.zzb()
            android.os.HandlerThread r4 = r3.zze
            r4.quit()
            return
        L_0x0025:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzdc> r4 = r3.zzd     // Catch:{ InterruptedException -> 0x001c, all -> 0x002f }
            com.google.android.gms.internal.ads.zzdc r0 = zzc()     // Catch:{ InterruptedException -> 0x001c, all -> 0x002f }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x001c, all -> 0x002f }
            goto L_0x001c
        L_0x002f:
            r4 = move-exception
            r3.zzb()
            android.os.HandlerThread r0 = r3.zze
            r0.quit()
            throw r4
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdzb.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzd.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.zzd.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    public final zzdc zza(int i) {
        zzdc zzdc;
        try {
            zzdc = this.zzd.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzdc = null;
        }
        return zzdc == null ? zzc() : zzdc;
    }

    public final void zzb() {
        zzeaf zzeaf = this.zza;
        if (zzeaf == null) {
            return;
        }
        if (zzeaf.isConnected() || this.zza.isConnecting()) {
            this.zza.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    public final zzeak zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
