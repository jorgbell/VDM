package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdzd implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzeaf zza;
    private final String zzb;
    private final String zzc;
    private final zzhp zzd;
    private final LinkedBlockingQueue<zzear> zze;
    private final HandlerThread zzf;
    private final zzdyu zzg;
    private final long zzh = System.currentTimeMillis();

    public zzdzd(Context context, int i, zzhp zzhp, String str, String str2, String str3, zzdyu zzdyu) {
        this.zzb = str;
        this.zzd = zzhp;
        this.zzc = str2;
        this.zzg = zzdyu;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzf = handlerThread;
        handlerThread.start();
        zzeaf zzeaf = new zzeaf(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzeaf;
        this.zze = new LinkedBlockingQueue<>();
        zzeaf.checkAvailabilityAndConnect();
    }

    static zzear zzc() {
        return new zzear((byte[]) null, 1);
    }

    private final void zze(int i, long j, Exception exc) {
        zzdyu zzdyu = this.zzg;
        if (zzdyu != null) {
            zzdyu.zzd(i, System.currentTimeMillis() - j, exc);
        }
    }

    public final void onConnected(Bundle bundle) {
        zzeak zzd2 = zzd();
        if (zzd2 != null) {
            try {
                zzear zzg2 = zzd2.zzg(new zzeap(1, this.zzd, this.zzb, this.zzc));
                zze(5011, this.zzh, (Exception) null);
                this.zze.put(zzg2);
            } catch (Throwable th) {
                zzb();
                this.zzf.quit();
                throw th;
            }
            zzb();
            this.zzf.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(4012, this.zzh, (Exception) null);
            this.zze.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            zze(4011, this.zzh, (Exception) null);
            this.zze.put(zzc());
        } catch (InterruptedException unused) {
        }
    }

    public final zzear zza(int i) {
        zzear zzear;
        try {
            zzear = this.zze.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zze(AdError.INTERSTITIAL_AD_TIMEOUT, this.zzh, e);
            zzear = null;
        }
        zze(3004, this.zzh, (Exception) null);
        if (zzear != null) {
            if (zzear.zzc == 7) {
                zzdyu.zza(zzca.DISABLED);
            } else {
                zzdyu.zza(zzca.ENABLED);
            }
        }
        return zzear == null ? zzc() : zzear;
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
