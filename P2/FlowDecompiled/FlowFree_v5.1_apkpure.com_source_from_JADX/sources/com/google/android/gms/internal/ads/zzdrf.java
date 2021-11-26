package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdrf {
    /* access modifiers changed from: private */
    public zzys zza;
    /* access modifiers changed from: private */
    public zzyx zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public zzady zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public ArrayList<String> zzf;
    /* access modifiers changed from: private */
    public ArrayList<String> zzg;
    /* access modifiers changed from: private */
    public zzagy zzh;
    /* access modifiers changed from: private */
    public zzzd zzi;
    /* access modifiers changed from: private */
    public AdManagerAdViewOptions zzj;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzk;
    /* access modifiers changed from: private */
    public zzabb zzl;
    /* access modifiers changed from: private */
    public int zzm = 1;
    /* access modifiers changed from: private */
    public zzamv zzn;
    /* access modifiers changed from: private */
    public final zzdqv zzo = new zzdqv();
    /* access modifiers changed from: private */
    public boolean zzp = false;
    /* access modifiers changed from: private */
    public zzdda zzq;
    /* access modifiers changed from: private */
    public zzabf zzr;

    public final zzdrf zzN(zzabf zzabf) {
        this.zzr = zzabf;
        return this;
    }

    public final zzdrf zza(zzys zzys) {
        this.zza = zzys;
        return this;
    }

    public final zzys zzb() {
        return this.zza;
    }

    public final zzdrf zzc(zzyx zzyx) {
        this.zzb = zzyx;
        return this;
    }

    public final zzdrf zzd(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzyx zze() {
        return this.zzb;
    }

    public final zzdrf zzf(String str) {
        this.zzc = str;
        return this;
    }

    public final String zzg() {
        return this.zzc;
    }

    public final zzdrf zzh(zzady zzady) {
        this.zzd = zzady;
        return this;
    }

    public final zzdqv zzi() {
        return this.zzo;
    }

    public final zzdrf zzj(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzdrf zzk(int i) {
        this.zzm = i;
        return this;
    }

    public final zzdrf zzl(ArrayList<String> arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzdrf zzm(ArrayList<String> arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzdrf zzn(zzagy zzagy) {
        this.zzh = zzagy;
        return this;
    }

    public final zzdrf zzo(zzzd zzzd) {
        this.zzi = zzzd;
        return this;
    }

    public final zzdrf zzp(zzamv zzamv) {
        this.zzn = zzamv;
        this.zzd = new zzady(false, true, false);
        return this;
    }

    public final zzdrf zzq(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zza();
            this.zzl = publisherAdViewOptions.zzb();
        }
        return this;
    }

    public final zzdrf zzr(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzdrf zzs(zzdda zzdda) {
        this.zzq = zzdda;
        return this;
    }

    public final zzdrf zzt(zzdrg zzdrg) {
        this.zzo.zza(zzdrg.zzo.zza);
        this.zza = zzdrg.zzd;
        this.zzb = zzdrg.zze;
        this.zzr = zzdrg.zzq;
        this.zzc = zzdrg.zzf;
        this.zzd = zzdrg.zza;
        this.zzf = zzdrg.zzg;
        this.zzg = zzdrg.zzh;
        this.zzh = zzdrg.zzi;
        this.zzi = zzdrg.zzj;
        zzr(zzdrg.zzl);
        zzq(zzdrg.zzm);
        this.zzp = zzdrg.zzp;
        this.zzq = zzdrg.zzc;
        return this;
    }

    public final zzdrg zzu() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzdrg(this, (zzdre) null);
    }

    public final boolean zzv() {
        return this.zzp;
    }
}
