package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxf {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzdxf zza = new zzdxf();
    private Context zzb;
    private BroadcastReceiver zzc;
    private boolean zzd;
    private boolean zze;
    private zzdxk zzf;

    private zzdxf() {
    }

    public static zzdxf zza() {
        return zza;
    }

    static /* synthetic */ void zzf(zzdxf zzdxf, boolean z) {
        if (zzdxf.zze != z) {
            zzdxf.zze = z;
            if (zzdxf.zzd) {
                zzdxf.zzh();
                if (zzdxf.zzf == null) {
                    return;
                }
                if (zzdxf.zze()) {
                    zzdyg.zzb().zzc();
                } else {
                    zzdyg.zzb().zze();
                }
            }
        }
    }

    private final void zzh() {
        boolean z = this.zze;
        for (zzdws zzh : zzdxd.zza().zze()) {
            zzdxq zzh2 = zzh.zzh();
            if (zzh2.zze()) {
                zzdxj.zza().zzg(zzh2.zzd(), "setState", true != z ? "foregrounded" : "backgrounded");
            }
        }
    }

    public final void zzb(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public final void zzc() {
        this.zzc = new zzdxe(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zzb.registerReceiver(this.zzc, intentFilter);
        this.zzd = true;
        zzh();
    }

    public final void zzd() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.zzb;
        if (!(context == null || (broadcastReceiver = this.zzc) == null)) {
            context.unregisterReceiver(broadcastReceiver);
            this.zzc = null;
        }
        this.zzd = false;
        this.zze = false;
        this.zzf = null;
    }

    public final boolean zze() {
        return !this.zze;
    }

    public final void zzg(zzdxk zzdxk) {
        this.zzf = zzdxk;
    }
}
