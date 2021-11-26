package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzbfn implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference<zzbdp> zzc;

    public zzbfn(zzbdp zzbdp) {
        Context context = zzbdp.getContext();
        this.zza = context;
        this.zzb = zzs.zzc().zze(context, zzbdp.zzt().zza);
        this.zzc = new WeakReference<>(zzbdp);
    }

    static /* synthetic */ void zzo(zzbfn zzbfn, String str, Map map) {
        zzbdp zzbdp = (zzbdp) zzbfn.zzc.get();
        if (zzbdp != null) {
            zzbdp.zze("onPrecacheEvent", map);
        }
    }

    public void release() {
    }

    public abstract boolean zza(String str);

    public boolean zzb(String str, String[] strArr) {
        return zza(str);
    }

    /* access modifiers changed from: protected */
    public void zzc(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzd(int i) {
    }

    /* access modifiers changed from: protected */
    public void zze(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzf(int i) {
    }

    public abstract void zzg();

    public final void zzh(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        Handler handler = zzbbd.zza;
        zzbfi zzbfi = r0;
        zzbfi zzbfi2 = new zzbfi(this, str, str2, j, j2, j3, j4, j5, z, i, i2);
        handler.post(zzbfi);
    }

    public final void zzi(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzbbd.zza.post(new zzbfj(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    /* access modifiers changed from: protected */
    public final void zzl(String str, String str2, int i) {
        zzbbd.zza.post(new zzbfk(this, str, str2, i));
    }

    public final void zzm(String str, String str2, long j) {
        zzbbd.zza.post(new zzbfl(this, str, str2, j));
    }

    public final void zzn(String str, String str2, String str3, String str4) {
        zzbbd.zza.post(new zzbfm(this, str, str2, str3, str4));
    }
}
