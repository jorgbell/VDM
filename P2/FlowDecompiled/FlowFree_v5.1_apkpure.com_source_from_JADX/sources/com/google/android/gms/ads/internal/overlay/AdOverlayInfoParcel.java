package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzajq;
import com.google.android.gms.internal.ads.zzajs;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzcni;
import com.google.android.gms.internal.ads.zzcvk;
import com.google.android.gms.internal.ads.zzdvo;
import com.google.android.gms.internal.ads.zzyi;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzo();
    public final zzc zza;
    public final zzyi zzb;
    public final zzp zzc;
    public final zzbgf zzd;
    public final zzajs zze;
    @RecentlyNonNull
    public final String zzf;
    public final boolean zzg;
    @RecentlyNonNull
    public final String zzh;
    public final zzw zzi;
    public final int zzj;
    public final int zzk;
    @RecentlyNonNull
    public final String zzl;
    public final zzbbq zzm;
    @RecentlyNonNull
    public final String zzn;
    public final zzj zzo;
    public final zzajq zzp;
    @RecentlyNonNull
    public final String zzq;
    public final zzcvk zzr;
    public final zzcni zzs;
    public final zzdvo zzt;
    public final zzbh zzu;
    @RecentlyNonNull
    public final String zzv;
    @RecentlyNonNull
    public final String zzw;

    public AdOverlayInfoParcel(zzyi zzyi, zzp zzp2, zzajq zzajq, zzajs zzajs, zzw zzw2, zzbgf zzbgf, boolean z, int i, String str, zzbbq zzbbq) {
        this.zza = null;
        this.zzb = zzyi;
        this.zzc = zzp2;
        this.zzd = zzbgf;
        this.zzp = zzajq;
        this.zze = zzajs;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzw2;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = zzbbq;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
    }

    @RecentlyNonNull
    public static AdOverlayInfoParcel zza(@RecentlyNonNull Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzb).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzc).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzd).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zze).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzi).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeIBinder(parcel, 20, ObjectWrapper.wrap(this.zzr).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 21, ObjectWrapper.wrap(this.zzs).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 22, ObjectWrapper.wrap(this.zzt).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 23, ObjectWrapper.wrap(this.zzu).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 24, this.zzv, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AdOverlayInfoParcel(zzyi zzyi, zzp zzp2, zzajq zzajq, zzajs zzajs, zzw zzw2, zzbgf zzbgf, boolean z, int i, String str, String str2, zzbbq zzbbq) {
        this.zza = null;
        this.zzb = zzyi;
        this.zzc = zzp2;
        this.zzd = zzbgf;
        this.zzp = zzajq;
        this.zze = zzajs;
        this.zzf = str2;
        this.zzg = z;
        this.zzh = str;
        this.zzi = zzw2;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = zzbbq;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
    }

    public AdOverlayInfoParcel(zzyi zzyi, zzp zzp2, zzw zzw2, zzbgf zzbgf, int i, zzbbq zzbbq, String str, zzj zzj2, String str2, String str3, String str4) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzp2;
        this.zzd = zzbgf;
        this.zzp = null;
        this.zze = null;
        this.zzf = str2;
        this.zzg = false;
        this.zzh = str3;
        this.zzi = null;
        this.zzj = i;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = zzbbq;
        this.zzn = str;
        this.zzo = zzj2;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = str4;
    }

    public AdOverlayInfoParcel(zzyi zzyi, zzp zzp2, zzw zzw2, zzbgf zzbgf, boolean z, int i, zzbbq zzbbq) {
        this.zza = null;
        this.zzb = zzyi;
        this.zzc = zzp2;
        this.zzd = zzbgf;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzw2;
        this.zzj = i;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = zzbbq;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
    }

    AdOverlayInfoParcel(zzc zzc2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzbbq zzbbq, String str4, zzj zzj2, IBinder iBinder6, String str5, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, IBinder iBinder10, String str6, String str7) {
        this.zza = zzc2;
        this.zzb = (zzyi) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzc = (zzp) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzd = (zzbgf) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzp = (zzajq) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zze = (zzajs) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzf = str;
        this.zzg = z;
        this.zzh = str2;
        this.zzi = (zzw) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.zzj = i;
        this.zzk = i2;
        this.zzl = str3;
        this.zzm = zzbbq;
        this.zzn = str4;
        this.zzo = zzj2;
        this.zzq = str5;
        this.zzv = str6;
        this.zzr = (zzcvk) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzs = (zzcni) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzt = (zzdvo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
        this.zzu = (zzbh) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder10));
        this.zzw = str7;
    }

    public AdOverlayInfoParcel(zzc zzc2, zzyi zzyi, zzp zzp2, zzw zzw2, zzbbq zzbbq, zzbgf zzbgf) {
        this.zza = zzc2;
        this.zzb = zzyi;
        this.zzc = zzp2;
        this.zzd = zzbgf;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzw2;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = zzbbq;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
    }

    public AdOverlayInfoParcel(zzp zzp2, zzbgf zzbgf, int i, zzbbq zzbbq) {
        this.zzc = zzp2;
        this.zzd = zzbgf;
        this.zzj = 1;
        this.zzm = zzbbq;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
    }

    public AdOverlayInfoParcel(zzbgf zzbgf, zzbbq zzbbq, zzbh zzbh, zzcvk zzcvk, zzcni zzcni, zzdvo zzdvo, String str, String str2, int i) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzbgf;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = i;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = zzbbq;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzv = str2;
        this.zzr = zzcvk;
        this.zzs = zzcni;
        this.zzt = zzdvo;
        this.zzu = zzbh;
        this.zzw = null;
    }
}
