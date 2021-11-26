package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.util.zzr;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdrg {
    public final zzady zza;
    public final zzamv zzb;
    public final zzdda zzc;
    public final zzys zzd;
    public final zzyx zze;
    public final String zzf;
    public final ArrayList<String> zzg;
    public final ArrayList<String> zzh;
    public final zzagy zzi;
    public final zzzd zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final zzabb zzn;
    public final zzdqw zzo;
    public final boolean zzp;
    public final zzabf zzq;

    /* synthetic */ zzdrg(zzdrf zzdrf, zzdre zzdre) {
        zzady zzady;
        zzagy zzagy;
        this.zze = zzdrf.zzb;
        this.zzf = zzdrf.zzc;
        this.zzq = zzdrf.zzr;
        int i = zzdrf.zza.zza;
        long j = zzdrf.zza.zzb;
        Bundle bundle = zzdrf.zza.zzc;
        int i2 = zzdrf.zza.zzd;
        List<String> list = zzdrf.zza.zze;
        boolean z = zzdrf.zza.zzf;
        int i3 = zzdrf.zza.zzg;
        boolean z2 = true;
        if (!zzdrf.zza.zzh && !zzdrf.zze) {
            z2 = false;
        }
        this.zzd = new zzys(i, j, bundle, i2, list, z, i3, z2, zzdrf.zza.zzi, zzdrf.zza.zzj, zzdrf.zza.zzk, zzdrf.zza.zzl, zzdrf.zza.zzm, zzdrf.zza.zzn, zzdrf.zza.zzo, zzdrf.zza.zzp, zzdrf.zza.zzq, zzdrf.zza.zzr, zzdrf.zza.zzs, zzdrf.zza.zzt, zzdrf.zza.zzu, zzdrf.zza.zzv, zzr.zza(zzdrf.zza.zzw));
        if (zzdrf.zzd != null) {
            zzady = zzdrf.zzd;
        } else {
            zzady = zzdrf.zzh != null ? zzdrf.zzh.zzf : null;
        }
        this.zza = zzady;
        this.zzg = zzdrf.zzf;
        this.zzh = zzdrf.zzg;
        if (zzdrf.zzf == null) {
            zzagy = null;
        } else {
            zzagy = zzdrf.zzh == null ? new zzagy(new NativeAdOptions.Builder().build()) : zzdrf.zzh;
        }
        this.zzi = zzagy;
        this.zzj = zzdrf.zzi;
        this.zzk = zzdrf.zzm;
        this.zzl = zzdrf.zzj;
        this.zzm = zzdrf.zzk;
        this.zzn = zzdrf.zzl;
        this.zzb = zzdrf.zzn;
        this.zzo = new zzdqw(zzdrf.zzo, (zzdqu) null);
        this.zzp = zzdrf.zzp;
        this.zzc = zzdrf.zzq;
    }

    public final zzaix zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzc();
        }
        return this.zzl.zza();
    }
}
